package $MINIJAVA.chap2.MiniJavaLexer;

public class Main {
    public static void main(String [] args) {
        try {
            new MiniJavaLexer(System.in).Goal();
            System.out.println("Lexical analysis successfull");
        } catch (ParseException e) {
            System.out.println("Lexer Error : \n"+ e.toString());
        } catch (TokenMgrError e) {
            System.out.println("TokenMgrError : \n"+ e.toString());
        } catch (Exception e) {
            System.out.println("Exception : \n"+ e.toString());
        }
    }
}


