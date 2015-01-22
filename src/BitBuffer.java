import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class BitBuffer {
	
	private ArrayList<Byte> bufferedInput;
	OutputStream os;
	InputStream is; 
	private byte[] buffer;
	private int counter;
	
	public BitBuffer(InputStream is)
	{
		bufferedInput = new ArrayList<Byte>();
		os = new DataOutputStream(System.out);
		buffer = new byte[10];
	}

	private void toArray() throws IOException
	{
		while( is.read(buffer) >= 0 )
		{
			
			for(int i = 0; i < buffer.length; i++)
			{
				
				if(buffer[i] == (byte)('\n'))
				{	
					byte[] output = new byte[bufferedInput.size()];
					int index = 0;
					for(Byte b : bufferedInput)
					{
						output[index++] = (byte) b;
					}
					bufferedInput.clear();
				} 
				else 
				{
					bufferedInput.add(buffer[i]);
				}
			}
		}
	}
	
	public String nextLine() throws IOException
	{
		toArray();
		String line = bufferedInput.get(counter).toString();
		counter++;
		return line;
	}

}
