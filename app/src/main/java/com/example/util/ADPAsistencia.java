package com.example.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apkcolegio202410.R;
import com.example.modelo.Asistencia;
import com.example.modelo.Cursos;

import java.util.ArrayList;
import java.util.List;

public class ADPAsistencia extends BaseAdapter{
    private List<Asistencia> db=new ArrayList<>();
    private Context ct;

    public ADPAsistencia(Context ct) {
        this.ct = ct;
    }
    public ADPAsistencia(Context ct, List<Asistencia> db) {
        this.db = db;
        this.ct = ct;
    }

    public void getAdd(Asistencia obj){
        db.add(obj);
    }

    @Override
    public int getCount() {
        return db.size();
    }

    @Override
    public Asistencia getItem(int position) {
        return db.get(position);
    }

    @Override
    public long getItemId(int position) {
        return db.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root=convertView;
        if(root==null) {
            LayoutInflater inf = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            root = inf.inflate(R.layout.conf_lasistencia,parent,false);
        }

        TextView txtcod=(TextView) root.findViewById(R.id.FrmConfAsis_Lblcod);
        TextView txtnom=(TextView) root.findViewById(R.id.FrmConfAsis_Lblnom);
        ImageView img=(ImageView) root.findViewById(R.id.FrmConfAsis_Img);

        Asistencia asis=getItem(position);
        txtcod.setText(""+asis.getAlum().getIdalu());
        txtnom.setText(""+asis.getAlum().getNomalu());
        return root;
    }
}
