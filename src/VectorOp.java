
public class VectorOp {
	private String vector1;
	private String vector2;
	private String op;

	public VectorOp(String vector1, String vector2, String op) {
		this.vector1 = vector1;
		this.vector2 = vector2;
		this.op = op;
	}

	private SparseVector parseSV(String sv) throws Exception {
		SparseVector vector = new SparseVector();
		String[] vals = sv.split(" ");
		for (int i = 0; i < vals.length - 1; i += 2) {
			vector.add(Integer.parseInt(vals[i]), Double.parseDouble(vals[i + 1]));
		}
		System.out.println(vector);
		return vector;

	}

	public void doVectorOperation() throws Exception {
		SparseVector vector1 = parseSV(getVector1());
		SparseVector vector2 = parseSV(getVector2());
		if (getOp().equals("add")) {
			System.out.println(vector1.add(vector2));
		}
	}

	public String getVector1() {
		return vector1;
	}

	public void setVector1(String vector1) {
		this.vector1 = vector1;
	}

	public String getVector2() {
		return vector2;
	}

	public void setVector2(String vector2) {
		this.vector2 = vector2;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

}
