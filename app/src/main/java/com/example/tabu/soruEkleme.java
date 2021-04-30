package com.example.tabu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class soruEkleme extends AppCompatActivity {

    private EditText yeniKelime,yeniYasak1,yeniYasak2,yeniYasak3,yeniYasak4,yeniYasak5;
    private Button Ekle;
    private Veritabani vt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru_ekleme);

        Ekle=findViewById(R.id.Ekle);
        yeniKelime=findViewById(R.id.yenikelime);
        yeniYasak1=findViewById(R.id.yeniYasak1);
        yeniYasak2=findViewById(R.id.yeniYasak2);
        yeniYasak3=findViewById(R.id.yeniYasak3);
        yeniYasak4=findViewById(R.id.yeniYasak4);
        yeniYasak5=findViewById(R.id.yeniYasak5);

        vt=new Veritabani(this);

        Ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContentValues values=new ContentValues();

                values.put("kelime",yeniKelime.getText().toString());
                values.put("yasak1",yeniYasak1.getText().toString());
                values.put("yasak2",yeniYasak2.getText().toString());
                values.put("yasak3",yeniYasak3.getText().toString());
                values.put("yasak4",yeniYasak4.getText().toString());
                values.put("yasak5",yeniYasak5.getText().toString());

                Uri uri =getContentResolver().insert(MyProvider.CONTENT_URI,values);

                Toast.makeText(getApplicationContext(),"kelime "+uri.toString()+" Kayıt Edildi",Toast.LENGTH_SHORT).show();





                Intent gecisyap=new Intent(soruEkleme.this,MainActivity.class);
                Toast.makeText(getApplicationContext(), "Yeni Soru Eklendi", Toast.LENGTH_SHORT);

                startActivity(gecisyap);

            }
        });


    }
}