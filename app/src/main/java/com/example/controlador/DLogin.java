package com.example.controlador;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.apkcolegio202410.MnMenu;
import com.example.modelo.Login;
import com.example.util.Mensaje;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class DLogin implements IDao <Login>{
    private AsyncHttpClient async=new AsyncHttpClient();
    private String url="http://192.168.0.28:8070/PHPColegio/Servicio/SLogin.php";
    private Mensaje ms=null;
    private Context ct;
    public DLogin(Context c){
        this.ct = c;
        this.ms =new Mensaje(ct);
    }

    public void getVal(String dni,String pas)throws Exception{
        RequestParams params=new RequestParams();
        params.add("frm","val2");
        params.add("txtdni",dni);
        params.add("txtpas",pas);
        params.add("txttipo","PRO");
        async.get(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                ms.MProgressBarDato();
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String resp=new String(responseBody);
                try {
                    JSONObject json = new JSONObject(resp);
                    String dato=json.getString("Success");
                    String cod=json.getJSONObject("login").getString("cod");
                    if(dato.equals("A"))
                        ct.startActivity(new Intent(ct, MnMenu.class));
                    else getToast("Error:"+cod);
                } catch (JSONException e)
                {getToast("Error JSON:"+e.getMessage());}
                finally {ms.MCloseProgBar(true);}
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
            JSONArray json=new JSONArray(resp);
            for (int i = 0; i < json.length(); i++) {
                json.getJSONObject(i).getString("Success");
            }
        } catch (JSONException e)
        {getToast("Error JSON:"+e.getMessage());}
    }

    @Override
    public void getList(Object bus) throws Exception {

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
