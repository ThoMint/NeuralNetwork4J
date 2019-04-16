package thomas.hofmann;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class InputArray extends ArrayList<ArrayList<Double>>
{
	int nodes,inputsPerNode;
	
	public InputArray(int nodes, int inputsPerNode)
	{
		super();
		this.nodes=nodes;
		this.inputsPerNode=inputsPerNode;
	}
	
	
	public static ArrayList<Double> getInput(double[] inputs)
	{
		ArrayList<Double> temp=new ArrayList<Double>();
		for(double currentValue : inputs)
		{
			temp.add(currentValue);
		}
		return temp;
	}
	
	
}
