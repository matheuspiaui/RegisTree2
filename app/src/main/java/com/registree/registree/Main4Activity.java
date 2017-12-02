package com.registree.registree;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    final int TirarFoto = 3;
    final int GALERIA_IMAGENS = 1;
    ImageView imagem;
    Button galeria;
    Button foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imagem = (ImageView) findViewById(R.id.imageViewFoto);
        galeria = (Button) findViewById(R.id.btnGaleria);
        foto = (Button) findViewById(R.id.btnFoto);

        Intent intent = getIntent();

        Toast.makeText(getApplicationContext(), "Categoria: " + intent.getStringExtra("categoria"), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Titulo: " + intent.getStringExtra("titulo"), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Descricao: " + intent.getStringExtra("descricao"), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Bairro: " + intent.getStringExtra("bairro"), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Rua: " + intent.getStringExtra("rua"), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Numero: " + intent.getStringExtra("numero"), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Referencia: " + intent.getStringExtra("referencia"), Toast.LENGTH_SHORT).show();


    }

    public void mostrarGaleria(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALERIA_IMAGENS);
    }

    public void tirarFoto(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, TirarFoto);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK && requestCode == GALERIA_IMAGENS) {
            Uri selectedImage = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap imagemGaleria = (BitmapFactory.decodeFile(picturePath));
            imagem.setImageBitmap(imagemGaleria);
        }
    }

    public void chamarTela5 (View view){
//        String bairroDenuncia = bairro.getText().toString();
//        String ruaDenuncia = rua.getText().toString();
//        String numeroDenuncia = numero.getText().toString();
//        String referenciaDenuncia = referencia.getText().toString();
        Intent objetointent = new Intent(Main4Activity.this, Main5Activity.class);
//        objetointent.putExtra("bairro1", bairroDenuncia);
//        objetointent.putExtra("rua1", ruaDenuncia);
//        objetointent.putExtra("numero1", numeroDenuncia);
//        objetointent.putExtra("referencia1", referenciaDenuncia);


//        Intent objtointent = getIntent();
//        String tituloV = objtointent.getStringExtra("titulo1");
//        String descricaoV = objtointent.getStringExtra("descricao1");
//
//        objtointent.putExtra("titulo3", tituloV);
//        objtointent.putExtra("descricao3", descricaoV);

        startActivity(objetointent);
    }

}
