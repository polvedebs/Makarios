package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.BancoController;
import com.example.myapplication.R;

public class CadastroProduto extends AppCompatActivity implements View.OnClickListener{

    EditText txtNomeProduto;
    CheckBox ckbContem;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);


        btnCadastrar = (Button) findViewById(R.id.btnCadastroProduto);
        txtNomeProduto = (EditText) findViewById(R.id.txtNomeProduto);
        ckbContem = (CheckBox) findViewById(R.id.ckbContem);

        btnCadastrar.setOnClickListener(this);
    }

    public void onClick(View v) {
        String NomeProduto = txtNomeProduto.getText().toString();
        boolean Contem = ckbContem.isChecked();

        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        resultado = bd.insereProduto(NomeProduto, Contem);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        limpar();

    }

    public void limpar() {
        txtNomeProduto.setText("");
        ckbContem.setChecked(false);
        txtNomeProduto.requestFocus();
    }
}