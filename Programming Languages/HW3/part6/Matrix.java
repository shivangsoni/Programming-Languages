

class Matrix extends Sequence
{
 public int r1;
 public int c1;
 public Sequence matrix;
 
 public Matrix(int a,int b)
 {
     r1=a;
     c1=b;
     matrix=new Sequence();
     for(int i=0;i<r1;i++)
     {  
        for(int j=0;j<c1;j++)
        {
            matrix.add(new MyInteger(),matrix.length());
        }
     }
 }
 
 void Set(int rowsize, int colsize, int value)
 {
      Sequence s=this.matrix;
    for(int i=0;i<rowsize*c1;i++)
    {
        s=s.next;
    }
    for(int j=0;j<colsize;j++)
    {
        s=s.next;
    }
      ((MyInteger)(s.val)).Set(value);
 }// set the value of an element
int Get(int rowsize, int colsize){
    Sequence s=this.matrix;
    for(int i=0;i<rowsize*c1;i++)
    {
        s=s.next;
    }
    for(int j=0;j<colsize;j++)
    {
        s=s.next;
    }
     return ((MyInteger)(s.val)).Get(); 
} // get the value of an element
public Matrix Sum(Matrix mat){
    Matrix j=new Matrix(r1,c1);
    Sequence jmat=j.matrix;
    Sequence mmat=mat.matrix;
    Sequence s=this.matrix;
    for(int i=0;i<r1*c1;i++)
    {
        int y=((MyInteger)(s.val)).Get();
        int w=((MyInteger)(mmat.val)).Get();
        int sum=y+w;
        ((MyInteger)(jmat.val)).Set(sum);  
        s=s.next;
        mmat=mmat.next;
        jmat=jmat.next;
    }
    return j;
} // return the sum of two matrices: mat & this
public Matrix Product(Matrix mat){
    if(this.c1!=mat.r1)
    {
       System.out.println("Matrix dimensions incompatible for Product");
	   System.exit(-1);
    }
    Matrix j=new Matrix(r1,mat.c1);
    int sum=0;
    for(int i=0;i<r1;i++)
    {
        for(int j1=0;j1<mat.c1;j1++)
        {   sum=0;
            for(int k=0;k<c1;k++)
            {
              int y=this.Get(i,k);
              int w=mat.Get(k,j1);
              sum=sum+(y*w);
            }
            j.Set(i,j1,sum);
        }
    }
    return j;
} // return the product of two matrices: mat & this
public void Print(){
      Sequence s=this.matrix;
      if(r1==1)
      {
       System.out.print("[ ");
       for(int i=0;i<r1*c1;i++)
       {
          int y=((MyInteger)(s.val)).Get();
          System.out.print(y+" ");
          s=s.next;
      }
       System.out.println("]");  
      }
      else
      {
       System.out.print("[ ");
       for(int i=0;i<r1*c1;i++)
       {
          int y=((MyInteger)(s.val)).Get();
          System.out.print(y+" ");
          if((i+1)%c1==0 && i<=(r1-1)*c1)
          {
              System.out.println("]");
              System.out.print("[ ");
          }
          s=s.next;
      }
       System.out.println("]");
      }
} // print the elements of matrix
}
