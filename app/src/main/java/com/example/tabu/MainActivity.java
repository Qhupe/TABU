package com.example.tabu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tabu.R;


public class MainActivity extends AppCompatActivity {

    private Button basla;
    private  Button cıkıs;
    private  Button soruEkle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basla=findViewById(R.id.basla);
        cıkıs=findViewById(R.id.cıkıs);
        soruEkle=findViewById(R.id.soruEkle);


        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gecisyap=new Intent(MainActivity.this,oyunEkrani.class);
                startActivity(gecisyap);



            }
        });

        cıkıs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        soruEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(MainActivity.this,soruEkleme.class);
                startActivity(gecisyap);

            }
        });








    }
}