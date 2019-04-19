package thomas.hofmann;

import java.util.ArrayList;

public class Perceptron
{
	public Double bias;
	public ArrayList<Double> inputs = new ArrayList<Double>();
	public ArrayList<Double> weights = new ArrayList<Double>();
	
	//Constructor takes the number of Inputs for the Perceptron and initializes all weights and the bias
	public Perceptron(int inputs)
	{
		for(int i=0;i<inputs;i++)
		{
			this.weights.add(new Double(1.0));
		}
		bias=new Double(0.0);
	}
	
	//Takes the input and stores it inside of the Perceptron so multiple calculations
	//can be done without passing the input every time
	public void uptdate(ArrayList<Double> inputs)
	{
		this.inputs=inputs;
	}
	
	//Calculates the weighted sum of all inputs
	public double sum()
	{
		Double sum=0.0;
		//Iterates over every input and adds the weighted sum of it to the overall sum
		for(int i=0;i<this.inputs.size();i++)
		{
			sum+=this.inputs.get(i)*this.weights.get(i);
		}
		return sum+bias;
	}

	//'Sigmoid' activation function
	public double sigmoid()
	{
		return (1/(1+Math.exp(-sum())));
	}
	
	//'TanH' activation function
	public double tanh()
	{
		return ( 2 / ( 1 + Math.exp( -2 * sum() ) ) )-1;
	}
	
	//'ReLu' activation function
	public double relu()
	{
		if(sum()>=0)
		{
			return sum();
		}else
		{
			return 0.0;
		}
	}
}
