import javax.swing.JButton;

//used just for button locations
public class PixelButton extends JButton
{
    private int xCoord;
    private int yCoord;
    private boolean onGrid;

    public PixelButton(int x, int y)
    {
        super("");
        setXCoord(x);
        setYCoord(y);
    }

    public int getXCoord()
    {
        return xCoord;
    }

    public void setXCoord(int x)
    {
        if(x >= 0)
        {
            xCoord = x;
        }
        else
        {
            xCoord = 0;
        }
    }

    public int getYCoord()
    {
        return yCoord;
    }
    
    public boolean getGrid(){
    	return onGrid;
    }

    public void setYCoord(int y)
    {
        if(y >= 0)
        {
            yCoord = y;
        }
        else
        {
            yCoord = 0;
        }
    }
}