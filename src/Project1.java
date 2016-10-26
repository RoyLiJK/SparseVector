import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Project1 {

	public static void main(String[] args) {
		try {
			List<VectorOp> ops = getOperationsFromFile("project1.txt");
			for (VectorOp op : ops) {

				op.doVectorOperation();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<VectorOp> getOperationsFromFile(String fileName) throws Exception {
		List<VectorOp> ops = new ArrayList<>();

		String sCurrentLine;

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		ArrayList<String> lines = new ArrayList<>();

		while ((sCurrentLine = br.readLine()) != null) {
			lines.add(sCurrentLine);
		}
		for (int i = 0; i < lines.size() - 3; i += 3) {
			ops.add(new VectorOp(lines.get(i), lines.get(i + 1), lines.get(i + 2)));
		}

		return ops;
	}

}
