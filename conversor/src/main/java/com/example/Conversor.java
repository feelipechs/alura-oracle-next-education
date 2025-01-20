package com.example;

import java.util.Map;

public class Conversor {
    private Api apiClient = new Api();
    private Map<Integer, String[]> conversionMap = Map.of(
        1, new String[]{"USD", "BRL"},
        2, new String[]{"BRL", "USD"},
        3, new String[]{"EUR", "USD"},
        4, new String[]{"USD", "EUR"},
        5, new String[]{"BRL", "EUR"},
        6, new String[]{"EUR", "BRL"}
    );

    public double convert(int choice, double amount) throws Exception {
        if (!conversionMap.containsKey(choice)) {
            throw new IllegalArgumentException("Opção inválida.");
        }

        String from = conversionMap.get(choice)[0];
        String to = conversionMap.get(choice)[1];
        double rate = apiClient.getExchangeRate(from, to);

        return amount * rate;
    }
}
