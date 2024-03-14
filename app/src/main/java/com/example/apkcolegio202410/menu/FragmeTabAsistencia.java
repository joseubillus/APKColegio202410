package com.example.apkcolegio202410.menu;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.apkcolegio202410.R;
import com.example.controlador.DAsistencia;
import com.example.modelo.Alumnos;
import com.example.modelo.Asistencia;
import com.example.util.ADPAsistencia;
import com.example.util.Mensaje;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmeTabAsistencia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmeTabAsistencia extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DAsistencia dasis;

    public FragmeTabAsistencia() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmeTabAsistencia.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmeTabAsistencia newInstance(String param1, String param2) {
        FragmeTabAsistencia fragment = new FragmeTabAsistencia();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
        getFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result)
            {       try {
                        mParam1=result.getString("codcurp");
                        getMen(getView(),"Datos"+mParam1);

                        dasis.getList(""+mParam1);

                    } catch (Exception e)
                    {getMen(getView(),"Error Exp:"+e.getMessage());}
                }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_fragme_tab_asistencia, container, false);

        ListView lstdata=(ListView) root.findViewById(R.id.FrmTabAsis_LstData);
        ADPAsistencia adp=new ADPAsistencia(root.getContext());

        dasis=new DAsistencia(root.getContext());
        dasis.DataList=lstdata;

        return root;
    }

    public void getMen(View v, String men){
        new Mensaje(v.getContext()).getMensaje(men).show();
    }
}