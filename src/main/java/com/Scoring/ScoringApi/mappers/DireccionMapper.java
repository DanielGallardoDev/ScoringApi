package com.Scoring.ScoringApi.mappers;

import com.Scoring.ScoringApi.model.Direccion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface DireccionMapper {

    @Insert("INSERT INTO DIRECCION (TIPO_VIA_ID, NOMBRE_CALLE, NUM, PISO, PUERTA, ESCALERA, OTRO_DATO, COD_POSTAL, MUNICIPIO, COD_PROVINCIA) VALUES (#{tipoViaId}, #{nombreCalle}, #{num}, #{piso, jdbcType=CHAR}, null, null, null, #{codigoPostal}, #{municipio}, #{codigoProvincia})")
    @Options(useGeneratedKeys = true, keyProperty = "direccionId", keyColumn="DIRECCION_ID")
    void insertDireccion(Direccion direccion);
}
