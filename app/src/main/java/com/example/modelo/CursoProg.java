package com.example.modelo;

public class CursoProg {
    private int codcurp;
    private String codmat;
    private Profesor codprof;
    private Cursos codcur;

    public CursoProg() {}

    public CursoProg(int codcurp, String codmat, Profesor codprof, Cursos codcur) {
        this.codcurp = codcurp;
        this.codmat = codmat;
        this.codprof = codprof;
        this.codcur = codcur;
    }

    public int getCodcurp() {
        return codcurp;
    }

    public void setCodcurp(int codcurp) {
        this.codcurp = codcurp;
    }

    public String getCodmat() {
        return codmat;
    }

    public void setCodmat(String codmat) {
        this.codmat = codmat;
    }

    public Profesor getCodprof() {
        return codprof;
    }

    public void setCodprof(Profesor codprof) {
        this.codprof = codprof;
    }

    public Cursos getCodcur() {
        return codcur;
    }

    public void setCodcur(Cursos codcur) {
        this.codcur = codcur;
    }
}
