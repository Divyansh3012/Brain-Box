package com.example.register.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.register.Documents;
import com.example.register.R;
import com.example.register.androidPdf;
import com.example.register.cssPdf;
import com.example.register.htmlPdf;
import com.example.register.jsPdf;
import com.google.android.material.card.MaterialCardView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BoookMarkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BoookMarkFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;

    MaterialCardView javaPdf, androidPdf, htmlPdf, cssPdf, dartPdf, jsPdf;

    public BoookMarkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BoookMarkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BoookMarkFragment newInstance(String param1, String param2) {
        BoookMarkFragment fragment = new BoookMarkFragment();
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
        view = inflater.inflate(R.layout.fragment_boook_mark, container, false);

        // Inflate the layout for this fragment
        javaPdf = view.findViewById(R.id.javaMaterials);
        androidPdf = view.findViewById(R.id.androidMaterials);
        htmlPdf = view.findViewById(R.id.htmlMaterials);
        cssPdf = view.findViewById(R.id.cssMaterials);
        dartPdf = view.findViewById(R.id.flutterMaterials);
        jsPdf = view.findViewById(R.id.jsMaterials);

        androidPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), com.example.register.androidPdf.class);
                startActivity(intent);
            }
        });

        htmlPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), com.example.register.htmlPdf.class);
                startActivity(intent);
            }
        });

        cssPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), com.example.register.cssPdf.class);
                startActivity(intent);
            }
        });

//        dartPdf.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Documents.this,dartPdf.class);
//                startActivity(intent);
//            }
//        });

        jsPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), com.example.register.jsPdf.class);
                startActivity(intent);
            }
        });
        return inflater.inflate(R.layout.fragment_boook_mark, container, false);
    }
}
