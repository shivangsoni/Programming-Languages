
class MyChar extends Element
{
 private char x;
 public MyChar() { x='0';}
 public MyChar(char t)
 {
     x=t; //assign char value by parametric constructor
 }
 public char Get() { 
     return x; //get the character
 }
 public void Set(char val) { 
     x=val; //set the character with val
 }
 public void Print()
 {
     System.out.print("'"+ x + "'");//print char value in quotes
 }
}