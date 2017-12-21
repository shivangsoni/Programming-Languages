/* *** This file is given as part of the programming assignment. *** */

public class Parser {
    // tok is global to all these parsing methods;
    // scan just calls the scanner's scan method and saves the result in tok.
    private Token tok; // the current token
    //private hashtable datatype and var name
    //symbol table is key value data structure
     private String[] a=new String[100];
     private int count=0;
     private int[] values=new int[100];
     private int countif=0;
     private int var;
     //Vector<String> vector = new Vector<>();
     //treat stack as a vector.
    private void scan() {
	tok = scanner.scan();
	//System.out.println(tok);
    }
    private int popele=0;
    private Scan scanner;
    Parser(Scan scanner) {
	this.scanner = scanner;
	scan();
	program();
	if( tok.kind != TK.EOF )
	    parse_error("junk after logical end of program");
    }

    private void program() {
        System.out.println("#include<stdio.h>");
        System.out.println("int main()");
         if(is(TK.ID) && count==0)
         {
            parse_undeclare(tok.string + " ");
         }
         for(int i=0;i<100;i++)
         {
             values[i]=0;
         }
	     block();
    }

    private void block(){
    System.out.println("{");
	declaration_list();
	statement_list();
	System.out.println("}");
    }

    private void declaration_list() {
	// below checks whether tok is in first set of declaration.
	// here, that's easy since there's only one token kind in the set.
	// in other places, though, there might be more.
	// so, you might want to write a general function to handle that.
	while( is(TK.DECLARE) ) {
	    declaration();
	 }
    }

    private void declaration() {
	mustbe(TK.DECLARE);
	a[count++]=tok.string;
	values[count-1]++;
	//System.out.println(a[count-1]);
	mustbe(TK.ID);
	//a[count++]=tok.string;
	while( is(TK.COMMA) ) {
	    scan();
	    int flag=0;
	    for(int i=0;i<count;i++)
	    {
	        if(a[i].equals(tok.string))
	        {
	            flag=1;
	            break;
	            //System.out.println(tok.string);
	        }
	    }
	    if(flag==1)
	    {
	     System.out.println("redeclaration of variable "+ tok.string);
	     scan();
	    }
	    else if(flag==0)
	    {
	     a[count++]=tok.string;
	     values[count-1]++;
	     mustbe(TK.ID);
	    }
	 }
    }
    private void statement_list() {
        while(is(TK.FOR)||is(TK.PRINT)||is(TK.ID)||is(TK.DO)||is(TK.IF)||is(TK.TILDE))
        {
          statement();
        }
    }
    
     private void statement()
     {
         if(is(TK.ID))
         {
            int flag=1;
            for(int i=0;i<count;i++)
            {
                if(a[i].equals(tok.string))
                {
                    flag=0;
                }
            }
            if(flag==1 && count>0)
            parse_undeclare(tok.string + " ");
         }
            if(is(TK.ID)||is(TK.TILDE))
            {
             assignment();
            }
            else if(is(TK.DO)) 
             {
                doo();
             }
         else if(is(TK.IF))
         {
             iff();
         }
         else if(is(TK.PRINT))
         {
             print();
         }
         else if(is(TK.FOR))
         {
             forr();
         }
     }
     
     private void forr()
     {
    	mustbe(TK.FOR);
    	System.out.print("for("); 
    	assignment();
    	
    	mustbe(TK.SYM);
    	
    	if(is(TK.NUM)){
    	   System.out.print(var + "<" + tok.string + ";" + var + "++)");
	    	scan(); 
	} else {
		mustbe(TK.NUM); 
	}
	
	mustbe(TK.THEN);
	block();
    mustbe(TK.ENDFOR);
     }
     private void assignment(){
        ref_id();
        
        mustbe(TK.ASSIGN);
        System.out.print(" = ");
        exp();
        System.out.println(";");
     }
     
     private void doo(){
         mustbe(TK.DO);
         System.out.print("while(");
         guarded_command();
         mustbe(TK.ENDDO);
     }
        
