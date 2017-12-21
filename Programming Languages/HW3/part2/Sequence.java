

class Sequence extends Element
{
    private Element val;
    private Sequence next;
    public Sequence()
    {
        
    }
    public Sequence(Element a, Sequence b)
    {
        val=a;
        next=b;
    }
    public Element Get()
    {
        return this.val;
    }
    public void Set(Element v)
    {
        val=v;
    }
 public void Print()
 {
     System.out.print("[ ");
     //check for the content in element if not null print
     if(val!=null)
     {
         val.Print();
     }
     Sequence pointer=this.next;//reference to next sequence in list
     while(pointer!=null)
     {
         if(pointer.val!=null)
         {
             System.out.print(' ');
             pointer.val.Print();
         }
         pointer=pointer.next;
     }
     System.out.print(" ]");
 }
 
 public Element first()
 {
    return this.val; //first element from sequence list
 }
 
 public Sequence rest()
  {
      return this.next;//All element except first from the sequence list
  }
 
  int length()
  {
      Sequence node;
      int l=0;
      //Find the length by Iterating through list
      for(node=next;node!=null;node=node.next)
      {
          l++;
      }
      return l;
  }
 
 void add(Element p,int pos)
  {
     //Add element at start
     if(pos==0)
     {
	    Sequence temp = new Sequence(this.val, this.next);
			//swap head
			this.val = p;
			//change link to copied head
			this.next = temp;
     }
     else
     {
         int count=1;
         Sequence test=this;
         while(count<pos)
         {
             test=test.next;
             count++;
         }
         Sequence no=new Sequence();
         no.val=p;
         no.next=test.next;
         test.next=no;
     }
  }
  
  
  void delete(int pos)//delete element at particular position in sequence
  {
      if(pos==0)
      {
         
          this.val=this.next.val;
          this.next=this.next.next;
      }
      else
      {
          int count=1;
          Sequence s=this;
          while(count<pos)
          {
              s=s.next;
              count++;
          }
          s.next=s.next.next;
      }
  }
}
