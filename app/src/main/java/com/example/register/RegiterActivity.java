package com.example.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegiterActivity extends AppCompatActivity {

    private EditText emailedt, passwordedt, nameedt;
    private Button register;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailedt = findViewById(R.id.regemail);
        passwordedt = findViewById(R.id.regpwd);
        nameedt = findViewById(R.id.regsname);
        register = findViewById(R.id.regbtn);

        db = FirebaseFirestore.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailedt.getText().toString();
                String password = passwordedt.getText().toString();
                String name = nameedt.getText().toString();

                if(email.isEmpty() || password.isEmpty() || name.isEmpty()){
                    Toast.makeText(RegiterActivity.this, "Pls All fille ", Toast.LENGTH_SHORT).show();
                }else {
                    Map<String, Object> user = new HashMap<>();
                    user.put("name", name);
                    user.put("email", email);
                    user.put("password", password);
                    db.collection("DATA").document(email).get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    if (documentSnapshot == null
                                    || documentSnapshot.get("name") == null
                                    || documentSnapshot.get("email") == null
                                    || documentSnapshot.get("password") == null){
                                        db.collection("DATA").document(email).set(user)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {
                                                        Toast.makeText(RegiterActivity.this,"success",Toast.LENGTH_SHORT);
                                                    }
                                                }).addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toast.makeText(RegiterActivity.this,"failure",Toast.LENGTH_SHORT);
                                                    }
                                                });
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });
                }


            }
        });

    }
}