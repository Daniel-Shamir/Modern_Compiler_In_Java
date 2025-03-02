package $MINIJAVA.chap1;

public class EseqExp extends Exp {
    public Stm stm;
    public Exp exp;
    public EseqExp(Stm stm, Exp exp) {
        this.stm = stm;
        this.exp = exp;
    }
}
