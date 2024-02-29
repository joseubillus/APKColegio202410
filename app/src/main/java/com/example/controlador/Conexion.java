package com.example.controlador;

public class Conexion {

    private static String con="http:";
    private static String ip="192.168.10.51:8070";
    private static String domin="PHPColegio";
    private static String serv="Servicio";

    public static String getUrl(String metodo){
        return con+"//"+ip+"/"+domin+"/"+serv+"/"+metodo;
    }
}
