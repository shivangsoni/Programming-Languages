class MyChar extends Element
{
 public char x;
 public MyChar() { x='0';}
 public MyChar(char t)
 {
     x=t;
 }
 public char Get() { 
     return x;
 }
 public void Set(char val) { 
     x=val;
 }
 public void Print()
 {
     System.out.print("'"+ x + "'");
 }
}
