package com.registree.registree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    EditText bairro;
    EditText rua;
    EditText numero;
    EditText referencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        bairro = (EditText) findViewById(R.id.textBairro);
        rua = (EditText) findViewById(R.id.textRua);
        numero = (EditText) findViewById(R.id.textNumero);
        referencia = (EditText) findViewById(R.id.textReferencia);

        Intent intent = getIntent();

//        Toast.makeText(getApplicationContext(), "Categoria: " + intent.getStringExtra("categoria"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), "Titulo: " + intent.getStringExtra("titulo"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), "Descricao: " + intent.getStringExtra("descricao"), Toast.LENGTH_SHORT).show();

    }

    public void chamarTela4 (View view){
        String bairroDenuncia = bairro.getText().toString();
        String ruaDenuncia = rua.getText().toString();
        String numeroDenuncia = numero.getText().toString();
        String referenciaDenuncia = referencia.getText().toString();

        Intent intent = getIntent();

        Intent objetointent = new Intent(Main3Activity.this, Main5Activity.class);


        objetointent.putExtra("categoria",intent.getStringExtra("categoria").toString());
        objetointent.putExtra("titulo", intent.getStringExtra("titulo").toString());
        objetointent.putExtra("descricao", intent.getStringExtra("descricao").toString());
        objetointent.putExtra("bairro", bairroDenuncia);
        objetointent.putExtra("rua", ruaDenuncia);
        objetointent.putExtra("numero", numeroDenuncia);
        objetointent.putExtra("referencia", referenciaDenuncia);


        startActivity(objetointent);
    }
}
