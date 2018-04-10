
public class Pixel
{	
	private int rgb;
	
	//printing hex representatation of pixels
	public String printHex()
	{
	    String val = "#";
		if(Integer.toHexString(getRed()).length() == 1){
		    val += "0";
        }
        val += Integer.toHexString(getRed()).toUpperCase();
		if(Integer.toHexString(getGreen()).length() == 1){
		    val += "0";
        }
        val += Integer.toHexString(getGreen()).toUpperCase();
		if(Integer.toHexString(getBlue()).length() == 1){
		    val += "0";
        }
        val += Integer.toHexString(getBlue()).toUpperCase();
		return val;
	}
	
	//setting values
	public Pixel()
	{
		int b = 127;
		int g = 127;
		int r = 127;
		b = b << 16;
		g = g << 8;
		rgb = r + g + b;
	}
	
	//red setter
	public void setRed(int r) //r should be between 0 - 255
	{
		if(r>=0 && r<=255)
		{
			int red = r;
			int green = getGreen();
			int blue = getBlue();
			green = green << 8;
			blue = blue << 16;
			rgb = red+green+blue;
		}
	}
	
	//red getter
	public int getRed()
	{
		int red = rgb << 24;
		return red >>> 24;
	}
	
	//green setter
	public void setGreen(int g) //g should be between 0 - 255
	{
		if(g>=0 && g<=255)
		{
			int red = getRed();
			int green = g;
			int blue = getBlue();
			green = green << 8;
			blue = blue << 16;
            rgb = red + green + blue;
		}
		
	}
	
	//green getter
	public int getGreen()
	{
		int green = rgb >>> 8;
		green = green << 24;
		return green >>> 24;
	}
	
	//blue setter
	public void setBlue(int b) //b should be between 0 - 255
	{
		if(b>=0 && b<=255) {
            int red = getRed();
            int green = getGreen();
            int blue = b;
            green = green << 8;
            blue = blue << 16;
            rgb = red + green + blue;
        }
	}
	
	//blue getter
	public int getBlue()
	{
		int blue = rgb >>> 16;
		return blue;
	}
}

