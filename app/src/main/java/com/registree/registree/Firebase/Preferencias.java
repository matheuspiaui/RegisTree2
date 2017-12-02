package com.registree.registree.Firebase;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Carla F on 29/11/2017.
 */

public class Preferencias {
    private Context context;
    private SharedPreferences preferences;
    private String ARQUIVO = "testeFirebase.preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_IDENTIFICADOR = "idUsuarioLogado";
    private final String CHAVE_NOME = "nomeUsuarioLogado";

    public Preferencias(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(ARQUIVO,MODE);

        //editor = preferences.edit();
    }

    public void salvarUsuarioPreferencias(String idUsuario,String nomeUsuario) {
        editor.putString(CHAVE_IDENTIFICADOR,idUsuario);
        editor.putString(CHAVE_NOME,nomeUsuario);
        editor.commit();
    }

    public String getIdentificador() {
        return preferences.getString(CHAVE_IDENTIFICADOR,null);
    }

    public String getNome() {
        return preferences.getString(CHAVE_NOME,null);
    }
}
