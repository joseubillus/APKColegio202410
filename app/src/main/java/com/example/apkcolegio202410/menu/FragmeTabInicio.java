package com.example.apkcolegio202410.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.apkcolegio202410.MnMenu;
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

    private GridView DataGrid;
    private DCursos cur;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_fragme_tab_inicio, container, false);

        DataGrid=(GridView) root.findViewById(R.id.FrmTabInicio_DataGrid);
        SearchView schbus=(SearchView) root.findViewById(R.id.FrmTabInicio_Schbus);

        try {
            cur=new DCursos(root.getContext());
            cur.DataList=DataGrid;
            cur.getList("");
        } catch (Exception e) {throw new RuntimeException(e);}

        schbus.setOnQueryTextListener(getBus(root));

        DataGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int codcurp=cur.getItem(position).getCodcurp();
                Toast.makeText(root.getContext(),"Codigo"+codcurp,Toast.LENGTH_SHORT).show();

                Bundle bundle=new Bundle();
                bundle.putString("codcurp",""+codcurp);
                getFragmentManager().setFragmentResult("key",bundle);

                //FragmeTabAsistencia.newInstance(cod,nom);
                MnMenu.getFrame(1);

            }
        });

        return root;
    }


    public SearchView.OnQueryTextListener getBus(View root) {
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {return false;}
            @Override
            public boolean onQueryTextChange(String txtbus) {
                try {
                    DCursos cur=new DCursos(root.getContext());
                    cur.DataList=DataGrid;
                    cur.getList(txtbus);
                } catch (Exception e) {throw new RuntimeException(e);}
                return false;
            }
        };
    }
}