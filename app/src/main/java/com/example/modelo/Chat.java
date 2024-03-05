package com.example.modelo;

public class Chat {
    private String Nom;
    private String Mens;

    public Chat() {}

    public Chat(String nom, String mens) {
        Nom = nom;
        Mens = mens;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getMens() {
        return Mens;
    }

    public void setMens(String mens) {
        Mens = mens;
    }
}
