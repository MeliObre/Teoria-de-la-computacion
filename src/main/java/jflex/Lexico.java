/* The following code was generated by JFlex 1.7.0 */

package jflex;
import equipo6.TokenConstants;
import equipo6.Token;
import java_cup.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Lexico.flex</tt>
 */
public class Lexico {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\2\11\1\0\2\11\22\0\1\11\1\23\1\12\5\0\1\13"+
    "\1\14\1\4\1\17\1\50\1\20\1\5\1\3\1\6\1\10\10\2"+
    "\1\25\1\0\1\21\1\24\1\22\2\0\1\46\1\26\1\45\1\33"+
    "\1\27\1\40\1\30\1\35\1\31\2\1\1\36\1\47\1\32\1\37"+
    "\1\44\1\1\1\43\1\42\1\41\2\1\1\34\3\1\1\15\1\0"+
    "\1\16\3\0\1\1\1\7\30\1\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff95\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\1\1\3"+
    "\1\6\1\1\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\3\1\13\2\1\17\1\20\3\0\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\0\4\2\1\27"+
    "\1\2\1\30\2\2\1\31\6\2\1\0\1\32\1\33"+
    "\1\2\1\34\1\2\1\35\10\2\1\36\2\0\3\2"+
    "\1\37\4\2\1\40\3\2\2\0\1\41\3\2\1\42"+
    "\1\43\1\44\3\2\1\0\1\6\3\2\1\45\2\2"+
    "\6\0\3\2\1\46\1\2\1\6\3\0\2\2\2\0"+
    "\1\6\1\0\2\2\4\0\2\2\7\0\1\6\16\0"+
    "\1\47\1\50\4\0\1\51\1\52";

