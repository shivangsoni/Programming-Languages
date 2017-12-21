
class MyInteger extends Element
{
  private int y;
  public MyInteger() { y=0; }
  public MyInteger(int s)
  {
      y=s;
  }
  public int Get() { 
      return y;
  }
  public void Set(int val) { 
      y=val;
  }

   public void Print()
 {
     System.out.print(y);
 }
}