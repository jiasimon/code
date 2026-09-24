package com.sjia.poc;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientJsonFetcher {
    // HttpClient call url , get json

        public static void main(String[] args) {
            // 1. Create the HTTP Client
            HttpClient client = HttpClient.newHttpClient();

            // 2. Build the request with JSON headers
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.example.com/data"))
                    .header("Accept", "application/json") // Request JSON from the server
                    .GET()
                    .build();

            try {
                // 3. Send the request synchronously
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // 4. Evaluate the response status
                if (response.statusCode() == 200) {
                    String jsonResponse = response.body();
                    System.out.println("JSON Data Received:\n" + jsonResponse);
                } else {
                    System.out.println("GET request failed. Status Code: " + response.statusCode());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    



}
