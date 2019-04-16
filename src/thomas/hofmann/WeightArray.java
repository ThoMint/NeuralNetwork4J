package thomas.hofmann;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class WeightArray extends ArrayList<ArrayList<Double>>
{
	public WeightArray(int nodes, int weightsPerNode)
	{
		for(int j=0;j<nodes;j++)
		{
			ArrayList<Double> temp = new ArrayList<Double>();
			for(int i=0;i<weightsPerNode;i++)
			{
				temp.add(0.0);
			}
			super.add(temp);
		}
	}
	
	public WeightArray(int nodes, int weightsPerNode,double initialWeight)
	{
		for(int j=0;j<nodes;j++)
		{
			ArrayList<Double> temp = new ArrayList<Double>();
			for(int i=0;i<weightsPerNode;i++)
			{
				temp.add(initialWeight);
			}
			super.add(temp);
		}
	}
	
	public static ArrayList<Double> getWeight(double[] weights)
	{
		ArrayList<Double> temp=new ArrayList<Double>();
		for(double currentValue : weights)
		{
			temp.add(currentValue);
		}
		return temp;
	}
	
	public static WeightArray setAll(int nodes, int inputsPerNode, double weight)
	{
		return  new WeightArray(nodes, inputsPerNode, weight);
	}
}
