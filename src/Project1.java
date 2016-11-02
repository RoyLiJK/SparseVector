import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Project1 {

	public static void main(String[] args)   // main method
	{
		try {
			List<VectorOp> ops = getOperationsFromFile("project1.txt");
			for (VectorOp op : ops)  // loop through the file and perform operation automatically 
			{
				System.out.println("vector 1 = (" + op.getVector1() + ")");
				System.out.println(op.getOp());			
				System.out.println("vector 2 = (" + op.getVector2() + ")");
				System.out.println("= ");
				System.out.println("Result = " + op.doVectorOperation()+"\n\n" );
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static List<VectorOp> getOperationsFromFile(String fileName) throws Exception //read from file to be use by main
	{
		List<VectorOp> ops = new ArrayList<>();

		String sCurrentLine;

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		ArrayList<String> lines = new ArrayList<>();

		while ((sCurrentLine = br.readLine()) != null) 
		{
			lines.add(sCurrentLine);
		}
		for (int i = 0; i < lines.size() - 2; i += 3) 
		{
			ops.add(new VectorOp(lines.get(i), lines.get(i + 1), lines.get(i + 2)));
		}
		br.close();
		return ops;
	}

}
