package com.mageddo.tests.jetty.junit.servlets;

import com.mageddo.tests.core.Properties;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author deFreitas edigitalb@gmail.com
 */

public class HelloWorldServletIT {
	
	@Test
	public void getTest() throws MalformedURLException, IOException{
		BufferedReader bf = new BufferedReader(
			new InputStreamReader(
				new URL(Properties.BASE_PATH + "/helloWorld")
				.openConnection().getInputStream()
			)
		);
		
		StringBuilder sb = new StringBuilder();
		String buffer;
		while((buffer = bf.readLine()) != null){
			sb.append(buffer);
		}
		Assert.assertEquals(HelloWorldServlet.GET_MESSAGE, sb.toString());
	}
	
	@Test
	public void postTest() throws MalformedURLException, IOException{
		
		HttpURLConnection con = (HttpURLConnection) new URL(Properties.BASE_PATH + "/helloWorld")
				.openConnection();
				con.setRequestMethod("POST");
		BufferedReader bf = new BufferedReader(
			new InputStreamReader(
				con.getInputStream()
			)
		);
		
		StringBuilder sb = new StringBuilder();
		String buffer;
		while((buffer = bf.readLine()) != null){
			sb.append(buffer);
		}
		Assert.assertEquals(HelloWorldServlet.POST_MESSAGE, sb.toString());
	}
}
