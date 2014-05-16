package com.nbcu.tele.datahandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class BuildVersionUpdater {
	
	public BuildVersionUpdater() {
	}

	public void updateVersionInFile(String currentBuild, String fileName) {
		BufferedWriter writer = null;
        try {
            File file = new File(fileName);

            writer = new BufferedWriter(new FileWriter(file));
            writer.write(currentBuild);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
	}

}
