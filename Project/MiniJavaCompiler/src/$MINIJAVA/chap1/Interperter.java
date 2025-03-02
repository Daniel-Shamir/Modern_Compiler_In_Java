package $MINIJAVA.chap1;

public class Interperter {

    // NOTE(daniel): returns the maximum number of arguments of any print statement within any subexpression of s.
    // that is, what's the largest number of arguments that print might need to hold
    public int maxargs(Stm s) {
        if(s instanceof CompoundStm) {
            int max1 = maxargs(((CompoundStm) s).stm1);
            int max2 = maxargs(((CompoundStm) s).stm2);
            return max1 > max2 ? max1 : max2;
        }
        if(s instanceof AssignStm) {
            return maxargs(((AssignStm) s).exp);
        }
        if(s instanceof PrintStm) {
            int max1 = ((PrintStm) s).exps.count();
            int max2 = maxargs(((PrintStm) s).exps);
            return max1 > max2 ? max1 : max2;
        }

        return 0;
    }

    public int maxargs(Exp e) {
        if(e instanceof OpExp) {
            int max1 = maxargs(((OpExp) e).right);
            int max2 = maxargs(((OpExp) e).left);
            return max1 > max2 ? max1 : max2;
        }
        if(e instanceof EseqExp) {
            int max1 = maxargs(((EseqExp) e).stm);
            int max2 = maxargs(((EseqExp) e).exp);
            return max1 > max2 ? max1 : max2;
        }

        return 0;
    }

    public int maxargs(ExpList el) {
        if(el instanceof PairExpList) {
            int max1 = maxargs(((PairExpList) el).tail);
            int max2 = maxargs(((PairExpList) el).head);
            return max1 > max2 ? max1 : max2;
        }
        if(el instanceof LastExpList) {
            return maxargs(((LastExpList) el).head);
        }

        return 0;
    }

    public void interp(Stm s) {
        interpStm(s, null);
    }

    public Table interpStm(Stm s, Table t) {
        if(s instanceof CompoundStm) {
            Table t1 = interpStm(((CompoundStm) s).stm1, t);
            Table t2 = interpStm(((CompoundStm) s).stm2, t1);
            return t2;
        }
        if(s instanceof AssignStm) {
            IntAndTable it = interpExp(((AssignStm) s).exp, t);
            Table t1 = new Table(((AssignStm) s).id, it.i, it.t);
            return t1;
        }
        if(s instanceof PrintStm) {
            Table t1 = interpExpList(((PrintStm) s).exps, t);
            return t1;
        }

        return t;
    }

    public IntAndTable interpExp(Exp e, Table t) {
        if(e instanceof NumExp) {
            return new IntAndTable(((NumExp) e).num, t);
        }
        if(e instanceof IdExp) {
            return new IntAndTable(t.lookup(((IdExp) e).id), t);
        }
        if(e instanceof OpExp) {
            IntAndTable it1 = interpExp(((OpExp) e).left, t);
            IntAndTable it2 = interpExp(((OpExp) e).right, it1.t);

            switch (((OpExp) e).op) {
                case OpExp.Plus:
                    return new IntAndTable(it1.i + it2.i, it2.t);
                case OpExp.Minus:
                    return new IntAndTable(it1.i - it2.i, it2.t);
                case OpExp.Times:
                    return new IntAndTable(it1.i * it2.i, it2.t);
                case OpExp.Div:
                    return new IntAndTable(it1.i / it2.i, it2.t);
            }
        }
        if(e instanceof EseqExp) {
            Table t1 = interpStm(((EseqExp) e).stm, t);
            IntAndTable it1 = interpExp(((EseqExp) e).exp, t1);
            return it1;
        }

        // NOTE(daniel): e isn't an expression that has a value, so ignore the 0
        return new IntAndTable(0, t);
    }

    public Table interpExpList(ExpList el, Table t) {
        if(el instanceof PairExpList) {
            IntAndTable it = interpExp(((PairExpList) el).head, t);
            System.out.print(it.i + " ");

            Table t1 = interpExpList(((PairExpList) el).tail, t);
            return t1;
        }
        if(el instanceof LastExpList) {
            IntAndTable it = interpExp(((LastExpList) el).head, t);
            System.out.println(it.i);

            return it.t;
        }

        return t;
    }

    // NOTE(daniel): essentially a linked list of (key,value) pairs, like the "environment" of the program
    public class Table {
        String id;
        int value;
        Table tail;
        public Table(String id, int value, Table tail) {
            this.id = id;
            this.value = value;
            this.tail = tail;
        }

        public int lookup(String key) {
            if(key.equals(id)) {
                return value;
            } else {
                return tail.lookup(key);
            }
        }
    }

    public class IntAndTable {
        int i;
        Table t;
        public IntAndTable(int i, Table t) {
            this.i = i;
            this.t = t;
        }
    }
}
