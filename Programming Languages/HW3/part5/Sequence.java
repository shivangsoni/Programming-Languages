class Sequence extends Element
{
    public Element val;
    public Sequence next;
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
             System.out.print(" ");
             pointer.val.Print();
         }
         pointer=pointer.next;
     }
     System.out.print(" ]");
 }
 
 public Element first()
 {
    return this.val;
 }
 
 public Sequence rest()
  {
      return this.next;
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
			//swap head element
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
  
  
  void delete(int pos)
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
  public Element index(int pos)
  {
      Sequence temp=this;
      int count=0;
      while(count<pos && temp!=null)
      {
          temp=temp.next;
          count++;
      }
      if(temp!=null)
      return temp.val;
    return null;
  }
  public Sequence flatten()
  {
    Sequence newnode = new Sequence();
       Sequence i = this;
       while(i != null && i.val != null)
       {
          if(i.val instanceof Sequence==false)
          {
              
   if(newnode.length()==0)
     {
	    Sequence temp = new Sequence(newnode.val, newnode.next);
			newnode.val = i.val;
			newnode.next = temp;
     }
     else
     {
         int count=1;
         Sequence test=newnode;
         while(count<newnode.length())
         {
             test=test.next;
             count++;
         }
         Sequence no=new Sequence();
         no.val=i.val;
         no.next=test.next;
         test.next=no;
     }
              
          }
        else  if (i.val instanceof Sequence)
           {
  /*Recursive call*/Sequence p = ((Sequence)(i.val)).flatten(); 
                 while(p!=null)
                 { 
                      if(newnode.length()==0)
                          {
	                           Sequence temp = new Sequence(newnode.val, newnode.next);
		                    	newnode.val = p.val;
			                    newnode.next = temp;
                           }
                      else
                         {
                          int count=1;
                            Sequence test=newnode;
                      while(count<newnode.length())
                      {
                        test=test.next;
                         count++;
                      }
                         Sequence no=new Sequence();
                         no.val=p.val;
                          no.next=test.next;
                          test.next=no;
                                    }
                   p=p.next;
                 }
           } 

             i = i.next;
    }
  
    return newnode; 
  }
  
  public Sequence copy() {
  Sequence newnode=new Sequence();
  Sequence i=this;
  while(i!=null && i.val!=null)
  {
    if(i.val instanceof Element)
    {
        if(i.val instanceof Sequence)
       {  //copy the given sequence by recursive call
                         if(newnode.length()==0)
                          {
	                           Sequence temp = new Sequence(newnode.val, newnode.next);
		                    	newnode.val = ((Sequence)i.val).copy();
			                    newnode.next = temp;
                           }
                      else
                         {
                          int count=1;
                            Sequence test=newnode;
                      while(count<newnode.length())
                      {
                        test=test.next;
                         count++;
                      }
                         Sequence no=new Sequence();
                         no.val=((Sequence)i.val).copy();
                          no.next=test.next;
                          test.next=no;
                        }
       
       }// if any amoung integer and number directly copy
     else 
       {
           if(i.val instanceof MyInteger)
           {
                        if(newnode.length()==0)
                          {
	                           Sequence temp = new Sequence(newnode.val, newnode.next);
		                    	newnode.val = new MyInteger(((MyInteger)i.val).y);
			                    newnode.next = temp;
                           }
                      else
                         {
                          int count=1;
                            Sequence test=newnode;
                      while(count<newnode.length())
                      {
                        test=test.next;
                         count++;
                      }
                         Sequence no=new Sequence();
                         no.val=new MyInteger(((MyInteger)i.val).y);
                          no.next=test.next;
                          test.next=no;
                        }
           }
           else if(i.val instanceof MyChar)
                  {
                if(newnode.length()==0)
                          {
	                           Sequence temp = new Sequence(newnode.val, newnode.next);
		                    	newnode.val = new MyChar(((MyChar)i.val).x);
			                    newnode.next = temp;
                           }
                      else
                         {
                          int count=1;
                            Sequence test=newnode;
                      while(count<newnode.length())
                      {
                        test=test.next;
                         count++;
                      }
                         Sequence no=new Sequence();
                         no.val=new MyChar(((MyChar)i.val).x);
                          no.next=test.next;
                          test.next=no;
                        }
       }
       }
    }
    i=i.next;
  }
  return newnode;
}
  //Sequence iterator
public  SequenceIterator begin()
 {
     //pointer to first element in sequence
     return new SequenceIterator(this);
 }
 
 public SequenceIterator end()
 {
     Sequence a=this;
     Sequence prev=null;
     for(;a!=null;a=a.next)
     {
         prev=a;
     }
     return new SequenceIterator(prev);
 }
}