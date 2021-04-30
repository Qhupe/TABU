package com.example.tabu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tabu.R;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class oyunEkrani extends AppCompatActivity {


    int skora=0;
    int skorb=0;
    int bayrak=0;
    static Random r=new Random();
    static int tane=0;
    static int pashakkı=0;




    private Button dogru,yanlis,pas,basla;
    private TextView skor,sayac,soru,yasak1,yasak2,yasak3,yasak4,yasak5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Cursor c=getContentResolver().query(MyProvider.CONTENT_URI,null,null,null,null);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_ekrani);

        dogru = findViewById(R.id.dogru);
        yanlis = findViewById(R.id.yanlis);
        pas = findViewById(R.id.pas);
        skor = findViewById(R.id.skor);
        sayac = (TextView) findViewById(R.id.sayac);
        basla = findViewById(R.id.basla);
        soru=findViewById(R.id.soru);
        yasak1=findViewById(R.id.yasak1);
        yasak2=findViewById(R.id.yasak2);
        yasak3=findViewById(R.id.yasak3);
        yasak4=findViewById(R.id.yasak4);
        yasak5=findViewById(R.id.yasak5);






        dogru.setEnabled(false);
        yanlis.setEnabled(false);
        pas.setEnabled(false);

        tane=0;



            while (c.moveToNext()) {
                tane = tane + 1;
            }



        dogru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bayrak % 2 == 1) {
                    skora++;
                    skor.setText(String.valueOf("A TAKIMI=" + skora + " B TAKIMI=" + skorb));
                } else {
                    skorb++;
                    skor.setText(String.valueOf("A TAKIMI=" + skora + " B TAKIMI=" + skorb));

                }
                Cursor c=getContentResolver().query(MyProvider.CONTENT_URI,null,null,null,null);



                String sorutut="";
                String yasak1tut="";
                String yasak2tut="";
                String yasak3tut="";
                String yasak4tut="";
                String yasak5tut="";
                int a=r.nextInt(tane-1);





                for (int i=0;i<a;i++){
                    c.moveToNext();

                    sorutut=c.getString(c.getColumnIndex("kelime"));
                    yasak1tut=c.getString(c.getColumnIndex("yasak1"));
                    yasak2tut=c.getString(c.getColumnIndex("yasak2"));
                    yasak3tut=c.getString(c.getColumnIndex("yasak3"));
                    yasak4tut=c.getString(c.getColumnIndex("yasak4"));
                    yasak5tut=c.getString(c.getColumnIndex("yasak5"));

                }



                soru.setText(sorutut);
                yasak1.setText(yasak1tut);
                yasak2.setText(yasak2tut);
                yasak3.setText(yasak3tut);
                yasak4.setText(yasak4tut);
                yasak5.setText(yasak5tut);

            }
        });

        yanlis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bayrak % 2 == 1) {
                    skora--;
                    skor.setText(String.valueOf("A TAKIMI=" + skora + " B TAKIMI=" + skorb));
                } else {
                    skorb--;
                    skor.setText(String.valueOf("A TAKIMI=" + skora + " B TAKIMI=" + skorb));

                }
                Cursor c=getContentResolver().query(MyProvider.CONTENT_URI,null,null,null,null);



                String sorutut="";
                String yasak1tut="";
                String yasak2tut="";
                String yasak3tut="";
                String yasak4tut="";
                String yasak5tut="";
                int a=r.nextInt(tane-1);





                for (int i=0;i<a;i++){
                    c.moveToNext();

                    sorutut=c.getString(c.getColumnIndex("kelime"));
                    yasak1tut=c.getString(c.getColumnIndex("yasak1"));
                    yasak2tut=c.getString(c.getColumnIndex("yasak2"));
                    yasak3tut=c.getString(c.getColumnIndex("yasak3"));
                    yasak4tut=c.getString(c.getColumnIndex("yasak4"));
                    yasak5tut=c.getString(c.getColumnIndex("yasak5"));

                }



                soru.setText(sorutut);
                yasak1.setText(yasak1tut);
                yasak2.setText(yasak2tut);
                yasak3.setText(yasak3tut);
                yasak4.setText(yasak4tut);
                yasak5.setText(yasak5tut);






            }
        });



        pas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pashakkı++;

                if (pashakkı>=3){
                    pas.setEnabled(false);
                }

                Toast.makeText(getApplicationContext(), "Pas Hakkı Doldu", Toast.LENGTH_SHORT);

            }
        });



        basla.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Cursor c=getContentResolver().query(MyProvider.CONTENT_URI,null,null,null,null);


                pashakkı=0;

                String sorutut="";
                String yasak1tut="";
                String yasak2tut="";
                String yasak3tut="";
                String yasak4tut="";
                String yasak5tut="";
                int a=r.nextInt(tane-1);





                for (int i=0;i<a;i++){
                    c.moveToNext();

                    if (c.getString(c.getColumnIndex("kelime")).length()>0){

                        sorutut=c.getString(c.getColumnIndex("kelime"));
                        yasak1tut=c.getString(c.getColumnIndex("yasak1"));
                        yasak2tut=c.getString(c.getColumnIndex("yasak2"));
                        yasak3tut=c.getString(c.getColumnIndex("yasak3"));
                        yasak4tut=c.getString(c.getColumnIndex("yasak4"));
                        yasak5tut=c.getString(c.getColumnIndex("yasak5"));

                    }



                }



                soru.setText(sorutut);
                yasak1.setText(yasak1tut);
                yasak2.setText(yasak2tut);
                yasak3.setText(yasak3tut);
                yasak4.setText(yasak4tut);
                yasak5.setText(yasak5tut);






                new CountDownTimer(10000,1000){

                    @Override
                    public void onTick(long l) {
                        sayac.setText("Kalan Süre :"+l/1000);
                        basla.setEnabled(false);
                        dogru.setEnabled(true);
                        yanlis.setEnabled(true);
                        pas.setEnabled(true);
                        if (pashakkı>=3){
                            pas.setEnabled(false);
                        }



                    }

                    @Override
                    public void onFinish() {

                        bayrak++;
                        sayac.setText("Sıra Diğer Takıma Geçti");
                        dogru.setEnabled(false);
                        yanlis.setEnabled(false);
                        pas.setEnabled(false);
                        basla.setEnabled(true);


                        AlertDialog.Builder ao = new AlertDialog.Builder(oyunEkrani.this);

                        ao.setIcon(R.drawable.resim);
                        ao.setTitle("TUR DEĞİŞİMİ");
                        ao.setMessage("Oyun Sırası Diğer Takıma Geçti");

                        ao.setPositiveButton("Devam Et", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {



                                Toast.makeText(getApplicationContext(), "Takım İçin Yeni Tur Başladı", Toast.LENGTH_SHORT);




                            }
                        });

                        ao.create().show();



                    }
                }.start();


            }
        });









    }

}