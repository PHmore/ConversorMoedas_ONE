package br.com.conversor.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConverteDados {
    private Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) // Ajustando para snake_case
            //.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            // Para criar o JSON de uma forma mais bonita e legível
            .setPrettyPrinting()
            .create();

    public <T> T converterDados (String json, Class<T> classe){
        try{
            return gson.fromJson(json, classe);
        } catch (Exception e){
            System.out.println("Ocorreu um Erro: " + e.getMessage());
            return null;
        }
    }
}
