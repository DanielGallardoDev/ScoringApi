package com.Scoring.ScoringApi.services;

import com.Scoring.ScoringApi.exceptions.RequiredMisssingFieldException;
import com.Scoring.ScoringApi.exceptions.WrongLengthFieldException;
import com.Scoring.ScoringApi.model.Persona;

public interface PersonaService {
    Persona addPersona(Persona persona) throws RequiredMisssingFieldException, WrongLengthFieldException;
    Persona addPersonaDireccion(Persona persona);
}
