package com.example.calculapromedio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class notaFinal extends AppCompatActivity{

    private ConstraintLayout bg;
    private TextView textTv, tittleTv, gradeTv;
    private Button retryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_nota);

        textTv = findViewById(R.id.textTv);
        tittleTv = findViewById(R.id.tittleTv);
        gradeTv = findViewById(R.id.finalGradeTv);
        retryBtn = findViewById(R.id.retryBtn);
        bg = findViewById(R.id.background);

        SharedPreferences preferences = getSharedPreferences("name", MODE_PRIVATE);

        String average = getIntent().getExtras().getString("average");
        String name = preferences.getString("name", "#FFFFFF");

        textTv.setText("Hola " + name + ". Tu nota final es:");
        gradeTv.setText("" + average);

        //   Toast.makeText(this, "" + name, Toast.LENGTH_SHORT).show();

        retryBtn.setOnClickListener(

                (v) -> {

                    finish();
                }
        );
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("colors", MODE_PRIVATE);

        String bgColor = preferences.getString("bgColor", "#FFFFFF");
        String typeColor = preferences.getString("typeColor", "#FFFFFF");
        bg.setBackgroundColor(Color.parseColor(bgColor));
        tittleTv.setTextColor(Color.parseColor(typeColor));
        textTv.setTextColor(Color.parseColor(typeColor));
        gradeTv.setTextColor(Color.parseColor(typeColor));

    }
}
    

