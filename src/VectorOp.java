
public class VectorOp {
	
	// Data members
	private String vector1;
	private String vector2;
	private String op;

	public VectorOp(String vector1, String vector2, String op) // Constructor
	{
		this.vector1 = vector1;
		this.vector2 = vector2;
		this.op = op;
	}

	private SparseVector parseSV(String sv) throws Exception // take in String and convert to SparseVector
	{
		SparseVector vector = new SparseVector();
		String[] vals = sv.split(" ");
		for (int i = 0; i < vals.length - 1; i += 2) 
		{
			vector.add(Integer.parseInt(vals[i]), Double.parseDouble(vals[i + 1]));
		}		
		return vector;
	}
	
	

	public String doVectorOperation() throws Exception // logic for operation add, subtract, and dot.
	{
		SparseVector vector1 = parseSV(getVector1());
		SparseVector vector2 = parseSV(getVector2());
		if (getOp().equals("add"))
		{
			 return vector1.add(vector2).toString();
		}
		if (getOp().equals("subtract")) 
		{
			return vector1.subtract(vector2).toString();
		}
		if (getOp().equals("dot"))
		{
			return vector1.dot(vector2)+"";
		}
		return "invalid op";
	}

	// Accesser and Mutator
	
	public String getVector1() 
	{
		return vector1;
	}

	public void setVector1(String vector1)
	{
		this.vector1 = vector1;
	}

	public String getVector2() 
	{
		return vector2;
	}

	public void setVector2(String vector2) 
	{
		this.vector2 = vector2;
	}

	public String getOp() 
	{
		return op;
	}

	public void setOp(String op) 
	{
		this.op = op;
	}

}
