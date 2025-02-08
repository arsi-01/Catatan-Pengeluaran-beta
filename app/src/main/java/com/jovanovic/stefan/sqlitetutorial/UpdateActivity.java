package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText pengeluaran_input, deskripsi_input, harga_input;
    Button update_button, delete_button;

    String id, pengeluaran, deskripsi, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        pengeluaran_input = findViewById(R.id.barang_jasa_input2); // Pastikan ID input sesuai dengan XML
        deskripsi_input = findViewById(R.id.deskripsi_input2);
        harga_input = findViewById(R.id.harga_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        // Ambil dan atur data dari Intent
        getAndSetIntentData();

        // Atur judul ActionBar setelah data diambil
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(pengeluaran);
        }

        // Tombol Update
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                pengeluaran = pengeluaran_input.getText().toString().trim();
                deskripsi = deskripsi_input.getText().toString().trim();
                harga = harga_input.getText().toString().trim();

                // Perbarui data di database
                myDB.updateData(id, pengeluaran, deskripsi, harga);
            }
        });

        // Tombol Hapus
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }

    // Ambil data dari Intent dan tampilkan ke EditText
    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("pengeluaran") &&
                getIntent().hasExtra("deskripsi") && getIntent().hasExtra("harga")) {

            // Ambil data dari Intent
            id = getIntent().getStringExtra("id");
            pengeluaran = getIntent().getStringExtra("pengeluaran");
            deskripsi = getIntent().getStringExtra("deskripsi");
            harga = getIntent().getStringExtra("harga");

            // Set data ke EditText
            pengeluaran_input.setText(pengeluaran);
            deskripsi_input.setText(deskripsi);
            harga_input.setText(harga);

            // Log untuk debug
            Log.d("UpdateActivity", "Data: ID=" + id + ", Pengeluaran=" + pengeluaran +
                    ", Deskripsi=" + deskripsi + ", Harga=" + harga);
        } else {
            Toast.makeText(this, "Data tidak tersedia.", Toast.LENGTH_SHORT).show();
        }
    }

    // Konfirmasi sebelum menghapus data
    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hapus " + pengeluaran + "?");
        builder.setMessage("Apakah Anda yakin ingin menghapus " + pengeluaran + "?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish(); // Tutup activity setelah data dihapus
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Tidak melakukan apa-apa
            }
        });
        builder.create().show();
    }
}
