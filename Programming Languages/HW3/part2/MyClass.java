import java.io.*;
class MyClass
{
    public static void main(String args[])
    {
      MyChar a = new MyChar('a');
		MyChar b = new MyChar('b');
		MyChar c = new MyChar('c');
		
		MyInteger t1 = new MyInteger(1);
		MyInteger t2 = new MyInteger(2);
		MyInteger t3 = new MyInteger(3);
		
		Sequence seq = new Sequence();
		seq.add(c, 0);
		seq.add(b, 0);
		seq.add(a, 0);
		
		seq.Print();
		seq.add(t1,1);
		//seq.delete(0);
		Element q=seq.first();
		q.Print();
		
		seq.Print();
				
    }
}