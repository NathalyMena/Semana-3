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
import android.widget.Toast;

public class calcularNota extends AppCompatActivity{

    private ConstraintLayout bg;
    private EditText proyectoUnoInput, proyectoDosInput, quicesInput, parcialUnoInput, parcialDosInput;
    private Button calculateBtn;
    private TextView textTv, tittleTv;
    private Double averageRounded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcular_nota);

        proyectoUnoInput = findViewById(R.id.proyectoUnoInput);
        proyectoDosInput = findViewById(R.id.proyectoDosInput);
        quicesInput = findViewById(R.id.quicesInput);
        parcialUnoInput = findViewById(R.id.parcialUnoInput);
        parcialDosInput = findViewById(R.id.parcialDosInput);
        calculateBtn = findViewById(R.id.calculateBtn);
        bg = findViewById(R.id.background);
        textTv = findViewById(R.id.textTv);
        tittleTv = findViewById(R.id.tittleTv);
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

    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("colors", MODE_PRIVATE);

        String bgColor = preferences.getString("bgColor", "#FFFFFF");
        String typeColor = preferences.getString("typeColor", "#FFFFFF");
        bg.setBackgroundColor(Color.parseColor(bgColor));
        tittleTv.setTextColor(Color.parseColor(typeColor));
        textTv.setTextColor(Color.parseColor(typeColor));
        proyectoUnoInput.setTextColor(Color.parseColor(typeColor));
        proyectoDosInput.setTextColor(Color.parseColor(typeColor));
        quicesInput.setTextColor(Color.parseColor(typeColor));
        parcialUnoInput.setTextColor(Color.parseColor(typeColor));
        parcialDosInput.setTextColor(Color.parseColor(typeColor));

    }

    public void calculateGrade() {

        double grade1 = Double.parseDouble(proyectoUnoInput.getText().toString());
        double grade2 = Double.parseDouble(proyectoDosInput.getText().toString());
        double grade3 = Double.parseDouble(quicesInput.getText().toString());
        double grade4 = Double.parseDouble(parcialUnoInput.getText().toString());
        double grade5 = Double.parseDouble(parcialDosInput.getText().toString());

        double average = ((grade1 * 0.25) + (grade2 * 0.25) + (grade3 * 0.20) + (grade4 * 0.15) + (grade5 * 0.15));
        averageRounded = Math.round(average * 100.0) / 100.0;

    }
}

