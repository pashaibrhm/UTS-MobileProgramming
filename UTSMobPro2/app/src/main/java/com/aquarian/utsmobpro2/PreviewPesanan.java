package com.aquarian.utsmobpro2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PreviewPesanan extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView hasil;
    EditText namapengirim, pesan;
    Button submit;
    String recievedString, item;
    Spinner spinner;
    public static final String EXTRA_NAMA_PESANAN = "Nama Pesanan";
    public static final String EXTRA_NAMA_PENGIRIM = "Nama Pengirim";
    public static final String EXTRA_PESAN = "Pesan";
    public static final String EXTRA_TARGET = "Target";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_pesanan);
        prosesSubmit();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: "+item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void prosesSubmit() {
        pesan = (EditText) findViewById(R.id.EtPesan);
        namapengirim = (EditText) findViewById(R.id.EtPengirim);
        submit = (Button) findViewById(R.id.BtSubmit);
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        List<String> categories = new ArrayList<String>();
        categories.add("Keluarga");
        categories.add("Teman");
        categories.add("Saudara");
        categories.add("Kerabat");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        recievedString = getIntent().getStringExtra(PilihKue.EXTRA_NAMA_KUE);

        hasil = (TextView) findViewById(R.id.TvHasil);

        hasil.setText(recievedString);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), TampilanAkhir.class);
                        intent.putExtra(EXTRA_NAMA_PESANAN, recievedString);
                        intent.putExtra(EXTRA_NAMA_PENGIRIM, namapengirim.getText().toString());
                        intent.putExtra(EXTRA_PESAN, pesan.getText().toString());
                        intent.putExtra(EXTRA_TARGET, item);
                        startActivity(intent);
                    }
                }
        );
    }
}
