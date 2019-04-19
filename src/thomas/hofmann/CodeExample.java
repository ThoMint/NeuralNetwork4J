package thomas.hofmann;

import java.util.ArrayList;

public class CodeExample
{
	public static void main(String[] args) {
		//Initializing the NeuralNetwork
		NeuralNetwork nn = new NeuralNetwork();
		
		//Adding the needed Layers
		nn.addInputLayer(2,ActFunctions.RELU);
		nn.addHiddenLayer(4,ActFunctions.RELU);
		nn.addOutputLayer(1, ActFunctions.RELU);
		
		//Initializing the input/output-ArrayList
		ArrayList<Double> input = new ArrayList<>();
		ArrayList<Double> output = new ArrayList<>();
		
		//Adding inputs to the list	('nn.compute' expects all input-nodes to be fed with a value)
		input.add(9.1);
		input.add(9.1);
		
		//Changes the current value of the weight/bias randomly by the mutation-rate
		nn.mutateWeights(0.1);
		nn.mutateBias(0.1);
		
		//Sets the weight of one specific node 
		nn.setWeight(0, 0, 0, 0.5);
		nn.setBias(1, 0, 1.0);
		
		//Randomizes every weight of the NN
		nn.randomizeWeights(-1, 1);
		
		//Calculating the result for the NeuralNetwork
		output=nn.compute(input);
		
		//Printing the output to the console
		System.out.println(output);
	}
}
