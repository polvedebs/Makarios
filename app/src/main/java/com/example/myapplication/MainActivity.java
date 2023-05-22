package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.example.myapplication.activities.CadastroActivy;
import com.example.myapplication.activities.EscolhaActivity;
import com.example.myapplication.activities.ProdutosDisponiveisActivy;

public class MainActivity extends AppCompatActivity {
    Button btnEntrar, btnCadastrar;

    EditText txtLogin, txtSenhalogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastro);
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenhalogin = (EditText) findViewById(R.id.txtPassword);

        chamarTelaCadastro();
        chamarTelaEscolha();
    }

    private void chamarTelaEscolha() {
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                consultaUsuarioLogin();
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

    void consultaUsuarioLogin(){
        String Login = txtLogin.getText().toString();
        String SenhaLogin = txtSenhalogin.getText().toString();

        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.carregaDadosLogin(Login, SenhaLogin);

        if(dados.moveToFirst()){
            Intent tela = new Intent(this, EscolhaActivity.class);
            startActivity(tela);
        }else{
            String msg= "Dados não encontrados no sistema, digite outro!!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            limpar();
        }
    }
    public void limpar(){
        txtLogin.setText("");
        txtSenhalogin.setText("");
        txtLogin.requestFocus();

    }
}