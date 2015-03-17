package edu.ucsb.cs56.projects.github.apiv3_simple_rest_client;


import javax.json.*;
import javax.json.spi.*;
import javax.json.stream.*;
import javax.json.stream.JsonParser.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

 
public class CS56ProjectList {

    public static String readAllBytes(String filename) throws Exception {
	return new String(Files.readAllBytes(Paths.get(filename))).trim();
    }


    public static void main(String[] args)    {

        try {

	    String oauthToken = Demo1.readAllBytes("tokens/MostPrivileges.txt");
	   // writer.write("Read oauthToken--length is " + oauthToken.length());
	    
	    URL url = new URL("https://api.github.com/orgs/UCSB-CS56-Projects/repos?per_page=100");
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Accept", "application/json");
	    conn.setRequestProperty("Authroization", "token " + oauthToken);
	    InputStream is = conn.getInputStream();
	    JsonParser parser = Json.createParser(is);

      File file = new File("data.csv");
      // creates the file
      file.createNewFile();
      // creates a FileWriter Object
      FileWriter writer = new FileWriter(file); 
      //String to hold project name for issues URL
      String projectName = "";
      String projectDescription = "";
	    while (parser.hasNext()) {
		Event e = parser.next();
		if (e == Event.KEY_NAME) {
		    switch (parser.getString()) {
		    case "name":
			parser.next();
			projectName = parser.getString();
			break;
		    case "description":
			parser.next();
			projectDescription = parser.getString().replace(",","\",\"").replace("|",",");
			break;
		    case "has_issues":
			String issuesUrl = "https://api.github.com/repos/UCSB-CS56-Projects/" + projectName + "/issues?state=all";
			URL url2 = new URL(issuesUrl);
			HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
			conn2.setRequestMethod("GET");
			conn2.setRequestProperty("Accept", "application/json");
			conn2.setRequestProperty("Authroization", "token " + oauthToken);
		      	InputStream is2 = conn2.getInputStream();
			JsonParser issuesParser = Json.createParser(is2);
			while (issuesParser.hasNext()){
			    Event ie = issuesParser.next();
			    if (ie == Event.KEY_NAME){
				switch (issuesParser.getString()){
				case "number":
				    writer.write(projectName);
				    writer.write(", ");
				    writer.write(projectDescription);
				    writer.write(" , ");
				    issuesParser.next();
				    writer.write(issuesParser.getString());
				    writer.write(" , ");
				    break;
				case "state":
				    issuesParser.next();
				    writer.write(issuesParser.getString());
				    writer.write(" , ");
				    break;
				case "login":
				    issuesParser.next();
				    writer.write(issuesParser.getString());
				    writer.write(" , ");
				    break;
				case "title":
				    issuesParser.next();
				    writer.write(issuesParser.getString());
				    writer.write(" , ");
				    break;
				case "body":
				    issuesParser.next();
				    writer.write(issuesParser.getString().replace(',','.').replace('\n', ' ').replace('\r', ' '));
				    writer.write("\n");
				    break;
				}//switch
			    }//if
			}//while
		    } // switch
		} // if
	    } // while
	    writer.flush();
	    writer.close();
	}  catch (MalformedURLException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();        
	} catch (Exception e) {
	    e.printStackTrace();
	} // try



    } // main
}
 
