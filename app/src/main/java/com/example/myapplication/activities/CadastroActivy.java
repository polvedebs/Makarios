package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.BancoController;
import com.example.myapplication.R;

public class CadastroActivy extends AppCompatActivity implements View.OnClickListener {

    Button btnSalvar;
    EditText txtNomeCad, txtEmailCad, txtSenhaCad;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_activy);

        btnSalvar = (Button) findViewById(R.id.btnCriar);
        txtNomeCad = (EditText) findViewById(R.id.txtNome);
        txtEmailCad = (EditText) findViewById(R.id.txtEmail);
        txtSenhaCad = (EditText) findViewById(R.id.txtSenha);

        btnSalvar.setOnClickListener(this);
    }

    public void onClick(View v) {
        String NomeCad = txtNomeCad.getText().toString();
        String EmailCad = txtEmailCad.getText().toString();
        String SenhaCad = txtSenhaCad.getText().toString();


        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        resultado = bd.insereDadosUsuario(NomeCad, EmailCad, SenhaCad);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        limpar();

    }

    public void limpar() {
        txtNomeCad.setText("");
        txtEmailCad.setText("");
        txtSenhaCad.setText("");
        txtNomeCad.requestFocus();
    }
}