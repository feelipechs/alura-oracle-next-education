package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// public class Api {
//     private static final String API_URL = "https://v6.exchangerate-api.com/v6/2019f3c3d933c303f6f11310/latest/";

//     public double getExchangeRate(String from, String to) throws Exception {
//         HttpClient client = HttpClient.newHttpClient();
//         HttpRequest request = HttpRequest.newBuilder()
//             .uri(URI.create(API_URL + from))
//             .build();

//         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

//         if (response.statusCode() != 200) {
//             throw new RuntimeException("Erro ao obter taxas de câmbio.");
//         }

//         ObjectMapper mapper = new ObjectMapper();
//         JsonNode root = mapper.readTree(response.body());
//         JsonNode rates = root.path("rates");

//         if (!rates.has(to)) {
//             throw new RuntimeException("Moeda não encontrada.");
//         }

//         return rates.get(to).asDouble();
//     }
// }
public class Api {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/2019f3c3d933c303f6f11310/latest/";

    public double getExchangeRate(String from, String to) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(API_URL + from))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.out.println("Erro: " + response.body());
            throw new RuntimeException("Erro ao obter taxas de câmbio. Código: " + response.statusCode());
        }

        // Parse do JSON retornado
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.body());
        JsonNode rates = root.path("conversion_rates"); // Correção do campo JSON

        if (!rates.has(to)) {
            throw new RuntimeException("Moeda não encontrada: " + to);
        }

        return rates.get(to).asDouble();
    }
}