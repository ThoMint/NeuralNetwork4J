package thomas.hofmann;

import java.util.ArrayList;

public class CodeExample
{
	public static void main(String[] args) {
		//Initializing the NeuralNetwork
		NeuralNetwork nn = new NeuralNetwork();
		
		//Adding the needed Layers
		nn.addInputLayer(2);
		nn.addHiddenLayer(5);
		nn.addHiddenLayer(1);
		
		//Initializing the input/output-ArrayList
		ArrayList<Double> input = new ArrayList<>();
		ArrayList<Double> output = new ArrayList<>();
		
		//Adding inputs to the list	('compute' expects all input-nodes to be fed with a value)
		input.add(0.5);
		input.add(0.1);
		
		OutputSt
		
		System.
		
		//Calculating the result for the full NeuralNetwork
		output=nn.compute(input);
		System.out.println(output);
		
		//Changing Parameters of the NN (NN is fully transparent)
		//Every Component accesable via ArrayLists
		//Changing the weight of the input-node to 0.9
		nn.layer.get(0).pcts.get(0).weights.set(0, 0.9);
	}
}
