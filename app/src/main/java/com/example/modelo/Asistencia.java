package com.example.modelo;

public class Asistencia {
    private Cursos cur;
    private int codgrup;
    private Alumnos alum;
    private String fecasis;
    private String estasis;

    public Asistencia() {}

    public Asistencia(Cursos cur, int codgrup, Alumnos alum, String fecasis, String estasis) {
        this.cur = cur;
        this.codgrup = codgrup;
        this.alum = alum;
        this.fecasis = fecasis;
        this.estasis = estasis;
    }

    public Cursos getCur() {
        return cur;
    }

    public void setCur(Cursos cur) {
        this.cur = cur;
    }

    public int getCodgrup() {
        return codgrup;
    }

    public void setCodgrup(int codgrup) {
        this.codgrup = codgrup;
    }

    public Alumnos getAlum() {
        return alum;
    }

    public void setAlum(Alumnos alum) {
        this.alum = alum;
    }

    public String getFecasis() {
        return fecasis;
    }

    public void setFecasis(String fecasis) {
        this.fecasis = fecasis;
    }

    public String getEstasis() {
        return estasis;
    }

    public void setEstasis(String estasis) {
        this.estasis = estasis;
    }
}
