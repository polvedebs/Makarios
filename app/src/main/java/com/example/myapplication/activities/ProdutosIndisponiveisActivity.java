package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.BancoController;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ProdutosIndisponiveisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos_indisponiveis);

        ListView lsv = (ListView) findViewById(R.id.lsvProdutosIndisponiveis);

        List<String> produtos = consultarProdutos();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_lista, R.id.textViewNome,  consultarProdutos());

        lsv.setAdapter(adapter);
    }

    List<String> consultarProdutos() {

        List<String> produtos = new ArrayList<>();

        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.carregaDadosProdutoIndisponiveis();

        while (dados.moveToNext()) {
            String dado = dados.getString(1);
            produtos.add(dado);
        }
        return produtos;
    }
}