package thomas.hofmann;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class WeightArray extends ArrayList<ArrayList<Double>>
{
	public WeightArray(int nodes, int weightsPerNode)
	{
		super();
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
	
}
