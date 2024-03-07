package com.example.controlador;

import android.content.Context;
import android.content.Intent;
import android.widget.GridView;
import android.widget.Toast;

import com.example.apkcolegio202410.MnMenu;
import com.example.modelo.Cursos;
import com.example.modelo.Login;
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

public class DCursos implements IDao <Login>{
    private AsyncHttpClient async=new AsyncHttpClient();
    private String url=Conexion.getUrl("SCurPro.php");
    private static List<Cursos> array=new ArrayList<>();
    private Mensaje ms=null;
    private Context ct;
    public GridView DataList;
    public DCursos(Context c){
        this.ct = c;
        this.ms =new Mensaje(ct);
    }

    @Override
    public void getList(Object bus) throws Exception {
        RequestParams params=new RequestParams();
        params.add("frm","list2");
        params.add("txtbus",bus.toString());
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
                DataList.setAdapter(new ADPCursos(ct,array));
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
                JSONObject jsonArray=json.getJSONObject(i).getJSONObject("curso");
                String cod=jsonArray.getString("codcur");
                String nom=jsonArray.getString("nomcur");
                array.add(new Cursos(cod,nom,null));
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
