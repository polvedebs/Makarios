package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class EscolhaActivity extends AppCompatActivity {

    CardView produtosDisponiveiesCardView;
    CardView produtosIndisponiveisCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);

        produtosDisponiveiesCardView = findViewById(R.id.cardProdutosDisponiveis);
        produtosIndisponiveisCardView = findViewById(R.id.cardProdutosIndisponiveis);

        chamarTelaProdutosIndisponiveis();
        chamarTelaProdutosDisponiveis();
    }

    private void chamarTelaProdutosIndisponiveis() {
        produtosIndisponiveisCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(EscolhaActivity.this, ProdutosIndisponiveisActivity.class);
                EscolhaActivity.this.startActivity(myIntent);
            }
        });
    }

    private void chamarTelaProdutosDisponiveis() {
        produtosDisponiveiesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(EscolhaActivity.this, ProdutosDisponiveisActivy.class);
                EscolhaActivity.this.startActivity(myIntent);
            }
        });
    }
}