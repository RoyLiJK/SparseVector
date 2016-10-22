
public class Element implements Comparable<Element>
{

	private int index;
	private double value;
	
	public Element(int in, double val)
	{
		this.index = in;
		this.value = val;
	}
	
	public int getIndex()
	{
		return index;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public void setIndex( int in)
	{
		index = in;
	}
	
	public void setValue( double val)
	{
		value = val;
	}

	@Override
	public int compareTo(Element other)
	{
		return Integer.compare(this.index, other.index);
	}

	
	public String toString() 
	{
		return "[index=" + index + ", value=" + value + "] ";
	}
	
	
}
