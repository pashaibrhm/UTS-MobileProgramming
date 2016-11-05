package com.aquarian.utsmobpro2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PilihKue extends AppCompatActivity {

    ImageView strawberry, peanut, cherry, layer;
    public final static String EXTRA_NAMA_KUE = "Nama Kue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kue);
        pilihGambar();
    }

    public void pilihGambar() {
        strawberry = (ImageView) findViewById(R.id.cake_strawberry);
        peanut = (ImageView) findViewById(R.id.caramel_peanut_butter);
        cherry = (ImageView) findViewById(R.id.cherry_chocolate);

        strawberry.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), PreviewPesanan.class);
                        intent.putExtra(EXTRA_NAMA_KUE, "Cake Strawberry");
                        startActivity(intent);
                    }
                }
        );

        cherry.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), PreviewPesanan.class);
                        intent.putExtra(EXTRA_NAMA_KUE, "Cherry Chocolate");
                        startActivity(intent);
                    }
                }
        );

        peanut.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), PreviewPesanan.class);
                        intent.putExtra(EXTRA_NAMA_KUE, "Caramel Peanut Butter");
                        startActivity(intent);
                    }
                }
        );
    }
}
