package com.sjia.hackerRank;



import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import com.opencsv.CSVReader;

public class ReadCSVByLibrary {

    public static void main(String[] args) {

        String csvFile = "/Users/sjia/Downloads/london_crime_by_lsoa.csv";

        CSVReader reader = null;
        LocalDateTime startTime =  LocalDateTime.now();

        System.out.println("Start processing london_crime_by_lsoa.csv at " + startTime);
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                //System.out.println("Country [id= " + line[0] + ", code= " + line[1] + " , name=" + line[2] + "]");
            }
            LocalDateTime endTime =  LocalDateTime.now();
            System.out.println("End processing london_crime_by_lsoa.csv at " + endTime);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
