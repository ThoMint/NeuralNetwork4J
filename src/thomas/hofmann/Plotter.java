package thomas.hofmann;

import java.awt.BasicStroke;
import thomas.hofmann.Engine;
import thomas.hofmann.GraphicsEngine;
import thomas.hofmann.Window;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JSlider;

//A Class to draw the nodes and weights of a NN
public class Plotter implements Engine
{
	private NeuralNetwork nn;
	private int nodeSize,spaceX,spaceY,maxHeight,maxNodes,maxStrokeWidth;
	private boolean setInput=false;
	private ArrayList<Double> input = new ArrayList<Double>();
	JSlider slider;
	GraphicsEngine ge;
	//Constructor takes the size of the circles that represent the nodes,
	//the space in x and y direction between the nodes
	//and the maximum stroke width for the lines which represent the weights of the NN
	public void plot(NeuralNetwork nn,int nodeSize, int spaceX, int spaceY, int maxStrokeWidth)
	{
		this.spaceX=spaceX;
		this.spaceY=spaceY;
		this.nodeSize=nodeSize;
		this.maxStrokeWidth=maxStrokeWidth;
		this.nn=nn;
		int width = (nn.layer.size()*nodeSize) + ((nn.layer.size()-1)*spaceX) + 16;
		int maxNodes=0;
		//Determines the largest Layer to determine the height of the window
		for(Layer l : nn.layer)
		{
			if(l.pcts.size()>maxNodes)
			{
				maxNodes=l.pcts.size();
			}
		}
		int height = (maxNodes*nodeSize) + ((maxNodes-1)*spaceY) + 40;
		this.maxHeight=height;
		this.maxNodes=maxNodes;
		//Creating the window which contains the GraphicsEngine to display our NeuralNetwork
		Window w = new Window("NeuralNetwork",width, height);
		ge = new GraphicsEngine(w, this);
		//Calling the draw function
		ge.redraw();
	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	public void setInput(ArrayList<Double> input)
	{
		//If the user wants to get its Output of the NN displayed on the Drawing
		//He can just call the setInput Function
		this.input=input;
		this.setInput=true;
		ge.redraw();
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		//If an input was submitted print it
		if(setInput)
		{
			//Since the coordinate system is flipped we have to reverse it to display the text upright
			g.transform(AffineTransform.getScaleInstance(1, -1));
			g.drawString("Output: " + nn.compute(this.input), 0, -5);
			g.transform(AffineTransform.getScaleInstance(1, -1));
		}
		//Arrays to store the position of every node to draw the lines
		int[][] posX = new int [nn.layer.size()][maxNodes];
		int[][] posY = new int [nn.layer.size()][maxNodes];
		for(int l=0;l<nn.layer.size();l++)
		{
			for(int p=0;p<nn.layer.get(l).pcts.size();p++)
			{
				//Saving the positions of every nodes
				int height = (nn.layer.get(l).pcts.size()*nodeSize) + ((nn.layer.get(l).pcts.size()-1)*spaceY) + 40;
				int diff=maxHeight-height;
				int offset=diff/2;
				int x=l*(nodeSize+spaceX);
				int y=p*(nodeSize+spaceY);
				posX[l][p]=x;
				posY[l][p]=y+offset;
			}
		}
		
		//Offset to draw lines at the middle of dots
		int offsToMiddle=nodeSize/2;
		
		for(int l=0;l<nn.layer.size()-1;l++)
		{
			for(int p=0;p<nn.layer.get(l ).pcts.size();p++)
			{
				for(int np=0;np<nn.layer.get(l+1).pcts.size();np++)
				{
					//Calculating to width of the line to represent the weight
					float weight = nn.layer.get(l+1).pcts.get(np).weights.get(p).floatValue();
					//Red lines for negative weights
					//Green lines for positive weights 
					if(weight<0)
					{
						g.setColor(Color.GREEN);
					}else
					{
						g.setColor(Color.RED);
					}
					//Absolut value since .setStroke takes only positive values
					weight=Math.abs(weight);
					if(weight>maxStrokeWidth)
					{
						weight=maxStrokeWidth;
					}
					g.setStroke(new BasicStroke((float) weight));
					//Draw the line from one node to another
					g.drawLine(posX[l][p]+offsToMiddle, posY[l][p]+offsToMiddle, posX[l+1][np]+offsToMiddle, posY[l+1][np]+offsToMiddle);
				}
			}
		}
		
		//Draw all the nodes of the NN
		for(int l=0;l<nn.layer.size();l++)
		{
			for(int p=0;p<nn.layer.get(l).pcts.size();p++)
			{
				int height = (nn.layer.get(l).pcts.size()*nodeSize) + ((nn.layer.get(l).pcts.size()-1)*spaceY) + 40;
				int diff=maxHeight-height;
				int offset=diff/2;
				int x=l*(nodeSize+spaceX);
				int y=p*(nodeSize+spaceY);
				g.translate(x, y);
				g.setColor(Color.BLACK);
				g.fillOval(0,offset, nodeSize, nodeSize);
				g.translate(-x, -y);
			}
		}
		
	}

	@Override
	public void loop(GraphicsEngine arg0)
	{
		
	}
	
}





