import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


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
				     String s;  		  
		         // read till the end of the file
		         while((i=fstream.read())!=-1)
		         {
		            // converts integer to character
		            c=(char)i;
		            
		            // prints character
		            System.out.print(c);
		            String numberAsString = Integer.toString(i);
		            parseSV(numberAsString);
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
	
	private static SparseVector parseSV(String sv)
	{
		SparseVector vector = new SparseVector();
		Scanner scanner = new Scanner(sv).useDelimiter("\\s+");
		double d =0.0; int i=0;
		while (scanner.hasNext()) 
		{
			if (scanner.hasNextInt()) 
		    { 
		        i = scanner.nextInt();
		    }
		    if (scanner.hasNextDouble()) 
		    { 
		        d = scanner.nextDouble(); 
		        
		    } 
		    
		    vector.add(i, d);
		   
		    scanner.next(); // else read the next token
		  }
		
		return vector;
		
	}
	
	private static void doVectorOperation(String sv1, String sv2, String op)
	{
		SparseVector vector1 = parseSV(sv1);
		SparseVector vector2 = parseSV(sv2);
		if (op.equals("add"))
		{
			vector1.add(vector2);
		}
		
	}

}
