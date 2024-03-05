package com.example.apkcolegio202410.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.apkcolegio202410.R;
import com.example.modelo.Chat;
import com.example.util.ADPChat;
import com.example.util.Mensaje;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmeTabUsuario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmeTabUsuario extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FirebaseDatabase database=null;
    private DatabaseReference myref=null;
    private ADPChat adp;
    ListView lstdata;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmeTabUsuario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmeTabUsuario.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmeTabUsuario newInstance(String param1, String param2) {
        FragmeTabUsuario fragment = new FragmeTabUsuario();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_fragme_tab_usuario, container, false);

        lstdata=(ListView) root.findViewById(R.id.FrmTabUsu_LstData);
        adp=new ADPChat(root.getContext());

        EditText txtmen=(EditText) root.findViewById(R.id.FrmTabUsu_txtmen);
        Button btn=(Button) root.findViewById(R.id.FrmTabUsu_btnenv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom="jose";
                String men=txtmen.getText().toString();
                myref.push().setValue(new Chat(nom,men));
                txtmen.setText("");
            }
        });

        database = FirebaseDatabase.getInstance();
        myref = database.getReference("Mensaje");
        myref.addValueEventListener(getDataTime(root));

        return root;
    }

    public ValueEventListener getDataTime(View root){
        return new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adp.Clear();
                for (DataSnapshot post: snapshot.getChildren()) {
                    Chat obj=post.getValue(Chat.class);
                    adp.getAdd(new Chat(obj.getNom(),obj.getMens()));
                }
                lstdata.setAdapter(adp);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        };
    }
}