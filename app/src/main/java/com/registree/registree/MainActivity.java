package com.registree.registree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner categoria;


    private List<String> spCategoria = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> valoresRecuperados = new ArrayList<>();
//        String[] array;
//        valoresRecuperados.toArray(array);

        categoria = (Spinner) findViewById(R.id.spinCategoria);
//        ArrayAdapter listaCategoria = ArrayAdapter.createFromResource(this, R.array.categoria, android.R.layout.select_dialog_item);
//        ArrayAdapter listaCategoria = ArrayAdapter.createFromResource(this, valoresRecuperados, android.R.layout.select_dialog_item);
//        final ArrayAdapter listaCategoria = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,valoresRecuperados );
//        categoria.setAdapter(listaCategoria);

        //Adicionando Nomes no ArrayList
        spCategoria.add("Risco de Queda");
        spCategoria.add("Falta de Cuidados");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spCategoria);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        categoria.setAdapter(spinnerArrayAdapter);

        //

//        FirebaseDatabase firebase = FirebaseDatabase.getInstance();

//        DatabaseReference firebase = FirebaseDatabase.getInstance().getReference("categoria/");
//
//        firebase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot: dataSnapshot.getChildren() ) {
//
//                    Categoria categoria = snapshot.getValue(Categoria.class);
////                    listaCategoria.add(snapshot.child("nome").getValue().toString());
//                    listaCategoria.add(categoria.getNome());
//
//                    listaCategoria.notifyDataSetChanged();
//
//
////                    Toast.makeText(MainActivity.this, "Nome: "+snapshot.child("nome").getValue().toString(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        
//        firebase.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });



    }

    public void chamarTela (View view){
        String item = categoria.getSelectedItem().toString();
//         Toast.makeText(getApplicationContext(), "Categoria escolhida foi: "+item, Toast.LENGTH_SHORT).show();
        Intent objeto = new Intent(this, Main2Activity.class);
        objeto.putExtra("categoria",categoria.getSelectedItem().toString());
        startActivity(objeto);
    }

    public void carregar (View view){

//        DatabaseReference firebase = FirebaseDatabase.getInstance().getReference("categoria/");
//
//        firebase.push().child("nome").setValue("Risco de Queda");
//        firebase.push().child("nome").setValue("Falta de Cuidados");


    }

}
