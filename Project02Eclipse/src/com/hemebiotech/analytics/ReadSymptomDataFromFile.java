package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Crocodesiles
 *
 * Implementation of the ISymptomReader interface
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filePath;

    /**
     * @param filePath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filePath) {
        this.filePath = filePath;
    }


    /**
     *
     * @return reading the file as parameter of the FileReader
     */
    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<String>();

        if (filePath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
