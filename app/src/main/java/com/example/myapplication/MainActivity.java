package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.activities.CadastroActivy;
import com.example.myapplication.activities.EscolhaActivity;
import com.example.myapplication.activities.ProdutosDisponiveisActivy;

public class MainActivity extends AppCompatActivity {
    Button btnEntrar, btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastro);


        chamarTelaCadastro();
        chamarTelaEscolha();
    }

    private void chamarTelaEscolha() {
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, EscolhaActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    private void chamarTelaCadastro() {
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, CadastroActivy.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}