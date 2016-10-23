

public class Project1 {

	public static void main(String[] args)
	{
		DoublyLinkedList<Double> a = new DoublyLinkedList<Double>();
		a.add(3.0);
		a.add(4.0);
		a.add(5.0);
	
		
		for (int i =0; i<a.size();i++){
			System.out.println(a.get(i));
		}
		System.out.println("-----------------------");
//		int k = a.size();
//		for (int i =0; i<k;i++){
//			a.remove(a.size()-1);
//		}
		a.remove(0);
		for (int i =0; i<a.size();i++){
			System.out.println(a.get(i));
		}
	}

}
