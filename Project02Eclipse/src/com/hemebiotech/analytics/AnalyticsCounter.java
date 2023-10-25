package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {

    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;


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
