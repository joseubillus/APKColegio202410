package com.example.apkcolegio202410;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.controlador.DLogin;

public class MnLogin extends AppCompatActivity {
    private EditText txtusu,txtpas;
    private DLogin dlog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_login);

        txtusu = (EditText) findViewById(R.id.FrmLog_txtusu);
        txtpas = (EditText) findViewById(R.id.FrmLog_txtpas);
        dlog=new DLogin(MnLogin.this);
    }

    public void OnClick_BtnAcep(View v){
        try {
            String usu=txtusu.getText().toString();
            String pas=txtpas.getText().toString();
            dlog.getVal(usu,pas);
        } catch (Exception e)
        {throw new RuntimeException(e);}
    }
}