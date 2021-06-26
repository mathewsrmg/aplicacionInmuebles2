package com.example.aplicacioninmuebles;

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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class NewPage2 extends AppCompatActivity {
    //mis atributos mis niños
    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();
    EditText etId,etDueno,etPersonas,etValor;
    Button btAtras, btEnviar;
    Map<String, Object> Casa = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page2);

        etId=findViewById(R.id.IdId);
        etDueno=findViewById(R.id.etDueno);
        etPersonas=findViewById(R.id.etPersonas);
        etValor=findViewById(R.id.etValor);
        btEnviar=findViewById(R.id.btnEnviar);
        btAtras = findViewById(R.id.btnAtras);
        //boton para enviar los datos
        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.Captura de valoras cuando se de click
                String id=etId.getText().toString();
                String dueno=etDueno.getText().toString();
                String persona=etPersonas.getText().toString();
                String valor=etValor.getText().toString();
                //2.LLenar el objeto a enviar a BD
                Casa.put("id",id);
                Casa.put("dueno",dueno);
                Casa.put("persona",persona);
                Casa.put("valor",valor);
                //3.llamar a la funcion registrar para llevar
                registrarCasa();
            }
        });
        //boton para pantalla anterior
        btAtras.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent( NewPage2.this,NewPage.class);
                startActivity(i);
            }
        });
    }
    public void registrarCasa(){
        baseDatos.collection("casas")
                .add(Casa)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(NewPage2.this, "Exito en el registro", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NewPage2.this, "Error "+e, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}