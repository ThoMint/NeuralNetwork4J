package thomas.hofmann;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class InputArray extends ArrayList<ArrayList<Double>>
{
	int nodes,inputsPerNode;
	
	public InputArray(int nodes, int inputsPerNode)
	{
		this.nodes=nodes;
		this.inputsPerNode=inputsPerNode;
		for(int j=0;j<nodes;j++)
		{
			ArrayList<Double> temp = new ArrayList<Double>();
			for(int i=0;i<inputsPerNode;i++)
			{
				temp.add(0.0);
			}
			super.add(temp);
		}
	}
	
	public InputArray(int nodes, int inputsPerNode, double initialInput)
	{
		this.nodes=nodes;
		this.inputsPerNode=inputsPerNode;
		for(int j=0;j<nodes;j++)
		{
			ArrayList<Double> temp = new ArrayList<Double>();
			for(int i=0;i<inputsPerNode;i++)
			{
				temp.add(initialInput);
			}
			super.add(temp);
		}
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
