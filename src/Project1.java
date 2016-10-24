import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Project1 {

	public static void main(String[] args) 
	{
//		DoublyLinkedList<Double> a = new DoublyLinkedList<Double>();
//		a.add(3.0);
//		a.add(4.0);
//		a.add(5.0);
//	
//		
//		for (int i =0; i<a.size();i++){
//			System.out.println(a.get(i));
//		}
//		System.out.println("-----------------------");
////		int k = a.size();
////		for (int i =0; i<k;i++){
////			a.remove(a.size()-1);
////		}
//		a.remove(0);
//		for (int i =0; i<a.size();i++){
//			System.out.println(a.get(i));
//		}
		
		/*SparseVector sv1 = new SparseVector();
		
		sv1.add(1,1.0);
		sv1.add(2,2.0);
		sv1.add(3,-3.0);
		sv1.add(4,4.0);
		
		System.out.println(sv1);
		
		SparseVector sv2 = new SparseVector();
		sv2.add(1,1.0);
		sv2.add(2,2.0);
		sv2.add(3,3.0);
		sv2.add(4,4.0);
		System.out.println(sv2);
		System.out.println(sv1.subtract(sv2));*/
		
		
			FileInputStream fstream;
			try {
					fstream = new FileInputStream("project1.txt");
					int i = 0;
					char c;
				       		  
		         // read till the end of the file
		         while((i=fstream.read())!=-1)
		         {
		            // converts integer to character
		            c=(char)i;
		            
		            // prints character
		            System.out.print(c);
		         }
			 	}
		         catch (FileNotFoundException e)
		         	{	
		        	 e.printStackTrace();
		         	} 
				catch (IOException e)
				{			
					e.printStackTrace();
				}
		
	}

}
