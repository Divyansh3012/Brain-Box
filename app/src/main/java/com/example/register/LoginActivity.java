package com.example.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    private EditText loginemail,loginpass;

    FirebaseFirestore firebase;
    private Button loginbtn, signbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginemail = findViewById(R.id.loginemail);
        loginpass = findViewById(R.id.loginpwd);
        loginbtn = findViewById(R.id.loginbtn);
        signbtn = findViewById(R.id.registerbtn);
        firebase = FirebaseFirestore.getInstance();

        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegiterActivity.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUserAccout();
            }

            private void loginUserAccout() {

                String email, password;

                email = loginemail.getText().toString();
                password = loginpass.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter valid email",Toast.LENGTH_LONG).show();
                    return;
                }
                if (password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter valid password",Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    check(email,password);
                }
            }

            private void check(String email, String password) {
                firebase.collection("DATA").document(email).get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot == null
//                                        || documentSnapshot.get("user") == null
                                        || documentSnapshot.get("name") == null
                                        || documentSnapshot.get("password") == null) {
                                    Toast.makeText(LoginActivity.this, "Not Register", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    String emailid = (String)documentSnapshot.get("email");
                                    String password_data = (String) documentSnapshot.get("password");

                                    if (email.equals(emailid) && password.equals(password_data)){
                                       Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                                       startActivity(intent);
                                    }else{
                                        Toast.makeText(LoginActivity.this, "Login Failure!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
            }
        });

    }
}