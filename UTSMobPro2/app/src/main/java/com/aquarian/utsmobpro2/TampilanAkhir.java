package com.aquarian.utsmobpro2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TampilanAkhir extends AppCompatActivity {

    ImageView kue;
    TextView pengirim, target, pesan;
    String isipengirim, isitarget, isipesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_akhir);
        hasil();
    }

    public void hasil() {
        kue = (ImageView) findViewById(R.id.IvKue);
        pengirim = (TextView) findViewById(R.id.TvPengirim);
        target = (TextView) findViewById(R.id.TvTarget);
        pesan = (TextView) findViewById(R.id.TvPesan);

        isipengirim = getIntent().getStringExtra(PreviewPesanan.EXTRA_NAMA_PENGIRIM);
        isipesan = getIntent().getStringExtra(PreviewPesanan.EXTRA_PESAN);
        isitarget = getIntent().getStringExtra(PreviewPesanan.EXTRA_TARGET);

        pengirim.setText(isipengirim);
        target.setText(isitarget);
        pesan.setText(isipesan);
    }
}
