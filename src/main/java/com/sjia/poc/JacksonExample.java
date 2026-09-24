package com.sjia.poc;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExample {

    public static class User {
        public String name;
        public int age;
        public List<String> skills;
    }

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Alice\", \"age\":30, \"skills\":[\"Java\", \"SQL\"]}";

        try {
            // 2. Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Parse JSON into the Java Object
            User user = mapper.readValue(jsonString, User.class);

            // 4. Access the fields cleanly
            System.out.println("Name: " + user.name);
            System.out.println("Age: " + user.age);
            System.out.println("First Skill: " + user.skills.get(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
