

public class SparseVector<AnyType> 
{

	private DoublyLinkedList<AnyType> vector = new DoublyLinkedList<AnyType>();
	
	public SparseVector()
	{
		this.vector = new DoublyLinkedList<AnyType>();
	}
	
	public SparseVector add(SparseVector sv)
	{
		// returns a SparseVector which is A+B.
		SparseVector result;
		if(this.vector != null && sv != null)
		{
			for(int i = 0; i< vector.size();i++)
			{
				result = vector.get(i) + sv.get(i);
			}
		}
		return result;
	}
	
	public SparseVector subtract(SparseVector sv)
	{
		// returns a SparseVector which is A-B.
	}
	
	 public double dot(SparseVector sv)
	 {
		 // public returns a double which is A∙B
		 
	 }

	
	public String toString() 
	{	
		if(vector != null)
		{
			return "[vector=" + vector + "] ";
		}
	}
	 
	 
}
