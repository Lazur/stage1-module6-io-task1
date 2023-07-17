package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    
    public Profile getDataFromFile(File file) {    
        String name = "";
        Integer age = 1;
        String email = "";
        Long phone = (long) 1;

        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] data = line.split(":");
                if (line.startsWith("Name:")) {
                    name = data[1].trim();    
                } else if (line.startsWith("Age:")) {
                    age = Integer.parseInt(data[1].trim());
                } else if (line.startsWith("Email:")) {
                    email = data[1].trim();
                } else if (line.startsWith("Phone:")) {
                    phone = Long.parseLong(data[1].trim());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new Profile(name, age, email, phone);
    }
}
