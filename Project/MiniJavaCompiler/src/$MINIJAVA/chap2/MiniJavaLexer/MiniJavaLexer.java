/* MiniJavaLexer.java */
/* Generated By:JavaCC: Do not edit this line. MiniJavaLexer.java */
  package $MINIJAVA.chap2.MiniJavaLexer;
  public class MiniJavaLexer implements MiniJavaLexerConstants {

// The following is a simple grammar that will allow you
// to test the generated lexer.
  static final public 

void Goal() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFIER:
      case INTEGER_LITERAL:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      MiniJavaToken();
    }
    jj_consume_token(0);
}

  static final public void MiniJavaToken() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 5:{
      jj_consume_token(5);
      break;
      }
    case IDENTIFIER:{
      jj_consume_token(IDENTIFIER);
      break;
      }
    case 6:{
      jj_consume_token(6);
      break;
      }
    case 7:{
      jj_consume_token(7);
      break;
      }
    case 8:{
      jj_consume_token(8);
      break;
      }
    case 9:{
      jj_consume_token(9);
      break;
      }
    case 10:{
      jj_consume_token(10);
      break;
      }
    case 11:{
      jj_consume_token(11);
      break;
      }
    case 12:{
      jj_consume_token(12);
      break;
      }
    case 13:{
      jj_consume_token(13);
      break;
      }
    case 14:{
      jj_consume_token(14);
      break;
      }
    case 15:{
      jj_consume_token(15);
      break;
      }
    case 16:{
      jj_consume_token(16);
      break;
      }
    case 17:{
      jj_consume_token(17);
      break;
      }
    case 18:{
      jj_consume_token(18);
      break;
      }
    case 19:{
      jj_consume_token(19);
      break;
      }
    case 20:{
      jj_consume_token(20);
      break;
      }
    case 21:{
      jj_consume_token(21);
      break;
      }
    case 22:{
      jj_consume_token(22);
      break;
      }
    case 23:{
      jj_consume_token(23);
      break;
      }
    case 24:{
      jj_consume_token(24);
      break;
      }
    case 25:{
      jj_consume_token(25);
      break;
      }
    case 26:{
      jj_consume_token(26);
      break;
      }
    case 27:{
      jj_consume_token(27);
      break;
      }
    case 28:{
      jj_consume_token(28);
      break;
      }
    case 29:{
      jj_consume_token(29);
      break;
      }
    case 30:{
      jj_consume_token(30);
      break;
      }
    case 31:{
      jj_consume_token(31);
      break;
      }
    case 32:{
      jj_consume_token(32);
      break;
      }
    case 33:{
      jj_consume_token(33);
      break;
      }
    case 34:{
      jj_consume_token(34);
      break;
      }
    case INTEGER_LITERAL:{
      jj_consume_token(INTEGER_LITERAL);
      break;
      }
    case 35:{
      jj_consume_token(35);
      break;
      }
    case 36:{
      jj_consume_token(36);
      break;
      }
    case 37:{
      jj_consume_token(37);
      break;
      }
    case 38:{
      jj_consume_token(38);
      break;
      }
    case 39:{
      jj_consume_token(39);
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MiniJavaLexerTokenManager token_source;
  static JavaCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[2];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0xfffffff8,0xfffffff8,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0xff,0xff,};
	}

  /** Constructor with InputStream. */
  public MiniJavaLexer(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MiniJavaLexer(java.io.InputStream stream, String encoding) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser.  ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new MiniJavaLexerTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public MiniJavaLexer(java.io.Reader stream) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 jj_input_stream = new JavaCharStream(stream, 1, 1);
	 token_source = new MiniJavaLexerTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new JavaCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new MiniJavaLexerTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public MiniJavaLexer(MiniJavaLexerTokenManager tm) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MiniJavaLexerTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  static private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[40];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 2; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 40; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  static private boolean trace_enabled;

/** Trace enabled. */
  static final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

                              }
