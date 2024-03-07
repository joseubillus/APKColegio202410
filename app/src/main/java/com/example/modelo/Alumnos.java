package com.example.modelo;

public class Alumnos {
    private int idalu;
    private String nomalu;
    private String apealu;
    private String fotoalu;

    public Alumnos() {}

    public Alumnos(int idalu, String nomalu, String apealu, String fotoalu) {
        this.idalu = idalu;
        this.nomalu = nomalu;
        this.apealu = apealu;
        this.fotoalu = fotoalu;
    }

    public int getIdalu() {
        return idalu;
    }

    public void setIdalu(int idalu) {
        this.idalu = idalu;
    }

    public String getNomalu() {
        return nomalu;
    }

    public void setNomalu(String nomalu) {
        this.nomalu = nomalu;
    }

    public String getApealu() {
        return apealu;
    }

    public void setApealu(String apealu) {
        this.apealu = apealu;
    }

    public String getFotoalu() {
        return fotoalu;
    }

    public void setFotoalu(String fotoalu) {
        this.fotoalu = fotoalu;
    }
}
