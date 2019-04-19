package thomas.hofmann;

import java.util.ArrayList;

@SuppressWarnings("serial")
//Holds the input for one Layer
public class InputArray extends ArrayList<ArrayList<Double>>
{
	//Constructor from Superclass
	public InputArray()
	{
		super();
	}
	
	//Converting a single ArrayList into a nested ArrayList (input-data-type used by the 'Layer' class)
	public void addList(ArrayList<Double> inputs)
	{
		for(Double d : inputs)
		{
			ArrayList<Double> temp = new ArrayList<Double>();
			temp.add(d);
			this.add(temp);
		}
	}
}
