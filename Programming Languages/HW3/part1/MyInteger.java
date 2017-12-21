class MyInteger extends Element
{
  private int y;
  public MyInteger() { y=0; }//default constructor for setting int value
  public int Get() { 
      return y;//get int value
  }
  public void Set(int val) { 
      y=val;//set int value
  }
 public void Print()
 {
     System.out.print(y);//print that value of int
 }
}