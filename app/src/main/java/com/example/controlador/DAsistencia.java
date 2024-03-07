package com.example.controlador;

import android.content.Context;
import android.content.Intent;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.modelo.Alumnos;
import com.example.modelo.Asistencia;
import com.example.modelo.Cursos;
import com.example.modelo.Login;
import com.example.util.ADPAsistencia;
import com.example.util.ADPCursos;
import com.example.util.Mensaje;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class DAsistencia implements IDao <Login>{
    private AsyncHttpClient async=new AsyncHttpClient();
    private String url=Conexion.getUrl("SAsistencia.php");
    private static List<Asistencia> array=new ArrayList<>();
    private Mensaje ms=null;
    private Context ct;
    public ListView DataList;
    public DAsistencia(Context c){
        this.ct = c;
        this.ms =new Mensaje(ct);
    }

    @Override
    public void getList(Object bus) throws Exception {
        RequestParams params=new RequestParams();
        params.add("frm","list");
        params.add("codcurp","1");
        params.add("fecha",bus.toString());
        async.get(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                ms.MProgressBarDato();
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String resp=new String(responseBody);
                getJSON(resp);
                DataList.setAdapter(new ADPAsistencia(ct,array));
                ms.MCloseProgBar(true);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ms.MCloseProgBar(true);
                getToast("Error 404:"+error.getMessage());
            }
        });

    }

    public void getToast(String men){
        Toast.makeText(ct,men,Toast.LENGTH_SHORT).show();
    }

    public void getJSON(String resp){
        try {
            array.clear();
            JSONArray json=new JSONArray(resp);
            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonArray=json.getJSONObject(i).getJSONObject("alumno");
                int cod=new Integer(jsonArray.getString("idalum"));
                String nom=jsonArray.getString("nomalum");
                String ape=jsonArray.getString("apealum");
                String foto=jsonArray.getString("fotoalum");
                array.add(new Asistencia(null,0,new Alumnos(cod,nom,ape,foto),null,null));
            }
        } catch (JSONException e)
        {getToast("Error JSON:"+e.getMessage());}
    }

    @Override
    public void getAdd(Login obj) throws Exception {

    }

    @Override
    public void getUp(Login obj) throws Exception {

    }

    @Override
    public void getDel(Object cod) throws Exception {

    }

    @Override
    public Login getItem(int f) {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
