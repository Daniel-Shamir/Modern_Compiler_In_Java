package $MINIJAVA.chap1;

public class Main {
    public static void main(String[] args) {
        testMaxargs();
        testInterp();
    }

    public static void testMaxargs() {
        Interperter interperter = new Interperter();

        System.out.println("Testing the maxargs function");

        // NOTE(daniel): a := 5 + 3; b := (print (a , a - 1) , 10 * a) ; print(b)
        Stm prog1 =
                new CompoundStm(new AssignStm("a",
                        new OpExp(new NumExp(5),
                                OpExp.Plus, new NumExp(3))),
                        new CompoundStm(new AssignStm("b",
                                new EseqExp(new PrintStm(new PairExpList(new IdExp("a"),
                                        new LastExpList(new OpExp(new IdExp("a"),
                                                OpExp.Minus,new NumExp(1))))),
                                        new OpExp(new NumExp(10), OpExp.Times,
                                                new IdExp("a")))),
                                new PrintStm(new LastExpList(new IdExp("b")))));

        System.out.println("maxargs(prog1) = " + interperter.maxargs(prog1));

        // NOTE(daniel): a := (print (1) , (print (2 , 3, 4), 10)); print(a)
        Stm prog2 =
                new CompoundStm(
                        new AssignStm("a",
                                new EseqExp(new PrintStm(
                                        new LastExpList(new NumExp(1))),
                                        new EseqExp(
                                                new PrintStm(
                                                        new PairExpList(
                                                                new NumExp(2),
                                                                new PairExpList(
                                                                        new NumExp(3),
                                                                        new LastExpList(new NumExp(4))
                                                                )
                                                        )
                                                ), new NumExp(10)
                                        ))),
                        new PrintStm(new LastExpList(new IdExp("a"))));

        System.out.println("maxargs(prog2) = " + interperter.maxargs(prog2));
    }

    public static void testInterp() {
        Interperter interperter = new Interperter();

        System.out.println("Testing the interp function");

        // NOTE(daniel): a := 5 + 3; b := (print (a , a - 1) , 10 * a) ; print(b)
        Stm prog1 =
                new CompoundStm(new AssignStm("a",
                        new OpExp(new NumExp(5),
                                OpExp.Plus, new NumExp(3))),
                        new CompoundStm(new AssignStm("b",
                                new EseqExp(new PrintStm(new PairExpList(new IdExp("a"),
                                        new LastExpList(new OpExp(new IdExp("a"),
                                                OpExp.Minus,new NumExp(1))))),
                                        new OpExp(new NumExp(10), OpExp.Times,
                                                new IdExp("a")))),
                                new PrintStm(new LastExpList(new IdExp("b")))));

        interperter.interp(prog1);

        // NOTE(daniel): a := (1 + (12 / 6)) * 5; b := (print (a), 0 - a); print(b)
        Stm prog2 =
                new CompoundStm(
                        new AssignStm("a",
                                new OpExp(
                                        new OpExp(
                                                new NumExp(1),
                                                OpExp.Plus,
                                                new OpExp(
                                                        new NumExp(12),
                                                        OpExp.Div,
                                                        new NumExp(6)
                                                )
                                        ),
                                        OpExp.Times,
                                        new NumExp(5))
                                ),
                        new CompoundStm(
                                new AssignStm(
                                        "b",
                                        new EseqExp(
                                                new PrintStm(
                                                        new LastExpList(new IdExp("a"))
                                                ),
                                                new OpExp(
                                                        new NumExp(0),
                                                        OpExp.Minus,
                                                        new IdExp("a")
                                                )
                                        )
                                ),
                                new PrintStm(
                                        new LastExpList(
                                                new IdExp("b")
                                        )
                                )
                        )
                );

        interperter.interp(prog2);
    }
}
