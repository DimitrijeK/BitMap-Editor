import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//this class puts everything together and creates
//all objects and then puts them in one window
//east west south north and center

public class MyJFrame extends JFrame implements ActionListener
{
	private int rows;
	private int columns;
	private Icon icon;
	private ArrayList<ArrayList<PixelButton>> pixelarray;
	private PixelFrame pixelframe;
	private SliderFrame sliderframe;
	private LastFiveColors fivecolors;
	private JButton south;
	private JButton north;
	
	public MyJFrame()
	{
		super("Welcome to Bitmap Editor!");
		getContentPane().setLayout(new BorderLayout());
		
		//user input
		String userRows = JOptionPane.showInputDialog("Enter rows: ");
		rows = Integer.parseInt(userRows);
		
		String userColumns = JOptionPane.showInputDialog("Enter columns: ");
		columns = Integer.parseInt(userColumns);
		
		//buttons at the top and bottom
		south = new JButton("Click to see Advanced Options");
		south.addActionListener(this);
		
		//north button creates a BMP file in which every
		//directory you choose
		north = new JButton("Click to create a BMP File");
		north.addActionListener(this);
		
		//all objects
		pixelarray = new ArrayList<ArrayList<PixelButton>>();
		icon = new Icon(rows,columns);
		sliderframe = new SliderFrame();
		fivecolors = new LastFiveColors(sliderframe);
		pixelframe = new PixelFrame(rows,columns,sliderframe, fivecolors, icon, pixelarray);
		
		getContentPane().add(pixelframe, BorderLayout.CENTER);
		getContentPane().add(sliderframe, BorderLayout.EAST);
		getContentPane().add(fivecolors, BorderLayout.WEST);
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(north, BorderLayout.NORTH);
		
		setSize(1000,800);
		setLocation(250,50);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == south)
		{
			AdvancedFrame frame = new AdvancedFrame(pixelframe, pixelarray, sliderframe);
		}
		
		else
		{
			icon.createBitmapFile();
		}
	}
}
