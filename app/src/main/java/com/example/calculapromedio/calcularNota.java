package com.example.calculapromedio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calcularNota extends AppCompatActivity{

    private ConstraintLayout bg;
    private EditText proyecto1, proyecto2, quices, parcial1, parcial2;
    private Button calculateBtn;
    private TextView textName, tittleGrade;
    private Double averageRounded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcular_nota);

        proyecto1 = findViewById(R.id.proyecto1);
        proyecto2 = findViewById(R.id.proyecto2);
        quices = findViewById(R.id.quices);
        parcial1 = findViewById(R.id.parcial1);
        parcial2 = findViewById(R.id.parcial2);
        calculateBtn = findViewById(R.id.calculateBtn);
        bg = findViewById(R.id.background);
        textName = findViewById(R.id.textName);
        tittleGrade = findViewById(R.id.tittleGrade);
        calculateBtn = findViewById(R.id.calculateBtn);

        calculateBtn.setOnClickListener(

                (v) -> {

                    calculateGrade();
                    // Toast.makeText(this, "" + averageRounded, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, notaFinal.class);
                    String average = String.valueOf(averageRounded);
                    i.putExtra("average", average);
                    startActivity(i);
                    finish();

                }
        );
    }

    public void calculateGrade() {

        double grade1 = Double.parseDouble(proyecto1.getText().toString());
        double grade2 = Double.parseDouble(proyecto2.getText().toString());
        double grade3 = Double.parseDouble(quices.getText().toString());
        double grade4 = Double.parseDouble(parcial1.getText().toString());
        double grade5 = Double.parseDouble(parcial2.getText().toString());

        double average = ((grade1 * 0.25) + (grade2 * 0.25) + (grade3 * 0.20) + (grade4 * 0.15) + (grade5 * 0.15));
        averageRounded = Math.round(average * 100.0) / 100.0;

    }

    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("colors", MODE_PRIVATE);

        String bgColor = preferences.getString("bgColor", "#FFFFFF");
        String typeColor = preferences.getString("typeColor", "#FFFFFF");
        bg.setBackgroundColor(Color.parseColor(bgColor));
        tittleGrade.setTextColor(Color.parseColor(typeColor));
        textName.setTextColor(Color.parseColor(typeColor));
        proyecto1.setTextColor(Color.parseColor(typeColor));
        proyecto2.setTextColor(Color.parseColor(typeColor));
        quices.setTextColor(Color.parseColor(typeColor));
        parcial1.setTextColor(Color.parseColor(typeColor));
        parcial2.setTextColor(Color.parseColor(typeColor));

    }


}

