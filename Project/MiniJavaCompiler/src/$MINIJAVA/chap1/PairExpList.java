package $MINIJAVA.chap1;

public class PairExpList extends ExpList {
    public Exp head;
    public ExpList tail;
    public PairExpList(Exp head, ExpList tail) {
        this.head = head;
        this.tail = tail;
    }

    public int count() {
        return tail.count() + 1;
    }
}
