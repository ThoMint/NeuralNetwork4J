package thomas.hofmann;

import java.util.ArrayList;

public class NeuralNetwork
{
	public ArrayList<Layer> layer = new ArrayList<Layer>();
	int inputs;
	public NeuralNetwork()
	{
		
	}
	
	public void addInputLayer(int nodes)
	{
		inputs=nodes;
		layer.add(new Layer(nodes, 1));
	}
	
	public void addHiddenLayer(int nodes)
	{
		int latestIndex=layer.size()-1;
		int latestNodes=layer.get(latestIndex).numberOfPCTS;
		layer.add(new Layer(nodes, latestNodes));
	}
	
	public void addOutputLayer(int nodes)
	{
		int latestIndex=layer.size()-1;
		int latestNodes=layer.get(latestIndex).numberOfPCTS;
		layer.add(new Layer(nodes, latestNodes));
	}
	
	public ArrayList<Double> compute(ArrayList<Double> input)
	{
		InputArray inputArr = new InputArray(this.inputs, 1);
		ArrayList<Double> latestOutput= new ArrayList<Double>();
		for(int i=0;i<this.inputs;i++)
		{
			inputArr.add(InputArray.getInput(new double[] {input.get(i)}));
		}
		latestOutput=layer.get(0).compute(inputArr);
		
		InputArray newInput;
		for(int l=1;l<layer.size();l++)
		{
			newInput=new InputArray(layer.get(l).numberOfPCTS, layer.get(l).inputsPerPCT);
			for(int i=0;i<layer.get(l).numberOfPCTS;i++)
			{
				newInput.add(latestOutput);
			}
			latestOutput=layer.get(l).compute(newInput);
		}
		return latestOutput;
	}
	
	
}
