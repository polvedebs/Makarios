package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";
    private static final int VERSAO = 5;


    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contatos");
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS produtos");
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE contatos ("
                + "codigo integer primary key autoincrement,"
                + "nome text,"
                + "email text)";
        db.execSQL(sql);
        String sql1 = "CREATE TABLE usuarios ("
                + "codigo integer primary key autoincrement,"
                + "nome text,"
                + "email text,"
                + "senha text)";
        db.execSQL(sql1);

        String sql2 = "CREATE TABLE produtos ("
                + "codigo integer primary key autoincrement,"
                + "nome text,"
                + "contem boolean)";
        db.execSQL(sql2);
    }

}