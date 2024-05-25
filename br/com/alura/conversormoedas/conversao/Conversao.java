package br.com.alura.conversormoedas.conversao;

import com.google.gson.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversao {
    private static final String baseUrl = "https://v6.exchangerate-api.com/v6/acc67537ef5b42594cc1a299/pair/";

    public static double obterTaxaConversao(String origem, String destino) throws IOException, InterruptedException {
        String endpoint = baseUrl + origem + "/" + destino;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        JsonObject root = gson.fromJson(json, JsonObject.class);
        return root.get("conversion_rate").getAsDouble();
    }

    // Método para calcular a conversão entre as moedas
    public static double calcularConversao(double valor, double taxa) {
        return valor * taxa;
    }
}
