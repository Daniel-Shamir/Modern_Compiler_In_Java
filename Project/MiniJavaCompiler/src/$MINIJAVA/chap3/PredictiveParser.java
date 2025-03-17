package $MINIJAVA.chap3;

import java.util.Scanner;

public class PredictiveParser {
    final int IF = 1, THEN = 2, ELSE = 3, BEGIN = 4, END = 5, PRINT = 6, SEMI = 7, NUM = 8, EQ = 9;
    int tok;
    int val;
    Scanner scanner;

    public PredictiveParser() {
        scanner = new Scanner(System.in);
    }

    void advance() {
        tok = getToken();
    }

    void eat(int t) {
        print();
        if (tok == t)
            advance();
        else error();
    }

    void S() {
        System.out.print("S -> ");
        switch(tok) {
            case IF:
                eat(IF); E(); eat(THEN); S(); eat(ELSE); S();
                break;
            case BEGIN:
                eat(BEGIN); S(); L();
                break;
            case PRINT:
                eat(PRINT); E();
                break;
            default:
                error();
        }
    }

    void L() {
        switch(tok) {
        case END:
            eat(END); break;
        case SEMI:
            eat(SEMI); S(); L();
            break;
        default:
            error();
        }
    }

    void E() {
        System.out.print("E -> ");
        eat(NUM);
        eat(EQ);
        eat(NUM);
    }

    int getToken() {
        String str = scanner.next();
        switch (str) {
            case "if":
                return IF;
            case "then":
                return THEN;
            case "else":
                return ELSE;
            case "begin":
                return BEGIN;
            case "end":
                return END;
            case "print":
                return PRINT;
            case ";":
                return SEMI;
            case "=":
                return EQ;
            default: {
                val =  Integer.valueOf(str);
                return NUM;
            }
        }
    }

    void error() {
        throw new RuntimeException("Error with token " + tok);
    }

    void print() {
        switch (tok) {
            case IF:
                System.out.print("IF -> ");
                break;
            case THEN:
                System.out.print("THEN -> ");
                break;
            case ELSE:
                System.out.print("ELSE -> ");
                break;
            case BEGIN:
                System.out.print("BEGIN -> ");
                break;
            case END:
                System.out.print("END -> ");
                break;
            case PRINT:
                System.out.print("PRINT -> ");
                break;
            case SEMI:
                System.out.print("SEMI -> ");
                break;
            case NUM:
                System.out.print("NUM(" + val + ") -> ");
                break;
            case EQ:
                System.out.print("EQ -> ");
                break;
        }
    }

    public static void main(String[] args) {
        PredictiveParser parser = new PredictiveParser();

        /*
        Strings to try:
            print 3 = 4
            if 1 = 2 then print 3 = 4 else print 5 = 6
            begin print 1 = 2 ; print 3 = 4 end

         */

        try {
            while (true) {
                parser.advance();
                parser.S();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
