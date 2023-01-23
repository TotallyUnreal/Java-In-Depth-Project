package depth.java.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpConnect {
	public static String download(String sourceUrl) throws MalformedURLException, URISyntaxException{
		System.out.println("Downloading: " + sourceUrl);
		URL url = new URI(sourceUrl).toURL();
		
		try {
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			int responseCode = con.getResponseCode();
			if(responseCode >= 200 && responseCode < 300) { // ok
				return IOUtil.read(con.getInputStream());
			} else if(responseCode == 301) {
				System.out.println("moved permanently responseCode of 301");
				System.out.println("Redirecting to new URL...");
				System.out.println("New Location: " + con.getHeaderField("Location"));
				con = (HttpURLConnection) new URL(con.getHeaderField("Location")).openConnection();
				return IOUtil.read(con.getInputStream());
			} else {
				System.out.println("responseCode was not >= 200 and < 300. It was " + responseCode + ".");
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
