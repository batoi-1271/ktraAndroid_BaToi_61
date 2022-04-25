package com.example.batoi_61;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class batoi_Updates extends AppCompatActivity {

    private EditText edtBKS, edtTenCX, edtHangxe, edtTrongtai, edtHTKD;
    private Button btnUpdate, btnExit;
    private batoi_dataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batoi_updates);
        database = new batoi_dataBase(this);
        edtBKS = findViewById(R.id.edtBKS);
        edtTenCX = findViewById(R.id.edtTenCX);
        edtHangxe = findViewById(R.id.edtHX);
        edtTrongtai = findViewById(R.id.edtTT);
        edtHTKD = findViewById(R.id.edtHTKD);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnExit = findViewById(R.id.btnThoat);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        batoi_vanTai vatTai = database.findById(id);
        if(vatTai !=null){
            edtBKS.setText(vatTai.getBks());
            edtTenCX.setText(vatTai.getTenchuxe());
            edtHangxe.setText(vatTai.getHangxe());
            edtTrongtai.setText(vatTai.getTrongtai());
            edtHTKD.setText(vatTai.getHtkinhdoanh());

        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                batoi_vanTai vatTai = new batoi_vanTai(
                        id,
                        edtBKS.getText().toString(),
                        edtTenCX.getText().toString(),
                        edtHangxe.getText().toString(),
                        edtTrongtai.getText().toString(),
                        edtHTKD.getText().toString()
                );
                if (vatTai != null)
                    database.update(vatTai);
                Intent intent = new Intent(batoi_Updates.this, MainActivity.class);
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