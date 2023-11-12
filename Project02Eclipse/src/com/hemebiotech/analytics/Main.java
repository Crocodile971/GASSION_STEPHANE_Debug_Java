package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        AnalyticsCounter analyticsCounter = getAnalyticInstance();


        // Step 1: read the symptom.txt file to the file of symptoms ( method: getSymptoms() ).
        List<String> listSymptom = analyticsCounter.getSymptoms();
        System.out.println("The list of symptoms is: " + listSymptom);


        // Step 2: Count the symptoms ( method: countSymptoms() ).
        Map<String, Integer> countOfSymptom = analyticsCounter.countSymptoms(listSymptom);
        System.out.println("The count of symptoms and theirs occurrences is: " + countOfSymptom);


        // Step 3: Sort the list of symptoms ( method: sortSymptoms() ).
        Map<String, Integer> sortOfSymptom = analyticsCounter.sortSymptoms(countOfSymptom);
        System.out.println("The file sorted alphabetically by symptoms and theirs occurrences is: " + sortOfSymptom);

        // Step 4: Write the result to the output file result.out ( method: writeSymptoms() ).
        Map<String, Integer> Symptoms = analyticsCounter.sortSymptoms(countOfSymptom);
        analyticsCounter.writeSymptoms(Symptoms);
        System.out.println("The output file is: " + Symptoms);


    }

    public static AnalyticsCounter getAnalyticInstance() {
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        WriteSymptomDataToFile writer = new WriteSymptomDataToFile("Project02Eclipse/result.out");

        return new AnalyticsCounter(reader, writer);
    }
}
