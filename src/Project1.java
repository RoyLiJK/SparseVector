

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
		int k = a.size();
		for (int i =0; i<k;i++){
			a.remove(0);
			for (int j =0; j<a.size();j++){
				System.out.println(a.get(j));
			}

		}
//		a.remove(a.size()-3);
		for (int i =0; i<a.size();i++){
			System.out.println(a.get(i));
		}
	}

}
