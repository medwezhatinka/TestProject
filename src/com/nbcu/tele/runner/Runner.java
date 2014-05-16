package com.nbcu.tele.runner;

import java.io.IOException;

import com.nbcu.tele.datahandler.BuildVersionHandler;

public class Runner {
	private final static String URL = "http://nbcutelemundoacc.prod.acquia-sites.com/sites/nbcutelemundo/tag.php";
	private final static String FILE_NAME = "LastVersion.txt";
	
	public static void main(String[] args) {
		try {
			Runner tr = new Runner();
			tr.verifyIfNewVersionReleased(URL, FILE_NAME);
		} catch (Exception e) {
			
		} finally {
			int exitCode = BuildResult.getExitResult();
			System.exit(exitCode);
		}
	}
	
	private void verifyIfNewVersionReleased(String url, String fileName) throws IOException{

		BuildVersionHandler handler = new BuildVersionHandler();
		
		if(handler.compareVersions(url, fileName)){
			BuildResult.setExitResult(BuildResult.SUCCESS);
		}
	}
}
