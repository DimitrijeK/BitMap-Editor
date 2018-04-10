import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Icon 
{
	//array list to hold our pixels
	private ArrayList<ArrayList<Pixel>> list = new ArrayList<ArrayList<Pixel>>();
	//byte array for BMP
	private ArrayList<Byte> bytes = new ArrayList <Byte>();
	//size of BMP header
	private final static int BITMAPFILEHEADER_SIZE = 54;
	//width
	private int width;
	//height
	private int height;
	
	//default constructor 40x40
	public Icon()
	{
		width = 40;
		height = 40;
		
		//filling out the array list with default pixels
		for(int i = 0; i<width;i++)
		{
			list.add(new ArrayList<>());
			
			for(int j=0;j<height;j++)
			{
				//have to create new pixel object each time 
				list.get(i).add(new Pixel());
			}
		}
	}
	
	//constructor that is going to let user pick dimensions
	public Icon(int width, int height)
	{	
		this.width = width;
		this.height = height;
		
		if(width > 0 && height > 0)
		{
			//filling out the array list with default pixels
			for(int i = 0; i<width;i++)
			{
				list.add(new ArrayList<>());
			
				for(int j=0;j<height;j++)
				{
					//creating new object each time
					list.get(i).add(new Pixel());
				}
			}
		}
		
	}
	
	//method that is going to let user pick specific position and colors
	public Pixel getPixel(int width, int height)
	{
		return list.get(width).get(height);
	}
	
	//fliping bytes since all integer values are in little-Indian format
	public void intToByte(ArrayList<Byte> bytes, int num)
	{
		int data = num<<24;
		data = data>>>24;
		bytes.add((byte)data);
		//--
		data = num<<16;
		data = data>>>24;
		bytes.add((byte)data);
		//--
		data = num<<8;
		data = data>>>24;
		bytes.add((byte)data);
		//--
		data = data>>>24;
		bytes.add((byte)data);
		
	}
	
	//creating and actual Bitmap image file
	//adding bytes to the byte array so we can pass it to file reader
	public void createBitmapFile()
	{
		//BMP header
		bytes.add((byte) 66);//B
		bytes.add((byte) 77);//M
				
		//padding
		int padding = width*3;
		while(padding%4 != 0)
		{
			padding++;
		}
		//calculate the size of the entire file
		//int numOfElements = (width*height)*3;
		int size = padding*list.size();
		size = size + BITMAPFILEHEADER_SIZE;
		
		//add size to array
		intToByte(bytes, size);
		
		//0
		for(int i = 0; i < 4; i++)
		{
			bytes.add((byte)0);
		}
		
		//offset
		intToByte(bytes, BITMAPFILEHEADER_SIZE);
		
		//DIB header
		intToByte(bytes, 40);
		intToByte(bytes, width);
		intToByte(bytes, height);
		bytes.add((byte) 1);
		bytes.add((byte) 0);
		bytes.add((byte) 24);
		bytes.add((byte)0);
		intToByte(bytes, 0);
		intToByte(bytes, 16);
		intToByte(bytes, 0);
		intToByte(bytes, 0);
		intToByte(bytes,0);
		intToByte(bytes, 0);

		
		try
		{
			//user should be able to input their own directory
			String path = JOptionPane.showInputDialog("Enter a directory");
			File file = new File(path + "/Icon.bmp");
			
			//creating new file
			if(!file.exists())
			{
				file.createNewFile();
			}
			
			OutputStream outputstream = new FileOutputStream(file);
			
			
			for(int i = list.size()-1; i >= 0; i--) 
			{
				for (int j = 0; j < list.get(i).size(); j++) 
				{
					bytes.add((byte) list.get(i).get(j).getBlue());
					bytes.add((byte) list.get(i).get(j).getGreen());
					bytes.add((byte) list.get(i).get(j).getRed());
				}

				//padding
				int num = list.get(i).size();
				num *= 3;

				while (num % 4 != 0) 
				{
					bytes.add((byte) 0);
					num++;
				}

			}
			    //new byte array
				byte newByteArray [] = new byte [bytes.size()];
				
				
				for(int i1 = 0; i1 < bytes.size(); i1++)
				{
					newByteArray[i1] = bytes.get(i1);
				}
				
				//passing the byte array
				outputstream.write(newByteArray);
				outputstream.close();
				printHexTable(list);
			
			
		}
		
		catch(IOException ex)
		{ 
			
		}
		
	}
	
	//printing hex table
	private void printHexTable(ArrayList<ArrayList<Pixel>> p){
	    for(int i = 0; i < p.size(); i++){
	        for(int j = 0; j < p.get(i).size(); j++){
	            System.out.print(p.get(i).get(j).printHex()+" ");
            }
            System.out.print("\n");
        }
    }
	
}


