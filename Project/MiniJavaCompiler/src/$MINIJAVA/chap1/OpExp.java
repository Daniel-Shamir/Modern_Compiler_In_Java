package $MINIJAVA.chap1;

public class OpExp extends Exp {
    public Exp left, right;
    public int op;
    public final static int Plus=1, Minus=2, Times=3, Div=4;
    public OpExp(Exp left, int op, Exp right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
}
