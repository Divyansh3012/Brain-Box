package com.example.register.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.register.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProofileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProofileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private FirebaseAuth fauth;
//    private FirebaseFirestore fstore;

    EditText ShowProfileName, ShowEmail;

    View view;
    private String userID;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProofileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProofileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProofileFragment newInstance(String param1, String param2) {
        ProofileFragment fragment = new ProofileFragment();
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

//            ShowProfileName = view.findViewById(R.id.profilename);
//            ShowEmail = view.findViewById(R.id.showemail);
/*
            fauth = FirebaseAuth.getInstance();
            fstore = FirebaseFirestore.getInstance();

            userID = fauth.getCurrentUser().getEmail();

            DocumentReference documentReference = fstore.collection("DATA").document(userID);

            documentReference.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                    ShowProfileName.setText(value.getString("name"));
                    ShowEmail.setText(value.getString("email"));
                }
            });*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_proofile, container, false);
    }
}