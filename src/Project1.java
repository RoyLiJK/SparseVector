import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		
		
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("project1.txt"));
			ArrayList<String> lines = new ArrayList<>();

			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
			}
			doVectorOperation(lines.get(0),lines.get(1),lines.get(2));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static SparseVector parseSV(String sv) throws Exception{
		SparseVector vector = new SparseVector();
			String[] vals = sv.split(" ");
			for (int i = 0; i < vals.length - 1; i += 2) {
				vector.add(Integer.parseInt(vals[i]), Double.parseDouble(vals[i + 1]));
			}
			System.out.println(vector);
		return vector;

	}

	private static void doVectorOperation(String sv1, String sv2, String op)throws Exception
	{
		SparseVector vector1 = parseSV(sv1);
		SparseVector vector2 = parseSV(sv2);
		if (op.equals("add"))
		{
			vector1.add(vector2);
		}
		
	}

}
