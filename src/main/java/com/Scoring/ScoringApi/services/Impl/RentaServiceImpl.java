package com.Scoring.ScoringApi.services.Impl;

import com.Scoring.ScoringApi.exceptions.PersonaNotFoundException;
import com.Scoring.ScoringApi.exceptions.ProfesionNotFoundException;
import com.Scoring.ScoringApi.model.Renta;
import com.Scoring.ScoringApi.mappers.PersonaMapper;
import com.Scoring.ScoringApi.mappers.ProfesionMapper;
import com.Scoring.ScoringApi.mappers.RentaMapper;
import com.Scoring.ScoringApi.services.RentaService;
import org.springframework.stereotype.Service;

@Service
public class RentaServiceImpl implements RentaService {

    RentaMapper rentaMapper;
    ProfesionMapper profesionMapper;
    PersonaMapper personaMapper;

    public RentaServiceImpl(RentaMapper rentaMapper, ProfesionMapper profesionMapper, PersonaMapper personaMapper) {
        this.rentaMapper = rentaMapper;
        this.profesionMapper = profesionMapper;
        this.personaMapper = personaMapper;
    }

    @Override
    public Renta addRenta(Renta renta) throws ProfesionNotFoundException, PersonaNotFoundException {
        renta = this.addRentaProfesion(renta);
        this.rentaMapper.insertRenta(renta);
        return renta;
    }

    public Renta addRentaProfesion(Renta renta){
        this.profesionMapper.insertProfesion(renta.getProfesion());
        return renta;
    }


}
