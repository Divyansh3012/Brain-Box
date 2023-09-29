package com.example.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Documents extends AppCompatActivity {

    CardView javaPdf, androidPdf, htmlPdf, cssPdf, dartPdf, jsPdf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.docs);

        javaPdf = findViewById(R.id.javaMaterials);
        androidPdf = findViewById(R.id.androidMaterials);
        htmlPdf = findViewById(R.id.htmlMaterials);
        cssPdf = findViewById(R.id.cssMaterials);
        dartPdf = findViewById(R.id.flutterMaterials);
        jsPdf = findViewById(R.id.jsMaterials);

        javaPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,javaPdf.class);
//                intent.putExtra("pdf_url","https://demo.codeeasy.com/downloads/CodeEasy.pdf");
//                startActivity(intent);
            }
        });

        androidPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Documents.this,androidPdf.class);
                startActivity(intent);
            }
        });

        htmlPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Documents.this,htmlPdf.class);
                startActivity(intent);
            }
        });

        cssPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Documents.this,cssPdf.class);
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
                Intent intent = new Intent(Documents.this,jsPdf.class);
                startActivity(intent);
            }
        });
    }
}
