package com.sjia.poc;

import org.json.JSONArray;
import org.json.JSONObject;

public class OrgJsonExample {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Alice\", \"age\":30, \"skills\":[\"Java\", \"SQL\"]}";

        // 1. Wrap the string in a JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);

        // 2. Extract fields by their key name and expected data type
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        JSONArray skills = jsonObject.getJSONArray("skills");

        // 3. Output values
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("First Skill: " + skills.getString(0));
    }
}

