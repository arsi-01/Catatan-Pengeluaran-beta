package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText barang_jasa_input, deskripsi_input, harga_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        barang_jasa_input = findViewById(R.id.barang_jasa_input);
        deskripsi_input = findViewById(R.id.deskripsi_input);
        harga_input = findViewById(R.id.harga_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addExpense(barang_jasa_input.getText().toString().trim(),
                        deskripsi_input.getText().toString().trim(),
                        Integer.valueOf(harga_input.getText().toString().trim()));
            }
        });
    }
}
