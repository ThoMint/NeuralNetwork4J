package thomas.hofmann;

import java.util.ArrayList;

public class Layer {
	public ArrayList<Perceptron> pcts = new ArrayList<Perceptron>();
	public int numberOfPCTS = 0;
	public int inputsPerPCT = 0;
	public ActFunctions activation = ActFunctions.RELU;

	// Constructor takes the number of Perceptrons, the number of Inputs per
	// Perceptron and the activationfunction
	public Layer(int pcts, int pctInputs, ActFunctions activation) {
		this.numberOfPCTS = pcts;
		this.inputsPerPCT = pctInputs;
		this.activation = activation;
		for (int x = 0; x < pcts; x++) {
			this.pcts.add(new Perceptron(pctInputs));
		}
	}

	// Calculates the output of every Perceptron of the layer
	public ArrayList<Double> compute(InputArray inputs) {
		ArrayList<Double> outP = new ArrayList<Double>();
		// Iterating over every Perceptron of the Layer
		for (int i = 0; i < numberOfPCTS; i++) {
			// Feeding the input into the Perceptron
			pcts.get(i).uptdate(inputs.get(i));

			// Chosing Activation Function and calculating the result
			switch (activation) {
			case SIGMOID:
				outP.add(pcts.get(i).sigmoid());
				break;
			case TANH:
				outP.add(pcts.get(i).tanh());
				break;
			case RELU:
				outP.add(pcts.get(i).relu());
				break;
			default:
				break;
			}
		}
		return outP;
	}
}
