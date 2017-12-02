package com.registree.registree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText titulo;
    EditText descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        titulo = (EditText) findViewById(R.id.textTitulo);
        descricao = (EditText) findViewById(R.id.textDescicao);

        Intent intent = getIntent();

//        Toast.makeText(getApplicationContext(), "Categoria escolhida foi: " + intent.getStringExtra("categoria"), Toast.LENGTH_SHORT).show();
    }

    public void chamarTela3 (View view){
        String tituloDenuncia = titulo.getText().toString();
        String descricaoDenuncia = descricao.getText().toString();

        Intent intent = getIntent();

        Intent objetointent = new Intent(Main2Activity.this, Main3Activity.class);

        objetointent.putExtra("categoria",intent.getStringExtra("categoria").toString());
        objetointent.putExtra("titulo", tituloDenuncia);
        objetointent.putExtra("descricao", descricaoDenuncia);


        startActivity(objetointent);
    }
}
