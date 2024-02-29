package com.example.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apkcolegio202410.R;
import com.example.modelo.Cursos;

import java.util.ArrayList;
import java.util.List;

public class ADPCursos extends BaseAdapter{
    private List<Cursos> db=new ArrayList<>();
    private Context ct;

    public ADPCursos(Context ct) {
        this.ct = ct;
    }
    public ADPCursos(Context ct,List<Cursos> db) {
        this.db = db;
        this.ct = ct;
    }

    public void getAdd(Cursos obj){
        db.add(obj);
    }

    @Override
    public int getCount() {
        return db.size();
    }

    @Override
    public Cursos getItem(int position) {
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
            root = inf.inflate(R.layout.conf_lcursos,parent,false);
        }

        TextView txtcod=(TextView) root.findViewById(R.id.FrmConfCur_Lblcod);
        TextView txtnom=(TextView) root.findViewById(R.id.FrmConfCur_Lblnom);
        ImageView img=(ImageView) root.findViewById(R.id.FrmConfCur_Img);

        Cursos cur=getItem(position);
        txtcod.setText(cur.getCodcur());
        txtnom.setText(cur.getNomcur());
        return root;
    }
}
