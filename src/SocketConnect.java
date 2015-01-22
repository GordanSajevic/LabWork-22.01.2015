import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.print.attribute.standard.Severity;

public class SocketConnect {

	public static final String serverAddress = "127.0.0.1";
	public static final int serverPort = 1463;

	private static void connectToServer() throws UnknownHostException, IOException
	{
		Socket client = new Socket(serverAddress, serverPort);
		InputStream clientIn = client.getInputStream();
		OutputStream clientOut = client.getOutputStream();
	}
	
	public static void main(String[] args) {
		try {
			connectToServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
