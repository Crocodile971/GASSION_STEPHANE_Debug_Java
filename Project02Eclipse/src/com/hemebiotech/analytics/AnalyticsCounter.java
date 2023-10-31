package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    List<String> filePath = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt").getSymptoms();

    /**
     * @return return file with symptoms
     */
    public List<String> getSymptoms() {
        try {
            reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

        } catch (Exception e) {
            System.out.println("Unable to read file" + e.getMessage());
            e.printStackTrace();
        }
        return reader.getSymptoms();
    }

    /**
     * @param symptoms list of symptoms in the file
     * @return contains symptoms repeat list
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        List<String> result = filePath;
        Map<String, Integer> counterSymptoms = new HashMap<String, Integer>();
        try {
            for (String symptom : result) {
                // We check if the symptom is already present, then we increment the number of elements.
                if (counterSymptoms.containsKey(symptom)) {
                    int nbCounterSymptom = counterSymptoms.get(symptom);
                    counterSymptoms.put(symptom, nbCounterSymptom + 1);
                } else {
                    // Adding the symptom in key, value.
                    counterSymptoms.put(symptom, 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Impossible to count symptoms" + e.getMessage());
            e.printStackTrace();
        }
        return counterSymptoms;
    }


    /**
     * @param symptoms list of symptoms in the file
     * @return filter files alphabetically
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> sortSymptom = new TreeMap<>(countSymptoms(filePath));
        try {
            for (Map.Entry<String, Integer> entry : sortSymptom.entrySet()) {
                if (sortSymptom.containsKey(entry.getKey())) {
                    // We check if the key is present and add it with the value.
                    sortSymptom.put(entry.getKey(), entry.getValue());
                } else {
                    // Adding the symptom with nominal value.
                    sortSymptom.put(entry.getKey(), 1);

                }
            }

        } catch (Exception e) {
            System.out.println("Sort alphabetically not possible" + e.getMessage());
            e.printStackTrace();
        }

        return sortSymptom;
    }


    /**
     * @param symptoms list of symptoms in the filter file
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            writer = new WriteSymptomDataToFile("Project02Eclipse/result.out");
            writer.writeSymptoms(symptoms);

        } catch (Exception e) {
            System.out.println("Unable to write file" + e.getMessage());
            e.printStackTrace();
        }
    }

}
