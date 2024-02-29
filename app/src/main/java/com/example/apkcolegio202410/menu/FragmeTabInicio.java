package com.example.apkcolegio202410.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.apkcolegio202410.R;
import com.example.controlador.DCursos;
import com.example.modelo.Cursos;
import com.example.util.ADPCursos;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmeTabInicio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmeTabInicio extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmeTabInicio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmeTabInicio.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmeTabInicio newInstance(String param1, String param2) {
        FragmeTabInicio fragment = new FragmeTabInicio();
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
        View root=inflater.inflate(R.layout.fragment_fragme_tab_inicio, container, false);

        GridView DataGrid=(GridView) root.findViewById(R.id.FrmTabInicio_DataGrid);

        DCursos cur=new DCursos(root.getContext());
        try {
            cur.DataList=DataGrid;
            cur.getList("");
        } catch (Exception e) {throw new RuntimeException(e);}
        return root;
    }
}