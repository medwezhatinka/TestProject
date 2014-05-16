package com.nbcu.tele.datahandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class BuildVersionReader {

    public BuildVersionReader() {
	}

	public String readFromWebPage(String webSite) throws IOException { 
        URL url = new URL(webSite);
        Document doc = Jsoup.parse(url, 60*1000);
        
        String text = doc.body().text();
        return text;
    }
	
	public String readSavedBuildVerisonFromFile(String fileName) { 
		File fileToRead = new File(fileName);

		StringBuilder content = new StringBuilder();	    
	    try {
	      BufferedReader input =  new BufferedReader(new FileReader(fileToRead));
	      try {
	        String line = null; 
	        while (( line = input.readLine()) != null){
	          content.append(line);
	          content.append(System.getProperty("line.separator"));
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    
	    return content.toString();
    }
    
}
