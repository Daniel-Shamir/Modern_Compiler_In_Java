package $MINIJAVA.chap1;

public class LastExpList extends ExpList {
    public Exp head;
    public LastExpList(Exp head) {
        this.head = head;
    }

    public int count() {
        return 1;
    }
}
