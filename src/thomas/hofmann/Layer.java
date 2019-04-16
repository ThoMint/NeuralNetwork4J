package thomas.hofmann;

import java.util.ArrayList;

public class Layer
{
	public ArrayList<Perceptron> pcts = new ArrayList<Perceptron>();
	public int numberOfPCTS=0;
	public int inputsPerPCT=0;

	public Layer(int pcts,int pctInputs)
	{
		numberOfPCTS=pcts;
		inputsPerPCT=pctInputs;
		for(int x=0;x<pcts;x++)
		{
			this.pcts.add(new Perceptron(pctInputs));
		}
	}
	
	public ArrayList<Double> compute(ArrayList<ArrayList<Double>> inputs)
	{
		ArrayList<Double> outP = new ArrayList<Double>();
		for(int i=0;i<numberOfPCTS;i++)
		{
			pcts.get(i).uptdate(inputs.get(i));
			outP.add(pcts.get(i).sigmoid());
		}
		return outP;
	}
	
	public void optimize(Double bias,ArrayList<ArrayList<Double>> weights)
	{
		int pos=0;
		if(weights==null)
		{
			for (Perceptron p : pcts)
			{
				p.optimize(bias,null);			
				pos++;
			}
		}else
		{
			for (Perceptron p : pcts)
			{
				p.optimize(bias, weights.get(pos));
				pos++;
			}
		}
		
		
		
		
	}
	
}
