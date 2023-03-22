package com.Scoring.ScoringApi.services;

import  com.Scoring.ScoringApi.exceptions.PersonaNotFoundException;
import  com.Scoring.ScoringApi.exceptions.ProfesionNotFoundException;
import  com.Scoring.ScoringApi.model.Renta;

public interface RentaService {
    Renta addRenta(Renta renta) throws ProfesionNotFoundException, PersonaNotFoundException;
}
