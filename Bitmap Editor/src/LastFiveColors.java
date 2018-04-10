import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

//last five colors class is used to create
//5 buttons that are going to represent and show 
//last 5 colors that user was using
//you can also click on any of them and use that
//color for coloring you pixels

public class LastFiveColors extends JButton
{
	private PixelButton button1;
	private PixelButton button2;
	private PixelButton button3;
	private PixelButton button4;
	private PixelButton button5;
	private int red;
	private int green;
	private int blue;
	ArrayList <PixelButton> lastfivecolorslist = new ArrayList<PixelButton>();
	
	public LastFiveColors(SliderFrame sf)
	{
		this.setLayout(new GridLayout(5,5,5,5));
		button1 = new PixelButton(-1,-1);
		button1.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent e)
            {
        		Color c = button1.getBackground();
        		int r = c.getRed();
        		int g = c.getGreen();
        		int b = c.getBlue();
        		sf.setRed(r);
        		sf.setGreen(g);
        		sf.setBlue(b);
            }
        });
		button2 = new PixelButton(-1,-1);
		button2.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent e)
            {
        		Color c = button2.getBackground();
        		int r = c.getRed();
        		int g = c.getGreen();
        		int b = c.getBlue();
        		sf.setRed(r);
        		sf.setGreen(g);
        		sf.setBlue(b);
            }
        });
		
		button3 = new PixelButton(-1,-1);
		button3.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent e)
            {
        		Color c = button3.getBackground();
        		int r = c.getRed();
        		int g = c.getGreen();
        		int b = c.getBlue();
        		sf.setRed(r);
        		sf.setGreen(g);
        		sf.setBlue(b);
            }
        });
		
		button4 = new PixelButton(-1,-1);
		button4.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent e)
            {
        		Color c = button4.getBackground();
        		int r = c.getRed();
        		int g = c.getGreen();
        		int b = c.getBlue();
        		sf.setRed(r);
        		sf.setGreen(g);
        		sf.setBlue(b);
            }
        });
		
		button5 = new PixelButton(-1,-1);
		button5.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent e)
            {
        		Color c = button5.getBackground();
        		int r = c.getRed();
        		int g = c.getGreen();
        		int b = c.getBlue();
        		sf.setRed(r);
        		sf.setGreen(g);
        		sf.setBlue(b);
            }
        });
		
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
		
		lastfivecolorslist.add(button1);
		lastfivecolorslist.add(button2);
		lastfivecolorslist.add(button3);
		lastfivecolorslist.add(button4);
		lastfivecolorslist.add(button5);
		
		setVisible(true);
		setSize(100,100);
	}
	
	public JButton getLast(int counter)
	{
		JButton button = lastfivecolorslist.get(counter);
		return button;
		
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
}
