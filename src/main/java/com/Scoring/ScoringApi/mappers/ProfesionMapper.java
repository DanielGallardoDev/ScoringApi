package com.Scoring.ScoringApi.mappers;

import com.Scoring.ScoringApi.model.Direccion;
import com.Scoring.ScoringApi.model.Profesion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProfesionMapper {
    @Insert("INSERT INTO PROFESION (DESCRIPCION) VALUES (#{descripcion}) ")
    @Options(useGeneratedKeys = true, keyProperty = "profesionId", keyColumn = "PROFESION_ID")
    void insertProfesion(Profesion profesion);
}