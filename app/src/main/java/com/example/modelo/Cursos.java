package com.example.modelo;

public class Cursos {
    private String codcur;
    private String nomcur;
    private String imgcur;

    public Cursos() {
    }

    public Cursos(String codcur, String nomcur, String imgcur) {
        this.codcur = codcur;
        this.nomcur = nomcur;
        this.imgcur = imgcur;
    }

    public String getCodcur() {
        return codcur;
    }

    public void setCodcur(String codcur) {
        this.codcur = codcur;
    }

    public String getNomcur() {
        return nomcur;
    }

    public void setNomcur(String nomcur) {
        this.nomcur = nomcur;
    }

    public String getImgcur() {
        return imgcur;
    }

    public void setImgcur(String imgcur) {
        this.imgcur = imgcur;
    }
}
