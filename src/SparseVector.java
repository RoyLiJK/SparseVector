import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class SparseVector
{

	private DoublyLinkedList<Double> vector = new DoublyLinkedList<Double>();
	
	private TreeMap<Integer, Integer> indexs = new TreeMap<>();
	
	public SparseVector()
	{
		this.vector = new DoublyLinkedList<Double>();
	}
	
	public void add(int index, Double sv)
	{
		if (indexs.get(index)==null){
			indexs.put(index, vector.size());
			vector.add(sv);
		} else {
			vector.set(indexs.get(index), sv);
		}
	}
	
	
	
	public Double get(int index){
		Integer ind =indexs.get(index); 
		if (ind != null){
			return vector.get(ind);
		} else {
			return null;
		}
	}
	
	public Iterator<Integer> getIterator(){
		return indexs.keySet().iterator();
	}
	
	public SparseVector add(SparseVector sv)
	{
		// returns a SparseVector which is A+B.
		SparseVector result = new SparseVector();
		//iterator??
		Iterator<Integer> itr1 = getIterator();
		Iterator<Integer> itr2 = sv.getIterator();
		
		TreeMap<Integer, Double> sum = new TreeMap<>();
		while (itr1.hasNext()){
			int ind = itr1.next();
			sum.put(ind, get(ind));
		}
		while (itr2.hasNext()){
			int ind = itr2.next();
			if (sum.get(ind)==null){
				sum.put(ind, sv.get(ind));
			} else {
				sum.put(ind, sum.get(ind)+sv.get(ind));
			}
		}
		for (Integer ind : sum.keySet()){
			result.add(ind, sum.get(ind));
		}
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
