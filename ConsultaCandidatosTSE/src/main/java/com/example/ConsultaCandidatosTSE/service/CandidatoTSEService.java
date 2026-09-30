package com.example.ConsultaCandidatosTSE.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CandidatoTSEService {

    public CandidatoTSEService(String cargo, String partido,String texto,com.example.ConsultaCandidatosTSE.model.Model model){

    }

    private static final String BASE_URL = "http://localhost:8080/ConsultaDecandidatoTSI";

    private String consultarURL(String apiUrl){
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
            return responseEntity.getBody();
        } catch (Exception e) {
            return "Erro na requisição: " + e.getMessage();
        }
    }

    public String filtrar(String cargo,String partido,String texto,com.example.ConsultaCandidatosTSE.model.Model model) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL)
                .queryParam("cargo", cargo)
                .queryParam("partido", partido);

        if (texto != null && !texto.isEmpty()) {
            builder.queryParam("texto", texto);
        }

        return consultarURL(builder.toUriString());
        
    }
}
