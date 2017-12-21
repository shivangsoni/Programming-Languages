class MapIterator extends Pair
{
    public Pair p;
    public MapIterator()
    {
        
    }
    public MapIterator(Pair q)
    {
        p=q;
    }
    public Pair get()
    {
        return p;
    }
    public void Print()
    { 
      p.Print();   
    }
  public void advance(){
        p=p.next;
    }
public boolean equal(MapIterator k){ 
      if(this.p!=null && k.p!=null) //if both pairs not null check the char value
       if(this.p.key.x == k.p.key.x)
       return true;
       else 
       return false;
     else
      if(this.p==k.p)
      return true;
      else
      return false;
      //same pair comparision as in sequence iterator for sequence
}
}