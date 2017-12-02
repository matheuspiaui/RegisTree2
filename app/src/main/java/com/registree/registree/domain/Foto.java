package com.registree.registree.domain;

import com.google.firebase.database.DatabaseReference;
import com.registree.registree.Firebase.ConfiguracaoFirebase;

/**
 * Created by Carla F on 29/11/2017.
 */

public class Foto {
    private Integer id;
    private String link;
    private Denuncia denuncia;

    public void salvar() {
        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFirebase();
        referenciaFirebase.child("usuario").child(String.valueOf(getId())).setValue(this);

    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
