package thomas.hofmann;

import java.util.ArrayList;

public class NeuralNetwork
{	
	public ArrayList<Layer> layer = new ArrayList<Layer>();
	int inputNodes;
	
	//Adds the first layer to the NN
	//This layer contains nodes which take only one input
	public void addInputLayer(int nodes, ActFunctions activationFunction)
	{
		//Adds the first layer to the NN
		inputNodes=nodes;
		layer.add(new Layer(nodes, 1,activationFunction));
	}
	
	//Adds the layers in the middle of the structure
	public void addHiddenLayer(int nodes, ActFunctions activationFunction)
	{
		//Gets the number of nodes from the previous layer since
		//this is the number of inputs every node of this layer should have (fully connected)
		int latestIndex=layer.size()-1;
		int latestNodes=layer.get(latestIndex).numberOfPCTS;
		//Adds a new Layer to the List of Layers
		layer.add(new Layer(nodes, latestNodes, activationFunction));
	}
	
	//Adds the layer at the end of the NN
	//Nothing special about this its the same as a hidden layer
	//Only for consistency in the layer-adding-system
	public void addOutputLayer(int nodes, ActFunctions activationFunction)
	{
		//Gets the number of nodes from the previous layer since
		//this is the number of inputs every node of this layer should have (fully connected)
		int latestIndex=layer.size()-1;
		int latestNodes=layer.get(latestIndex).numberOfPCTS;
		//Adds a new Layer to the List of Layers
		layer.add(new Layer(nodes, latestNodes, activationFunction));
	}
	
	//Calculates the output of the entire NN for a input-array
	public ArrayList<Double> compute(ArrayList<Double> input)
	{
		//Converting the input-ArrayList to the data-type used by the 'Layer'-class
		InputArray inputArr = new InputArray();
		inputArr.addList(input);
		
		//Calculating the input-layer
		ArrayList<Double> latestOutput= new ArrayList<Double>();
		latestOutput=layer.get(0).compute(inputArr);
		InputArray newInput;
		
		//Iterating over the rest of the NN
		for(int l=1;l<layer.size();l++)
		{
			newInput=new InputArray();
			//Feeding the output of the last layer into every single node of the next layer
			for(int i=0;i<layer.get(l).pcts.size();i++)
			{
				newInput.add(latestOutput);
			}
			//Calculating the output for each layer
			latestOutput=layer.get(l).compute(newInput);
		}
		//Returning the last output since this is our end-result
		return latestOutput;
	}
	
	//Sets the weights of the entire NN randomly
	public void randomizeWeights(double from,double to)
	{
		for (Layer l : layer)
		{
			for(Perceptron p : l.pcts)
			{
				for(int w=0;w<p.weights.size();w++)
				{
					double rand = Math.random();
					double value=(rand*(to-from))+from;
					p.weights.set(w, value);
				}
			}
		}
	}
	
	//Changes the weights randomly by the mutation-rate
	public void mutateWeights(double mutationRate)
	{
		mutationRate*=2;
		for (Layer l : layer)
		{
			for(Perceptron p : l.pcts)
			{
				for(int w=0;w<p.weights.size();w++)
				{
					double f = Math.random();
					double rand = (f-0.5)*mutationRate;
					rand=rand+p.weights.get(w);
					p.weights.set(w, rand);
				}
			}
		}
	}
	
	//Changes the bias randomly by the mutation-rate
	public void mutateBias(double mutationRate)
	{
		mutationRate*=2;
		for (Layer l : layer)
		{
			for(Perceptron p : l.pcts)
			{
					double f = Math.random();
					double rand = (f-0.5)*mutationRate;
					rand=rand+p.bias;
					p.bias=rand;
			}
		}
	}
	
	//Sets on specific weight
	public void setWeight(int layer, int node, int input, double weight)
	{
		this.layer.get(layer).pcts.get(node).weights.set(input, weight);
	}
	
	//Sets on specific bias
	public void setBias(int layer, int node, double bias)
	{
		this.layer.get(layer).pcts.get(node).bias=bias;
	}
}