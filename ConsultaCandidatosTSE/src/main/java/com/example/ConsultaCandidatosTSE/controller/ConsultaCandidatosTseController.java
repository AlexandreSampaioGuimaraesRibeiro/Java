package com.example.ConsultaCandidatosTSE.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ConsultaCandidatosTSE.model.Model;

@Controller
public class ConsultaCandidatosTseController {
    private final com.example.ConsultaCandidatosTSE.service.CandidatoTSEService candidatoTSE;

    public ConsultaCandidatosTseController(com.example.ConsultaCandidatosTSE.service.CandidatoTSEService candidatoTSE){
        this.candidatoTSE = candidatoTSE;
    }

    @GetMapping("/")
    public  String index(
        @RequestParam(required = false) String cargo,
        @RequestParam(required = false) String partido,
        @RequestParam(required = false) String texto,
        Model model){
        return candidatoTSE.filtrar(cargo,partido,texto,model); 

    }
}
