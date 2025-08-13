package com.divisa.convetidor.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.divisa.convetidor.Principal.Lectura;
import com.google.gson.Gson;

public class Consulta {
    public Divisa conexion(String base, String cotiza, float valor){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/8f0f3d511aad98ca12e61d36/pair/"
                + base
                + "/"
                + cotiza
                + "/"
                + valor);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisa.class);

        } catch (Exception e) {
            throw new RuntimeException("No se encuentra la divisa.");

        }
    }
}