     private void ref_id()
     {
         if(is(TK.TILDE))
         {
             scan();
             if(is(TK.NUM))
             {
                 System.out.print(tok.string);
                 var=Integer.parseInt(tok.string);
                 scan();
             }
         }
         mustbe(TK.ID);
     }
     private void exp()
     {
	term();
	while(is(TK.PLUS) || is(TK.MINUS)){
	    	System.out.print(" " + tok.string + " "); 
	    	scan();
		term();
}
     }
     private void term()
     {
         factor();
         while(is(TK.TIMES)||is(TK.DIVIDE))
         {
             System.out.print(tok.string); 
             scan();
             factor();
         }
     }
   /*

    public static final TK DECLARE = new TK("TK.DECLARE"); // @
    public static final TK PRINT   = new TK("TK.PRINT");   // !
    public static final TK IF      = new TK("TK.IF");	   // [
    public static final TK THEN    = new TK("TK.THEN");	   // :
    public static final TK ELSEIF  = new TK("TK.ELSEIF");  // |
    public static final TK ELSE    = new TK("TK.ELSE");    // %
    public static final TK ENDIF   = new TK("TK.ENDIF");   // ]
    public static final TK DO      = new TK("TK.DO");      // <
    public static final TK ASSIGN   = new TK("TK.ASSIGN");  //=
    public static final TK TILDE    = new TK("TK.TILDE");   //~
    public static final TK ENDDO    = new TK("TK.ENDDO");   //>
    public static final TK COMMA  = new TK("TK.COMMA");    // ,
    public static final TK LPAREN = new TK("TK.LPAREN");   // (
    public static final TK RPAREN = new TK("TK.RPAREN");   // )
    public static final TK PLUS   = new TK("TK.PLUS");     // +
    public static final TK MINUS  = new TK("TK.MINUS");    // -
    public static final TK TIMES  = new TK("TK.TIMES");    // *
    public static final TK DIVIDE = new TK("TK.DIVIDE");   // 
    
    public static final TK ID     = new TK("TK.ID");	   // identifier
    
    public static final TK NUM    = new TK("TK.NUM");	   // number
    public static final TK EOF    = new TK("TK.EOF");	   // end of file
    // TK.ERROR special error token kind (for scanner to return to parser)
    public static final TK ERROR  = new TK("TK.ERROR");
    // TK.none marks end of each first set in parsing.
    // you might not need this.
    public static final TK none   = new TK("TK.none");
    
*/
     private void factor()
     {
         
        if(is(TK.LPAREN))
        {
            System.out.print("(");
            scan();
            exp();
            mustbe(TK.RPAREN);
            System.out.print(")");
        }
        else if(is(TK.ID)||is(TK.TILDE))
        {
            ref_id();
        }
        else if(is(TK.NUM))
        {
         scan();
        }
     }
     private void guarded_command()
     {
         exp();
         mustbe(TK.THEN);
         System.out.print(" <= 0)");
         block();
     }
         /*
program ::= block
block ::= declaration_list statement_list
declaration_list ::= {declaration}
statement_list ::= {statement}
declaration ::= ’@’ id { ’,’ id }
statement ::= assignment | print | do | if
print ::= ’!’ expr
assignment ::= ref_id ’=’ expr
ref_id ::= [ ’ ̃’ [ number ] ] id
do ::= ’<’ guarded_command ’>’
if ::= ’[’ guarded_command { ’|’ guarded_command } [ ’%’ block ] ’]’
guarded_command ::= expr ’:’ block
expr ::= term { addop term }
term ::= factor { multop factor }
factor ::= ’(’ expr ’)’ | ref_id | number
addop ::= ’+’ | ’-’
multop ::= ’*’ | ’/’
*/
     private void iff(){
      mustbe(TK.IF);
      System.out.print("if(");
     //a[count++]="l";
      //values[count-1]++;
      //countif++;
      guarded_command();
      while(is(TK.ELSEIF))
      {System.out.print("else if(");
          scan();
          guarded_command();
      }
      if(is(TK.ELSE))
      {System.out.print("else");
          scan();
          block();
      }   

      mustbe(TK.ENDIF);
    /*   a[count-1]="";
      int flag=0;
     for(int i=0;i<count;i++)
      {
          
          if(tok.string==a[i])
          {
              flag=1;
          }
      }
     if(flag==0)
       {   scan();
           parse_undeclare(tok.string+" ");
       }*/
    /*    for(int i=0;i<count;i++)
       {
           System.out.println(a[i]);
       }*/
   /*   int lloc=0;
      for(int i=count-1;i>=0;i--)
      {
          if(a[i]=="l")
          {
              lloc=i;
          }
      }
      if(lloc!=0)
      for(int i=lloc;i<count;i++)
      {
          a[i]="";
          values[i]=0;
      }
      countif--;*/
    /* for(int i=0;i<count;i++)
	{
	    System.out.println(a[i]+" "+values[i]);
	}
	System.out.println("");
      countif--;
	*/
     }
     
     private void print()
     { 
         mustbe(TK.PRINT);
         System.out.print("printf(\"%d\\n\", "+tok.string);
         exp();
         System.out.println(");");
     }
    // is current token what we want?
    private boolean is(TK tk) {
        return tk == tok.kind;
    }

    // ensure current token is tk and skip over it.
    private void mustbe(TK tk) {
	if( tok.kind != tk ) {
	    System.err.println( "mustbe: want " + tk + ", got " +
				    tok);
	    parse_error( "missing token (mustbe)");
	}
	scan();
    }

    private void parse_error(String msg) {
	System.err.println( "can't parse: line "
			    + tok.lineNumber + " " + msg );
	System.exit(1);
    }
        private void parse_undeclare(String msg) {
	System.err.println( msg+"is an undeclared variable on line "
			    + tok.lineNumber );
	System.exit(1);
    }
}