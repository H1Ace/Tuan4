package com.example.myapplication.Tuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class T41MainActivity extends AppCompatActivity {
    Button btnGetdata;
    TextView tvQK;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t41_main);
        T4Volley volley = new T4Volley();
        tvQK=findViewById(R.id.T4TvKQ);
        btnGetdata = findViewById(R.id.t4btn1);
        btnGetdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volley.getJsonArrayOfObjec(context,tvQK);
            }
        });
    }
}