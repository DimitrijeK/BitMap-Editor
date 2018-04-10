import javax.swing.*;
import java.awt.*;

public class HelpWindow extends JFrame
{
	JFileChooser filechooser;
	
	public HelpWindow(JFrame f)
	{
		super("Choose File");
		setLayout(new FlowLayout());
		
		filechooser = new JFileChooser("Choose Image");
		add(filechooser);
	}
}
