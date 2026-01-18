package com.example.project_pler;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class ProfileActivity extends AppCompatActivity {

    EditText etNama, etNIM, etJurusan;
    Button btnSave;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        etNama = findViewById(R.id.inputNama);
        etNIM = findViewById(R.id.inputNIM);
        etJurusan = findViewById(R.id.inputJurusan);
        btnSave = findViewById(R.id.btnSimpan);

        sharedPref = getSharedPreferences("DataMahasiswa", MODE_PRIVATE);

        String nama = sharedPref.getString("kunci_nama", "");
        String nim = sharedPref.getString("kunci_nim", "");
        String jurusan = sharedPref.getString("kunci_jurusan", "");

        etNama.setText(nama);
        etNIM.setText(nim);
        etJurusan.setText(jurusan);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("kunci_nama", etNama.getText().toString());
                editor.putString("kunci_nim", etNIM.getText().toString());
                editor.putString("kunci_jurusan", etJurusan.getText().toString());
                editor.apply();
                Toast.makeText(ProfileActivity.this, "Data Tersimpan!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}