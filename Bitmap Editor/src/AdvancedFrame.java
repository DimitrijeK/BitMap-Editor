import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

//advanced frame is used for asking for rows and columns
//and using that it will create a colored block of pixels PART1
//advanced frame is used for reading in a new image PART2
public class AdvancedFrame extends JFrame
{
	private int rowsNumber;
	private int columnsNumber;
	private JButton chooseimage;
	private JButton createimage;
	private JButton button;
	private JFileChooser advanced;
	private JPanel firstPanel;
	private JPanel secondPanel;
	private JLabel rows;
	private JLabel columns;
	private JLabel empty;
	private JTextField text1;
	private JTextField text2;
	private JTabbedPane tabbedpane;
	
	public AdvancedFrame(PixelFrame p, ArrayList<ArrayList<PixelButton>> pa, SliderFrame sf)
	{
		super("Choose an Image");
		setLayout(new GridLayout(1,4,4,4));
		this.setSize(500, 500);
		
		text1 = new JTextField(20);		
		text2 = new JTextField(20);
		
		firstPanel = new JPanel();
		secondPanel = new JPanel();
		rows = new JLabel("Rows");
		empty = new JLabel("      ");
		columns = new JLabel("Columns");
		tabbedpane = new JTabbedPane();
		
		button = new JButton("OK");
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				PixelButton temp = p.getLastButton();
				Color c = temp.getBackground();
				int x = temp.getXCoord();
				int y = temp.getYCoord();
				
				rowsNumber = Integer.valueOf(text1.getText());
				columnsNumber = Integer.valueOf(text2.getText());
				
				for(int i = 0; i < rowsNumber;i++)
				{
					
					for(int j = 0; j < columnsNumber; j++)
					{
						pa.get(x+i).get(y+j).setBackground(c);
					}
				}
				
			}
			
		});
		
		firstPanel.add(text1);
		firstPanel.add(rows);
		firstPanel.add(text2);
		firstPanel.add(columns);
		firstPanel.add(button);
		
		tabbedpane.addTab("Block",firstPanel);
		tabbedpane.addTab("Choose Image", secondPanel);
		
		this.add(tabbedpane);
		
		chooseimage = new JButton("Choose Image");
		chooseimage.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent e)
            {
        		HelpWindow help = new HelpWindow(AdvancedFrame.this);
        		help.setSize(1000,400);
        		help.setLocation(300,200);
        		help.setVisible(true);
        		help.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
		secondPanel.add(chooseimage);
		
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
