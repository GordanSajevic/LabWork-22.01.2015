import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class Writing {

	public static void main(String[] args) throws IOException {
		
		byte[] buffer = new byte[10];
		InputStream is = new DataInputStream(System.in);
		OutputStream os = new DataOutputStream(System.out);
		ArrayList<Byte> bufferedInput = new ArrayList<Byte>();
		
/*		while( is.read(buffer) >= 0 )
		{
			
			for(int i = 0; i < buffer.length; i++)
			{
				
				if(buffer[i] == (byte)'\n')
				{	
					byte[] output = new byte[bufferedInput.size()];
					int index = 0;
					for(Byte b : bufferedInput){
						output[index++] = (byte) b;
					}
					os.write("".getBytes());
					os.write(output);
					os.flush();
					bufferedInput.clear();
				} 
				else 
				{
					bufferedInput.add(buffer[i]);
				}
				
			}

		}*/
		BitBuffer bb = new BitBuffer(is);
		System.out.println(bb.nextLine());
		
		

	}

}
