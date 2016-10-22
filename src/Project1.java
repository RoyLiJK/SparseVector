

public class Project1 {

	public static void main(String[] args)
	{
		DoublyLinkedList<Double> a = new DoublyLinkedList<Double>();
		a.add(3.0);
		a.add(4.0);
		a.add(5.0);
		a.add(8.0);
		a.add(6.0);
		a.add(6.0);
		
		for (int i =0; i<a.size();i++){
			System.out.println(a.get(i));
		}
		System.out.println("-----------------------");
		int k = a.size();
		for (int i =1; i<2;i++){
			a.remove(i);

		}
		for (int i =0; i<a.size();i++){
			System.out.println(a.get(i));
		}
	}

}
