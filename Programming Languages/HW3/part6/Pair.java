class Pair extends Element
{
 public MyChar key;
 public Element value;
 public Pair next;
 
 public Pair()
 {
    
 }
 public Pair(Pair x)
 {//copy one pair object
     this.key=x.key;
     this.value=x.value;
     this.next=x.next;
 }
 public Pair(MyChar q,Element p)
 {
    key=q;
    value=p;
 }
 public void Print()//print pair
 {
     System.out.print("(");
      key.Print();
     System.out.print(" ");
      value.Print();
      System.out.print(")");
 }
}