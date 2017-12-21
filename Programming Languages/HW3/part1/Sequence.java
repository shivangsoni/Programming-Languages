
class Sequence extends Element
{
    private Element val;
    private Sequence next;
    public Sequence()
    {
        val=null;
        next=null;
    }
    public Element Get()
    {
        return val;//get element value
    }
    public void Set(Element v)
    {
        val=v;//set element value
    }
}