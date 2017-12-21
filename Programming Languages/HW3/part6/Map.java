class Map extends Pair
{
    public Pair p;
    public Map(){
    }
    public  void Print()//print the map formed
    {
        System.out.print("[ ");
        Pair temp=this.p;
        for(;temp!=null;temp=temp.next)
        {
            temp.Print();//print pairs
            System.out.print(" ");
        }
        System.out.print("]");
    }
   
    public void add(Pair inval)
    {
        
        Pair p0,q;
        p0=null;
        q=p;
        //add pair when the key value of the pair is more the before element
        while(q!=null && (inval.key.x)>=(q.key.x))
        {
         p0=q;
         q=q.next;   
        }
        //if prev pair p0 is null add to pair to start
        if(p0==null)
        {
            Pair w=new Pair();
            w.key=inval.key;
            w.value=inval.value;
            w.next=p;
            p=new Pair(w);
        }
        else
        {
            Pair w=new Pair();
            w.key=inval.key;
            w.value=inval.value;
            w.next=q;
            //p=new Pair(w);
            p0.next=new Pair(w);
        }
    }
    
    public MapIterator find(MyChar key)
    {//find element with the particular key
        Pair q=p;
        for(;q!=null && q.key!=null;q=q.next)
        {
            if(q.key.x==key.x)
            {
                MapIterator x=new MapIterator(q);
                return x;
            }
        }
        return new MapIterator();
    }
    
     public MapIterator begin()
    {//element at the begning of the sequence
        return new MapIterator(this.p);
    }
    public MapIterator end()
    {//null at the end of the sequence
        return new MapIterator(null);
    }
}