import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

//holds my sliders and their values
//also holds a panel with preview color

public class SliderFrame extends JPanel
{
	private JSlider redSlider,greenSlider,blueSlider;
	private JLabel redLabel,greenLabel,blueLabel;
	private JPanel colorPanel,sliders,labels;
	public Pixel pixel;
	
	private int red;
	private int green;
    private	int blue;
	
	public SliderFrame()
	{
		pixel = new Pixel();
		
		redSlider = new JSlider(JSlider.HORIZONTAL,0,255,0);
		greenSlider = new JSlider(JSlider.HORIZONTAL,0,255,0);
		blueSlider = new JSlider(JSlider.HORIZONTAL,0,255,0);
		
		redLabel = new JLabel("Red value: 0");
		greenLabel = new JLabel("Green value: 0");
		blueLabel = new JLabel("Blue value: 0");
		
		
		event e = new event();
		redSlider.addChangeListener(e);
		greenSlider.addChangeListener(e);
		blueSlider.addChangeListener(e);
		
		colorPanel = new JPanel();
		colorPanel.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(3,1,3,3));
		
		
		sliders = new JPanel();
		labels = new JPanel();
		
		this.add(sliders);
		this.add(labels);
		this.add(colorPanel);
		
		sliders.setLayout(new GridLayout(3,1,2,2));
		sliders.add(redSlider);
		sliders.add(greenSlider);
		sliders.add(blueSlider);
		
		labels.setLayout(new GridLayout(3,1,2,2));
		labels.add(redLabel);
		labels.add(greenLabel);
		labels.add(blueLabel);
	
        setVisible(true);
	}
	
	public class event implements ChangeListener
	{
		public void stateChanged(ChangeEvent e)
		{
			setRed(redSlider.getValue());
			setGreen(greenSlider.getValue());
			setBlue(blueSlider.getValue());
			
			red = redSlider.getValue();
			green = greenSlider.getValue();
			blue = blueSlider.getValue();
			
			redLabel.setText("Red value: " + red);
			greenLabel.setText("Green value: " + green);
			blueLabel.setText("Blue value: " + blue);
			
			colorPanel.setBackground(new Color(red,green,blue));
		}
	}
	
	public void setRed(int r)
	{
		red = r;
	}
	public int getRed()
	{
		return red;
	}
	
	public void setGreen(int g)
	{
		green = g;
	}
	public int getGreen()
	{
		return green;
	}
	
	public void setBlue(int b)
	{
		blue = b;
	}
	public int getBlue()
	{
		return blue;
	}
	
	public JPanel getPanel()
	{
		return colorPanel;
	}
}
