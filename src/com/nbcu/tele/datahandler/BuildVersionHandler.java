package com.nbcu.tele.datahandler;

import java.io.IOException;

public class BuildVersionHandler {
	
	private String currentBuild;
	private String lastParsedBuildVersion;
	private boolean isVersionChanged = false; 
	
	public BuildVersionHandler() {
	}

	public boolean compareVersions(String url, String fileName) throws IOException {
		BuildVersionReader reader = new BuildVersionReader();
		currentBuild = reader.readFromWebPage(url);
		System.out.println("1 ****** " + currentBuild + " *********");
//		currentBuild = "Build v2.0.5";
		lastParsedBuildVersion = reader.readSavedBuildVerisonFromFile(fileName).trim();
		System.out.println("2 ****** " + lastParsedBuildVersion + " *********");
		if (!lastParsedBuildVersion.equalsIgnoreCase(currentBuild)){
			isVersionChanged = true;
			updateBuildVersionInFile(currentBuild, fileName);
		}
		return isVersionChanged;
	}
	
	private void updateBuildVersionInFile(String currentBuild, String fileName){
		BuildVersionUpdater writer = new BuildVersionUpdater();
		writer.updateVersionInFile(currentBuild, fileName);
	}
}
