package thomas.hofmann;

import java.util.ArrayList;

public class Perceptron
{
	Double bias;
	
	ArrayList<Double> inputs = new ArrayList<Double>();
	ArrayList<Double> weights = new ArrayList<Double>();
	
	public Perceptron(int inputs)
	{
		for(int i=0;i<inputs;i++)
		{
			this.inputs.add(new Double(1.0));
			this.weights.add(new Double(1.0));
		}
		bias=new Double(Math.random());
	}
	
	public void uptdate(ArrayList<Double> inputs)
	{
		this.inputs=inputs;
	}
	
	public double sum()
	{
		Double sum=0.0;
		for(int i=0;i<this.inputs.size();i++)
		{
			sum+=this.inputs.get(i).doubleValue()*this.weights.get(i).doubleValue();
		}
		return sum+bias;
	}
	
	public double sigmoid()
	{
		return (1/(1+Math.exp(-sum())));
	}
	
	public void optimize(Double bias,ArrayList<Double> weights)
	{
		if(bias!=null)
		{
			this.bias=bias;
		}
		if(weights!=null)
		{
			for(int i=0;i<this.weights.size();i++)
			{
				if(weights.get(i)!=null)
				{
					this.weights.set(i, weights.get(i));
				}
			}
		}
	}
	
}
