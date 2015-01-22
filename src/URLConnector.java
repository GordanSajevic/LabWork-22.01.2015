import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class URLConnector{
	
	private static final String url = "http://klix.ba";
	private static final String path = "/tmp/";
	
	public static void getUrl(String urlToVisit) throws MalformedURLException
	{
		URL urlVisiting = new URL(urlToVisit);
		try {
			URLConnection connection = urlVisiting.openConnection();
			InputStream in = connection.getInputStream();
			System.out.println(printOutput(in));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	private static StringBuilder printOutput(InputStream in) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(in);
		@SuppressWarnings("unused")
		BufferedReader br = new BufferedReader(isr);
		@SuppressWarnings("unused")
		OutputStream os = new BufferedOutputStream(System.out);
		String str = "";
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			if(br.readLine() == null)
			{
				return sb;
			}
			sb.append(br.readLine() + "\n");
			printIntoFile(sb.toString());
		}
		
	}
	
	private static void printIntoFile(String str) throws IOException
	{
		File file = new File(path + "BitCamp.txt");
		FileOutputStream fos = new FileOutputStream(file);
		try {
			fos.write(str.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			fos.close();
		}
		
	}
	
	public static void main(String[] args) 
	{
		try {
			getUrl(url);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	//	System.out.println(getUrl(url));
	}
	
}
