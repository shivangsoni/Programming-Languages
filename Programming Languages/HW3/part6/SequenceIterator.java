class SequenceIterator{
public Sequence a;
public SequenceIterator()
{

}
public SequenceIterator(Sequence x)
{
    a=x;
}

public void Print()
{
  a.Print();
}

public void advance(){
  a=a.next;
}

public Element get(){
  return (Element)a.val;  
}

public boolean equal(SequenceIterator k){ 
       if(a == k.a)
       return true;
       else 
       return false;
}
}