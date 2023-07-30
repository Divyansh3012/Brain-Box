package com.example.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegiterActivity extends AppCompatActivity {

    private EditText emailedt, passwordedt, nameedt;

    private Button register;

    FirebaseFirestore db;

    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailedt = findViewById(R.id.regemail);
        passwordedt = findViewById(R.id.regpwd);
//        nameedt = findViewById(R.id.regsname);
        register = findViewById(R.id.regbtn);

        db = FirebaseFirestore.getInstance();

        fauth = FirebaseAuth.getInstance();

        String user = fauth.getCurrentUser().getUid();
        Log.d("TAG1010", "onCreate: " + user);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registerNewUser();

                   /* Map<String, Object> user = new HashMap<>();
                    user.put("name", name);
                    user.put("email", email);
                    user.put("password", password);*/
//                    data user = new data(email, name, password);
//                    db.collection("DATA").document(email).get()
//                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                    if (documentSnapshot == null
//                                            || documentSnapshot.get("name") == null
//                                            || documentSnapshot.get("email") == null
//                                            || documentSnapshot.get("password") == null) {
//                                        db.collection("DATA").document(email).set(user)
//                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                                    @Override
//                                                    public void onSuccess(Void unused) {
//                                                        Intent i = new Intent(RegiterActivity.this, MainActivity.class);
//                                                        startActivity(i);
//                                                        Toast.makeText(RegiterActivity.this, "success", Toast.LENGTH_SHORT);
//                                                    }
//                                                }).addOnFailureListener(new OnFailureListener() {
//                                                    @Override
//                                                    public void onFailure(@NonNull Exception e) {
//                                                        Toast.makeText(RegiterActivity.this, "failure", Toast.LENGTH_SHORT);
//                                                    }
//                                                });
//                                    }
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//
//                                }
//                            });
            }

            private void registerNewUser() {

                String email, password;

                email = emailedt.getText().toString();
                password = passwordedt.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Please enter valid email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Please enter valid password", Toast.LENGTH_SHORT).show();
                    return;
                }
                fauth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    String authe = fauth.getCurrentUser().getUid();
                                    Toast.makeText(getApplicationContext(), "Registration Success!!"+authe, Toast.LENGTH_SHORT).show();
                                    DocumentReference documentReference = db.collection("DATA").document(email);
                                    Map<String, Object> user = new HashMap<>();
//                                    user.put("name", name);
                                    user.put("email", email);
                                    user.put("password", password);
                                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Log.d("TAG100","Success db");
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.d("TAG100","Fail db" + e);

                                        }
                                    });

                                    Intent intent = new Intent(RegiterActivity.this, MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Registration Failed!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}