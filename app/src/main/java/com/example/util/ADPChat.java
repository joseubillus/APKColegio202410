package com.example.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apkcolegio202410.R;
import com.example.modelo.Chat;

import java.util.ArrayList;
import java.util.List;

public class ADPChat extends BaseAdapter{
    private List<Chat> db=new ArrayList<>();
    private Context ct;

    public ADPChat(Context ct) {
        this.ct = ct;
    }
    public ADPChat(Context ct, List<Chat> db) {
        this.db = db;
        this.ct = ct;
    }

    public void getAdd(Chat obj){
        db.add(obj);
    }

    @Override
    public int getCount() {
        return db.size();
    }

    @Override
    public Chat getItem(int position) {
        return db.get(position);
    }

    @Override
    public long getItemId(int position) {
        return db.get(position).hashCode();
    }

    public void Clear(){db.clear();}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root=convertView;
        if(root==null) {
            LayoutInflater inf = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            root = inf.inflate(R.layout.conf_lchat,parent,false);
        }

        TextView txtnom=(TextView) root.findViewById(R.id.FrmConfChat_Lblnom);
        TextView txtmen=(TextView) root.findViewById(R.id.FrmConfChat_Lblmen);

        Chat cur=getItem(position);
        txtnom.setText(cur.getNom());
        txtmen.setText(cur.getMens());
        return root;
    }
}
