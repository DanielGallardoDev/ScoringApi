package com.Scoring.ScoringApi.controllers;

import com.Scoring.ScoringApi.exceptions.PersonaNotFoundException;
import com.Scoring.ScoringApi.exceptions.ProfesionNotFoundException;
import com.Scoring.ScoringApi.services.RentaService;
import com.Scoring.ScoringApi.model.Renta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentaController {

    RentaService rentaService;

    public RentaController(RentaService rentaService) {
        this.rentaService = rentaService;
    }

    @PostMapping("/renta")
    ResponseEntity addRenta(@RequestBody Renta renta){
        try {
            this.rentaService.addRenta(renta);
        } catch (ProfesionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Profesion no encontrada en la base de datos");
        } catch (PersonaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Persona no encontrada en la base de datos");
        }
        return ResponseEntity.ok(renta);
    }
}
