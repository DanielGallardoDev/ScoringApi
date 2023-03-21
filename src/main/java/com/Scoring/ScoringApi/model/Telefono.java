package com.Scoring.ScoringApi.model;

public class Telefono {
    private int telefonoID;
    private int personaId;
    private String telefono;

    public Telefono(int telefonoID, int personaId, String telefono) {
        this.telefonoID = telefonoID;
        this.personaId = personaId;
        this.telefono = telefono;
    }

    public int getTelefonoID() {
        return telefonoID;
    }

    public void setTelefonoID(int telefonoID) {
        this.telefonoID = telefonoID;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
