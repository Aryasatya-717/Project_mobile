package com.example.project_pler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    TextView tvSapaan;
    Button btnPindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvSapaan = findViewById(R.id.tvSapaan);
        btnPindah = findViewById(R.id.btnKeProfil);


        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        updateTampilanNama();
    }


    void updateTampilanNama() {

        SharedPreferences sharedPref = getSharedPreferences("DataMahasiswa", MODE_PRIVATE);


        String namaYgDisimpan = sharedPref.getString("kunci_nama", "Mahasiswa");


        tvSapaan.setText("Halo, " + namaYgDisimpan + "!");
    }
}