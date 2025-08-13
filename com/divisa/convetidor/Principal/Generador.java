package com.divisa.convetidor.Principal;

import com.divisa.convetidor.api.Divisa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Generador {
    public void guardar(Divisa divisa) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter escritura = new FileWriter(divisa + ".json");
        escritura.write(gson.toJson(divisa));
        escritura.close();
    }
}
