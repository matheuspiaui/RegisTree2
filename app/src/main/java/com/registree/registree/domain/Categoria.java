package com.registree.registree.domain;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.IgnoreExtraProperties;
import com.registree.registree.Firebase.ConfiguracaoFirebase;

/**
 * Created by Carla F on 27/11/2017.
 */
@IgnoreExtraProperties
public class Categoria {

    private String id;
    private String nome;

    public Categoria(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Categoria(String id) {

    }

    public Categoria() {

    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public void salvar() {
        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFirebase();
        referenciaFirebase.child("Categoria").child(String.valueOf(getId())).setValue(this);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
