

public class Project1 {

	public static void main(String[] args)
	{
		DoublyLinkedList<Double> a = new DoublyLinkedList<Double>();
		a.add(3.0);
	
		
		for (int i =0; i<a.size();i++){
			System.out.println(a.get(i));
		}
		System.out.println("-----------------------");
		int k = a.size();
//		for (int i =1; i<2;i++){
//			a.remove(i);
//
//		}
		a.remove(0);
		for (int i =0; i<a.size();i++){
			System.out.println(a.get(i));
		}
	}

}
