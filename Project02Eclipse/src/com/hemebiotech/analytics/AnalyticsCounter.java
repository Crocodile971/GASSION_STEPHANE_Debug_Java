package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;
    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    List<String> filepath = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt").GetSymptoms();

    /**
     * @return return file with symptoms
     */
    public List<String> getSymptoms() throws IOException {

        reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

        return reader.GetSymptoms();
    }

    /**
     * @param symptoms list of symptoms in the file
     * @return contains symptoms repeat list
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        List<String> result = filepath;

        Map<String, Integer> counterSymptoms = new HashMap<String, Integer>();

        for (String symptom : result) {
            // on vérifie si le symptom est dèjà présent, alors on incrémente le nombre d'élément
            if (counterSymptoms.containsKey(symptom)) {
                int nbConterSymptom = counterSymptoms.get(symptom);
                counterSymptoms.put(symptom, nbConterSymptom + 1);
            } else {// ajout du symptom en clé , valeur
                counterSymptoms.put(symptom, 1);
            }

        }
        return counterSymptoms;
    }


    /**
     * @param symptoms list of symptoms in the file
     * @return filter files alphabetically
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> sortSymptom = new TreeMap<>(countSymptoms(filepath));

        for (Map.Entry<String, Integer> entry : sortSymptom.entrySet()) {
            if (sortSymptom.containsKey(entry.getKey())) {
                sortSymptom.put(entry.getKey(), entry.getValue() + 1);
            } else {
                sortSymptom.put(entry.getKey(), 1);

            }
        }

        return sortSymptom;
    }


    /**
     * @param symptoms list of symptoms in the filter file
     * @throws IOException
     */
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {

        writer = new WriteSymptomDataToFile("Project02Eclipse/result.out");
        writer.writeSymptoms(symptoms);
    }



    public static void main(String[] args) throws Exception {


        try {
            FileReader fileReader = new FileReader("Project02Eclipse/symptoms.txt");


            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            int i = 0;
            int headCount = 0;
            while (line != null) {
                i++;
                System.out.println("symptom from file: " + line);
                if (line.equals("headache")) {
                    headCount++;
                    System.out.println("number of headaches: " + headCount);
                } else if (line.equals("rash")) {
                    rashCount++;
                } else if (line.contains("pupils")) {
                    pupilCount++;
                }

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
        

        FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headacheCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + pupilCount + "\n");
        writer.close();
    }


}
