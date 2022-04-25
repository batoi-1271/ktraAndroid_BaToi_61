package com.example.batoi_61;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class batoi_Inserts extends AppCompatActivity {

    private EditText edtBKS, edtTenCX, edtHangxe, edtTrongtai, edtHTKD;
    private Button btnInsert, btnExit;
    private batoi_dataBase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batoi_inserts);
        database = new batoi_dataBase(this);

        edtBKS = findViewById(R.id.edtBKS);
        edtTenCX = findViewById(R.id.edtTenCX);
        edtHangxe = findViewById(R.id.edtHX);
        edtTrongtai = findViewById(R.id.edtTT);
        edtHTKD = findViewById(R.id.edtHTKD);

        btnInsert = findViewById(R.id.btnThem);
        btnExit = findViewById(R.id.btnThoat);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                batoi_vanTai vatTai = new batoi_vanTai(
                        edtBKS.getText().toString(),
                        edtTenCX.getText().toString(),
                        edtHangxe.getText().toString(),
                        edtTrongtai.getText().toString(),
                        edtHTKD.getText().toString()
                );
                if(vatTai !=null) database.insert(vatTai);
                Intent intent = new Intent(batoi_Inserts.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}