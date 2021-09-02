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

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout bg;
    private EditText nameInput;
    private Button configBtn, okBtn;
    private TextView textTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configBtn = findViewById(R.id.configBtn);
        okBtn = findViewById(R.id.okBtn);
        nameInput = findViewById(R.id.nameInput);
        bg = findViewById(R.id.background);
        textTv = findViewById(R.id.textTv);

        SharedPreferences preferences = getSharedPreferences("name", MODE_PRIVATE);

        configBtn.setOnClickListener(

                (v) -> {
                    Intent i = new Intent(this, color.class);
                    startActivity(i);
                }
        );

        okBtn.setOnClickListener(

                (v) -> {

                    if (nameInput.getText().toString().isEmpty()) {
                        Toast.makeText(this, "Ingrese un nombre para calcular su nota", Toast.LENGTH_LONG).show();
                    } else {
                        String name = nameInput.getText().toString();
                        preferences.edit().putString("name", name).apply();
                        Intent i = new Intent(this, calcularNota.class);
                        startActivity(i);
                        nameInput.setText("");
                    }
                }
        );
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("colors", MODE_PRIVATE);

        String bgColor = preferences.getString("bgColor", "#FFFFFF");
        String typeColor = preferences.getString("typeColor", "#FFFFFF");
        bg.setBackgroundColor(Color.parseColor(bgColor));
        nameInput.setTextColor(Color.parseColor(typeColor));
        textTv.setTextColor(Color.parseColor(typeColor));
    }

}