  private static int [] zzUnpackAction() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\51\0\122\0\173\0\244\0\51\0\315\0\366"+
    "\0\u011f\0\u0148\0\51\0\51\0\51\0\51\0\51\0\51"+
    "\0\u0171\0\u019a\0\u01c3\0\u01ec\0\u0215\0\u023e\0\u0267\0\u0290"+
    "\0\u02b9\0\u02e2\0\u030b\0\u0334\0\u035d\0\u0386\0\u03af\0\u03d8"+
    "\0\51\0\315\0\u0401\0\u042a\0\u0148\0\51\0\51\0\51"+
    "\0\51\0\51\0\51\0\u0453\0\u047c\0\u04a5\0\u04ce\0\u04f7"+
    "\0\122\0\u0520\0\122\0\u0549\0\u0572\0\122\0\u059b\0\u05c4"+
    "\0\u05ed\0\u0616\0\u063f\0\u0668\0\u0691\0\u042a\0\51\0\u06ba"+
    "\0\u06e3\0\u070c\0\122\0\u0735\0\u075e\0\u0787\0\u07b0\0\u07d9"+
    "\0\u0802\0\u082b\0\u0854\0\122\0\u087d\0\u08a6\0\u08cf\0\u08f8"+
    "\0\u0921\0\122\0\u094a\0\u0973\0\u099c\0\u09c5\0\122\0\u09ee"+
    "\0\u0a17\0\u0a40\0\u0a69\0\u0a92\0\122\0\u0abb\0\u0ae4\0\u0b0d"+
    "\0\122\0\122\0\122\0\u0b36\0\u0b5f\0\u0b88\0\u0bb1\0\u0bda"+
    "\0\u0c03\0\u0c2c\0\u0c55\0\122\0\u0c7e\0\u0ca7\0\u0cd0\0\u0cf9"+
    "\0\u0d22\0\u0d4b\0\u0bda\0\u0d74\0\u0d9d\0\u0dc6\0\u0def\0\122"+
    "\0\u0e18\0\u0d74\0\u0e41\0\u0e6a\0\u0e93\0\u0ebc\0\u0ee5\0\u0f0e"+
    "\0\u0f37\0\u0f60\0\u0f89\0\u0fb2\0\u0fdb\0\u1004\0\u102d\0\u0f60"+
    "\0\u1056\0\u107f\0\u10a8\0\u10d1\0\u10fa\0\u1123\0\u114c\0\u1175"+
    "\0\u119e\0\u11c7\0\51\0\u11f0\0\u1219\0\u1242\0\u126b\0\u1294"+
    "\0\u12bd\0\u12e6\0\u130f\0\u1338\0\u1361\0\u138a\0\u13b3\0\u13dc"+
    "\0\u1405\0\51\0\51\0\u142e\0\u1457\0\u1480\0\u14a9\0\51"+
    "\0\51";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\3"+
    "\1\4\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\3\1\30\1\3\1\31\1\32\2\3\1\33\1\34"+
    "\1\35\1\36\1\3\1\37\1\3\1\40\1\3\1\41"+
    "\52\0\2\3\3\0\3\3\15\0\22\3\3\0\1\4"+
    "\2\0\1\42\1\4\1\0\1\4\43\0\1\43\47\0"+
    "\1\42\3\0\1\42\1\0\1\42\42\0\1\4\2\0"+
    "\1\42\1\4\1\44\1\4\51\0\1\11\37\0\12\45"+
    "\1\46\36\45\24\0\1\47\50\0\1\50\50\0\1\51"+
    "\50\0\1\52\50\0\1\53\1\54\24\0\2\3\3\0"+
    "\3\3\15\0\1\3\1\55\20\3\2\0\2\3\3\0"+
    "\3\3\15\0\4\3\1\56\3\3\1\57\11\3\2\0"+
    "\2\3\3\0\3\3\15\0\4\3\1\60\5\3\1\61"+
    "\7\3\2\0\2\3\3\0\3\3\15\0\1\3\1\62"+
    "\7\3\1\63\10\3\2\0\2\3\3\0\3\3\15\0"+
    "\7\3\1\64\5\3\1\65\4\3\2\0\2\3\3\0"+
    "\3\3\15\0\15\3\1\66\4\3\2\0\2\3\3\0"+
    "\3\3\15\0\10\3\1\67\11\3\2\0\2\3\3\0"+
    "\3\3\15\0\7\3\1\70\12\3\2\0\2\3\3\0"+
    "\3\3\15\0\13\3\1\71\6\3\2\0\2\3\3\0"+
    "\3\3\15\0\1\3\1\72\13\3\1\73\4\3\2\0"+
    "\2\3\3\0\3\3\15\0\4\3\1\74\15\3\5\0"+
    "\1\75\52\0\1\76\1\0\1\76\64\0\1\77\25\0"+
    "\2\3\3\0\3\3\15\0\2\3\1\100\17\3\2\0"+
    "\2\3\3\0\3\3\15\0\5\3\1\101\14\3\2\0"+
    "\2\3\3\0\3\3\15\0\14\3\1\102\5\3\2\0"+
    "\2\3\3\0\3\3\15\0\13\3\1\103\6\3\2\0"+
    "\2\3\3\0\3\3\15\0\17\3\1\104\2\3\2\0"+
    "\2\3\3\0\3\3\15\0\3\3\1\105\16\3\2\0"+
    "\2\3\3\0\3\3\15\0\3\3\1\106\16\3\2\0"+
    "\2\3\3\0\3\3\15\0\11\3\1\107\10\3\2\0"+
    "\2\3\3\0\3\3\15\0\1\3\1\110\20\3\2\0"+
    "\2\3\3\0\3\3\15\0\15\3\1\111\4\3\2\0"+
    "\2\3\3\0\3\3\15\0\15\3\1\112\4\3\2\0"+
    "\2\3\3\0\3\3\15\0\11\3\1\113\10\3\2\0"+
    "\2\3\3\0\3\3\15\0\5\3\1\114\14\3\1\0"+
    "\3\75\1\115\1\116\44\75\1\0\2\3\3\0\3\3"+
    "\15\0\3\3\1\117\16\3\2\0\2\3\3\0\3\3"+
    "\15\0\5\3\1\120\10\3\1\121\3\3\2\0\2\3"+
    "\3\0\3\3\15\0\1\3\1\122\20\3\2\0\2\3"+
    "\3\0\3\3\15\0\10\3\1\123\11\3\2\0\2\3"+
    "\3\0\3\3\15\0\10\3\1\124\11\3\2\0\2\3"+
    "\3\0\3\3\15\0\13\3\1\125\6\3\2\0\2\3"+
    "\3\0\3\3\15\0\20\3\1\126\1\3\2\0\2\3"+
    "\3\0\3\3\15\0\4\3\1\127\15\3\2\0\2\3"+
    "\3\0\3\3\15\0\3\3\1\130\16\3\2\0\2\3"+
    "\3\0\3\3\15\0\17\3\1\131\2\3\2\0\2\3"+
    "\3\0\3\3\15\0\2\3\1\132\17\3\1\0\3\75"+
    "\1\133\1\116\47\75\1\134\1\116\44\75\1\0\2\3"+
    "\3\0\3\3\15\0\4\3\1\135\15\3\2\0\2\3"+
    "\3\0\3\3\15\0\1\3\1\136\20\3\2\0\2\3"+
    "\3\0\3\3\15\0\15\3\1\137\4\3\2\0\2\3"+
    "\3\0\3\3\15\0\20\3\1\140\1\3\2\0\2\3"+
    "\3\0\3\3\15\0\1\3\1\141\20\3\2\0\2\3"+
    "\3\0\3\3\15\0\1\3\1\142\20\3\2\0\2\3"+
    "\3\0\3\3\15\0\13\3\1\143\6\3\2\0\2\3"+
    "\3\0\3\3\15\0\4\3\1\144\15\3\2\0\2\3"+
    "\3\0\3\3\15\0\1\3\1\145\20\3\2\0\2\3"+
    "\3\0\3\3\15\0\15\3\1\146\4\3\1\0\3\75"+
    "\1\133\1\147\47\75\1\150\1\116\44\75\1\0\2\3"+
    "\3\0\3\3\15\0\17\3\1\151\2\3\2\0\2\3"+
    "\3\0\3\3\15\0\11\3\1\152\10\3\2\0\2\3"+
    "\3\0\3\3\15\0\15\3\1\153\4\3\2\0\2\3"+
    "\3\0\3\3\15\0\2\3\1\154\17\3\2\0\2\3"+
    "\3\0\3\3\15\0\4\3\1\155\15\3\2\0\2\3"+
    "\3\0\3\3\15\0\20\3\1\156\1\3\1\0\3\157"+
    "\1\160\1\161\44\157\3\162\1\163\1\164\44\162\1\0"+
    "\2\3\3\0\3\3\15\0\10\3\1\165\11\3\2\0"+
    "\2\3\3\0\3\3\15\0\2\3\1\166\17\3\2\0"+
    "\2\3\3\0\3\3\15\0\1\3\1\167\20\3\2\0"+
    "\2\3\3\0\3\3\15\0\13\3\1\170\6\3\2\0"+
    "\2\3\3\0\3\3\15\0\21\3\1\171\1\0\4\157"+
    "\1\161\47\157\1\172\1\161\47\157\1\173\1\161\44\157"+
    "\3\162\1\174\45\162\4\164\1\175\44\164\1\0\2\3"+
    "\3\0\3\3\15\0\20\3\1\176\1\3\2\0\2\3"+
    "\3\0\3\3\15\0\15\3\1\177\4\3\2\0\2\3"+
    "\2\0\1\200\3\3\15\0\22\3\2\0\2\3\2\0"+
    "\1\201\3\3\15\0\22\3\1\0\3\157\1\202\1\161"+
    "\44\157\3\162\1\163\45\162\3\164\1\203\1\175\44\164"+
    "\1\0\2\3\3\0\3\3\15\0\15\3\1\204\4\3"+
    "\2\0\2\3\3\0\3\3\15\0\20\3\1\205\1\3"+
    "\43\0\1\206\50\0\1\207\6\0\4\210\1\211\44\210"+
    "\3\164\1\210\1\175\44\164\1\0\2\3\3\0\3\3"+
    "\15\0\1\3\1\212\20\3\2\0\2\3\3\0\3\3"+
    "\15\0\21\3\1\213\30\0\1\214\50\0\1\215\21\0"+
    "\3\210\1\216\1\211\44\210\1\0\2\3\2\0\1\217"+
    "\3\3\15\0\22\3\2\0\2\3\2\0\1\220\3\3"+
    "\15\0\22\3\46\0\1\221\50\0\1\222\3\0\3\210"+
    "\1\223\1\211\44\210\42\0\1\224\50\0\1\225\47\0"+
    "\1\226\50\0\1\227\36\0\1\230\50\0\1\231\52\0"+
    "\1\232\50\0\1\233\64\0\1\234\50\0\1\235\42\0"+
    "\1\236\50\0\1\237\52\0\1\240\50\0\1\241\41\0"+
    "\1\242\50\0\1\243\47\0\1\244\50\0\1\245\56\0"+
    "\1\246\50\0\1\247\43\0\1\250\50\0\1\251\16\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5330];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\4\1\6\11\20\1\1\11"+
    "\1\1\3\0\6\11\1\0\20\1\1\0\1\1\1\11"+
    "\15\1\2\0\14\1\2\0\12\1\1\0\7\1\6\0"+
    "\6\1\3\0\2\1\2\0\1\1\1\0\2\1\4\0"+
    "\2\1\7\0\1\11\16\0\2\11\4\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexico(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 144) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Token yylex() throws java.io.IOException, ErrorEnt, ErrorReal {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
          {    return new Token(TokenConstants.EOF, null);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new Error("Caracter no permitido: <" + yytext() + "> en la linea " + (yyline+1));
            } 
            // fall through
          case 43: break;
          case 2: 
            { return new Token(TokenConstants.ID, yytext());
            } 
            // fall through
          case 44: break;
          case 3: 
            { Token token =  new Token(TokenConstants.CTE_ENT, yytext());
        try {
                    short valorShort = Short.parseShort(yytext());
                    return token;
                } catch (NumberFormatException e) {
                    throw new ErrorEnt("Rango entero no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                }
            } 
            // fall through
          case 45: break;
          case 4: 
            { return new Token(TokenConstants.OP_DIV, yytext());
            } 
            // fall through
          case 46: break;
          case 5: 
            { return new Token(TokenConstants.OP_MUL, yytext());
            } 
            // fall through
          case 47: break;
          case 6: 
            { /* NADA NADA NADA*/
            } 
            // fall through
          case 48: break;
          case 7: 
            { return new Token(TokenConstants.PAR_ABR, yytext());
            } 
            // fall through
          case 49: break;
          case 8: 
            { return new Token(TokenConstants.PAR_CIE, yytext());
            } 
            // fall through
          case 50: break;
          case 9: 
            { return new Token(TokenConstants.COR_ABR, yytext());
            } 
            // fall through
          case 51: break;
          case 10: 
            { return new Token(TokenConstants.COR_CIE, yytext());
            } 
            // fall through
          case 52: break;
          case 11: 
            { return new Token(TokenConstants.OP_SUM, yytext());
            } 
            // fall through
          case 53: break;
          case 12: 
            { return new Token(TokenConstants.OP_RES, yytext());
            } 
            // fall through
          case 54: break;
          case 13: 
            { return new Token(TokenConstants.OP_MEN, yytext());
            } 
            // fall through
          case 55: break;
          case 14: 
            { return new Token(TokenConstants.OP_MAY, yytext());
            } 
            // fall through
          case 56: break;
          case 15: 
            { return new Token(TokenConstants.COMA, yytext());
            } 
            // fall through
          case 57: break;
          case 16: 
            { Token token = new Token(TokenConstants.CTE_REA, yytext());
        try {
                    float valorFloat = Float.parseFloat(yytext());
                    // Validar si está dentro del rango de float
                    if (valorFloat >= -Float.MAX_VALUE && valorFloat <= Float.MAX_VALUE && !Float.isNaN(valorFloat) && !Float.isInfinite(valorFloat)) {
                        return token;
                    } else {
                        throw new ErrorReal("Rango real no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                    }
                } catch (NumberFormatException e) {
                    throw new ErrorReal("Rango real no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                }
            } 
            // fall through
          case 58: break;
          case 17: 
            { Token token = new Token(TokenConstants.CTE_STR, yytext());
                    String str = token.getLexeme();
                    if(str.length() <= 32){//queda 32 porque se cuentan ambas comillas y el limite de string queda en 30
                        return token;
                    }else{
                        throw new ErrorString("Rango String no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                    }
            } 
            // fall through
          case 59: break;
          case 18: 
            { return new Token(TokenConstants.OP_MENIG, yytext());
            } 
            // fall through
          case 60: break;
          case 19: 
            { return new Token(TokenConstants.OP_MAYIG, yytext());
            } 
            // fall through
          case 61: break;
          case 20: 
            { return new Token(TokenConstants.OP_DIST, yytext());
            } 
            // fall through
          case 62: break;
          case 21: 
            { return new Token(TokenConstants.OP_IGU, yytext());
            } 
            // fall through
          case 63: break;
          case 22: 
            { return new Token(TokenConstants.ASIG_VAR, yytext());
            } 
            // fall through
          case 64: break;
          case 23: 
            { return new Token(TokenConstants.IF, yytext());
            } 
            // fall through
          case 65: break;
          case 24: 
            { return new Token(TokenConstants.DO, yytext());
            } 
            // fall through
          case 66: break;
          case 25: 
            { return new Token(TokenConstants.OR, yytext());
            } 
            // fall through
          case 67: break;
          case 26: 
            { return new Token(TokenConstants.CTE_BIN, yytext());
            } 
            // fall through
          case 68: break;
          case 27: 
            { return new Token(TokenConstants.ASIG_TIPO, yytext());
            } 
            // fall through
          case 69: break;
          case 28: 
            { return new Token(TokenConstants.END, yytext());
            } 
            // fall through
          case 70: break;
          case 29: 
            { return new Token(TokenConstants.ASIG_INT, yytext());
            } 
            // fall through
          case 71: break;
          case 30: 
            { return new Token(TokenConstants.AND, yytext());
            } 
            // fall through
          case 72: break;
          case 31: 
            { return new Token(TokenConstants.ELSE, yytext());
            } 
            // fall through
          case 73: break;
          case 32: 
            { return new Token(TokenConstants.THEN, yytext());
            } 
            // fall through
          case 74: break;
          case 33: 
            { return new Token(TokenConstants.BEGIN, yytext());
            } 
            // fall through
          case 75: break;
          case 34: 
            { return new Token(TokenConstants.WHILE, yytext());
            } 
            // fall through
          case 76: break;
          case 35: 
            { return new Token(TokenConstants.WRITE, yytext());
            } 
            // fall through
          case 77: break;
          case 36: 
            { return new Token(TokenConstants.ASIG_FL, yytext());
            } 
            // fall through
          case 78: break;
          case 37: 
            { return new Token(TokenConstants.ASIG_STR, yytext());
            } 
            // fall through
          case 79: break;
          case 38: 
            { return new Token(TokenConstants.PERCENT, yytext());
            } 
            // fall through
          case 80: break;
          case 39: 
            { return new Token(TokenConstants.SEC_DEC, yytext());
            } 
            // fall through
          case 81: break;
          case 40: 
            { return new Token(TokenConstants.SEC_PROG, yytext());
            } 
            // fall through
          case 82: break;
          case 41: 
            { return new Token(TokenConstants.SEC_END, yytext());
            } 
            // fall through
          case 83: break;
          case 42: 
            { return new Token(TokenConstants.SEC_ENDPROG, yytext());
            } 
            // fall through
          case 84: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
