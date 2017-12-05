package com.registree.registree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.registree.registree.domain.Denuncia;

import java.text.DateFormat;
import java.util.Date;

public class Main5Activity extends AppCompatActivity {
    TextView titulo;
    TextView descricao;
    TextView endereco;
    TextView categoria;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        titulo = (TextView) findViewById(R.id.textViewTitulo);
        descricao = (TextView) findViewById(R.id.textViewDescricao);
        endereco = (TextView) findViewById(R.id.textViewEndereco);
        categoria = (TextView) findViewById(R.id.textViewCategoria);

        Intent intent = getIntent();

        titulo.setText(intent.getStringExtra("titulo").toString());
        descricao.setText(intent.getStringExtra("descricao").toString());
        endereco.setText("Rua "+intent.getStringExtra("rua").toString()+
                        ", "+intent.getStringExtra("numero").toString()+"" +
                " - "+intent.getStringExtra("bairro").toString().toString()+ "\n" +
                "Ponto de Referencia: " + intent.getStringExtra("referencia").toString());

        categoria.setText("Categoria: " + intent.getStringExtra("categoria").toString());


//        Toast.makeText(getApplicationContext(), "Categoria: " + intent.getStringExtra("categoria"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), "Titulo: " + intent.getStringExtra("titulo"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), "Descricao: " + intent.getStringExtra("descricao"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), "Bairro: " + intent.getStringExtra("bairro"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), "Rua: " + intent.getStringExtra("rua"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), "Numero: " + intent.getStringExtra("numero"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), "Referencia: " + intent.getStringExtra("referencia"), Toast.LENGTH_SHORT).show();






    }

    public void salvar (View view){

        try {
            Denuncia denuncia = new Denuncia();
            Intent intent = getIntent();

            DatabaseReference firebase = FirebaseDatabase.getInstance().getReference("denuncia/");

            denuncia.setTitulo(intent.getStringExtra("titulo").toString());
            denuncia.setDescricao(intent.getStringExtra("descricao").toString());
            denuncia.setCategoria(intent.getStringExtra("categoria").toString());
            denuncia.setRua(intent.getStringExtra("rua").toString());
            denuncia.setNumero(intent.getStringExtra("numero").toString());
            denuncia.setBairro(intent.getStringExtra("bairro").toString());
            denuncia.setReferencia(intent.getStringExtra("referencia").toString());
            String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
            denuncia.setData(currentDateTimeString);

//            firebase.push().child("denuncia").setValue(denuncia);
            firebase.push().setValue(denuncia);

            Intent objeto = new Intent(this, Main6Activity.class);

            startActivity(objeto);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
