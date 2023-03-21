package com.Scoring.ScoringApi.services.Impl;

import com.Scoring.ScoringApi.exceptions.RequestApiValidationException;
import com.Scoring.ScoringApi.exceptions.RequiredMisssingFieldException;
import com.Scoring.ScoringApi.exceptions.WrongLengthFieldException;
import com.Scoring.ScoringApi.mappers.DireccionMapper;
import com.Scoring.ScoringApi.mappers.PersonaMapper;
import com.Scoring.ScoringApi.model.Persona;
import com.Scoring.ScoringApi.services.PersonaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService {

    private PersonaMapper personaMapper;
    private DireccionMapper direccionMapper;

    public PersonaServiceImpl(PersonaMapper personaMapper, DireccionMapper direccionMapper) {
        this.personaMapper = personaMapper;
        this.direccionMapper = direccionMapper;

    }


    @Override
    @Transactional //Si algo falla en medio del proceso no inserta nada
    public Persona addPersona(Persona persona) throws RequiredMisssingFieldException, WrongLengthFieldException {

        this.validatePersonaData(persona);

        persona = this.addPersonaDireccion(persona);
        this.personaMapper.insertPersona(persona);

        return persona;
    }

    @Override
    public Persona addPersonaDireccion(Persona persona) {
        this.direccionMapper.insertDireccion(persona.getDireccionDomicilio());

        if(persona.isDireccionDomicilioSameAsNotificacion()){
            persona.setDireccionNotificacion(persona.getDireccionDomicilio());
        } else{
            this.direccionMapper.insertDireccion(persona.getDireccionNotificacion());
        }

        return persona;
    }

    private void validatePersonaData(Persona persona) throws RequiredMisssingFieldException, WrongLengthFieldException {
        this.validateNombre(persona);
    }

    private void validateNombre(Persona persona) throws RequiredMisssingFieldException, WrongLengthFieldException {
        if(persona.getNombre() == null || persona.getNombre().isEmpty()){
            throw new RequiredMisssingFieldException();
        }
        if(persona.getNombre().length()>50){
            throw new WrongLengthFieldException();
        }
    }
}
