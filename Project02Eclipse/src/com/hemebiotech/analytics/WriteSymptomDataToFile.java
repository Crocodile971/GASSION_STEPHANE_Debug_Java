package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String fileWritePath;

    /**
     * @param fileWritePath path to file with  the symptoms and theirs quantities in result file
     */
    public WriteSymptomDataToFile(String fileWritePath) {
        this.fileWritePath = fileWritePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {


        File file = new File(fileWritePath);
        if (!file.exists())
            try {
                file.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        else {
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(fileWriter);

                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

                    writer.write("symptom from file: " + entry.getKey() + " : " + entry.getValue());
                    writer.newLine();
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Failure while loading error " + e.getMessage());
                e.printStackTrace();
            }
        }


    }
}
