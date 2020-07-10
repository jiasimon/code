package com.sjia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReadCSV {

    public static void main(String[] args) {
        String csvFile = "/Users/sjia/Downloads/london_crime_by_lsoa.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        LocalDateTime startTime =  LocalDateTime.now();

        System.out.println("Start processing london_crime_by_lsoa.csv at " + startTime);
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] record = line.split(cvsSplitBy);

            }

            LocalDateTime endTime =  LocalDateTime.now();
            System.out.println("End processing london_crime_by_lsoa.csv at " + endTime);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
