package com.example.aplicacioninmuebles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class NewPage extends AppCompatActivity {

    Button btOne,btTwo,btThree, btAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);

        btOne = findViewById(R.id.btOne);
        btTwo = findViewById(R.id.btnTwo);
        btThree = findViewById(R.id.btnThree);
        btAtras = findViewById(R.id.btnAtras);

        btOne.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent( NewPage.this,NewPage2.class);
                startActivity(i);
            }
        });

        btTwo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent( NewPage.this,NewPage.class);
                startActivity(i);
            }
        });

        btThree.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent( NewPage.this,NewPage.class);
                startActivity(i);
            }
        });

        btAtras.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent( NewPage.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}