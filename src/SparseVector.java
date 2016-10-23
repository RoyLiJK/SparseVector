import java.util.TreeMap;
import java.util.TreeSet;

public class SparseVector<AnyType> 
{

	private DoublyLinkedList<AnyType> vector = new DoublyLinkedList<AnyType>();
	
	private TreeMap<Integer, Integer> indexs = new TreeMap<>();
	
	public SparseVector()
	{
		this.vector = new DoublyLinkedList<AnyType>();
	}
	
	public void add(int index, AnyType sv)
	{
		indexs.put(index, vector.size());
		vector.add(sv);
	}
	
	public SparseVector add(SparseVector sv)
	{
		// returns a SparseVector which is A+B.
		SparseVector result = new SparseVector();
		//iterator??
		return result;
	}
//	
//	public SparseVector subtract(SparseVector sv)
//	{
//		// returns a SparseVector which is A-B.
//	}
//	
//	 public double dot(SparseVector sv)
//	 {
//		 // public returns a double which is A∙B
//		 
//	 }
//
//	
	public String toString() {
		String retVal = "(";
		if (vector != null) {
		for (Integer ind : indexs.keySet()) {
			
				retVal += "[" +ind+", "+vector.get(indexs.get(ind))+"]";
			}

		}
		return retVal+")";

	}

}
