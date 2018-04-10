import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

//pixel frame class is used to create a grid of buttons
//depending on what number of rows and columns you enter
//it is also changing colors in my 2d pixel array
//so I can use that to create my file later

public class PixelFrame extends JButton
{
	private int red;
	private int green;
	private int blue;
	private int counter = 0;
	
	private PixelButton pb;
	
    public PixelFrame(int rows, int cols, SliderFrame sf, LastFiveColors lfc, Icon ic, ArrayList<ArrayList<PixelButton>> pa)
    {
    	this.setLayout(new GridLayout(rows, cols));

        for(int i = 0;i < rows;i++)
        {
        	pa.add(new ArrayList<>());
            for(int j = 0;j < cols;j++)
            {
            	pa.get(i).add(new PixelButton(i, j));
                JButton b = pa.get(i).get(j);
                b.addActionListener(new ActionListener()
                {
                	@Override
                    public void actionPerformed(ActionEvent e)
                    {
                		int x = ((PixelButton)e.getSource()).getXCoord();
                       	int y = ((PixelButton)e.getSource()).getYCoord();

                       	red = sf.getRed();
                       	green = sf.getGreen();
                       	blue = sf.getBlue();
                       	Pixel pix = (Pixel)ic.getPixel(x, y);
                       	pix.setRed(red);
                       	pix.setGreen(green);
                       	pix.setBlue(blue);
                       	((PixelButton)e.getSource()).setBackground(new Color(red,green,blue));
                       	setLastButton((PixelButton)e.getSource());
                       	
                       	if(counter == 5)
                       	{
                       		counter = 0;
                       	}
                       	
                       	boolean foundNew = false;
                       	JButton b;
                       	
                       	//making sure that colors used are not repeating
                       	//only add a color if there is no instance of that color
                       	
                       	for(int i = 0; i < 5; i++)
                       	{
                       	    b = lfc.getLast(i);
                       	    Color c = b.getBackground();
                       	    foundNew = (c.getRed() == pix.getRed()) && (c.getGreen() == pix.getGreen()) 
                       	    			&& (c.getBlue() == pix.getBlue());
                       	    if(foundNew)
                       	    {
                       	        break;
                            }
                        }

                       	//same here if that color is not found, add it 
                        if(!foundNew) 
                        {
                            lfc.setRed(red);
                            lfc.setGreen(green);
                            lfc.setBlue(blue);
                            b = lfc.getLast(counter);
                            b.setBackground(new Color(red, green, blue));
                            counter++;
                        }
                       	
                       	
                    }
                });
                this.add(b);
            }   
        }
        setVisible(true);
    }
    
    public void setLastButton(PixelButton bt)
    {
    	pb = bt;
    }
    
    public PixelButton getLastButton()
    {
    	return pb;
    }
    
}