package com.registree.registree.domain;

import com.google.firebase.database.DatabaseReference;
import com.registree.registree.Firebase.ConfiguracaoFirebase;

import java.security.Timestamp;

/**
 * Created by Carla F on 29/11/2017.
 */

public class Comentario {
    private Integer id;
    private Timestamp dataHora;
    private String descricao;
    private Denuncia denuncia;

    public void salvar() {
        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFirebase();
        referenciaFirebase.child("usuario").child(String.valueOf(getId())).setValue(this);

    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
