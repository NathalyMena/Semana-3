package com.example.calculapromedio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class color extends AppCompatActivity {

    private ConstraintLayout background;
    public Button blueBtn, blackBtn, whiteBtn;
    public TextView tittleGrade, textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configurar_color);

        background = findViewById(R.id.background);
        blueBtn = findViewById(R.id.blueBtn);
        blackBtn = findViewById(R.id.blackBtn);
        whiteBtn = findViewById(R.id.whiteBtn);
        tittleGrade = findViewById(R.id.tittleGrade);
        textName = findViewById(R.id.textName);

        SharedPreferences preferences = getSharedPreferences("colors", MODE_PRIVATE);

        blackBtn.setOnClickListener(

                (v) -> {

                    String black = "#3A3A3A";
                    preferences.edit().putString("bgColor", black).apply();
                    preferences.edit().putString("typeColor", "#FFFFFF").apply();
                    finish();
                }
        );

        whiteBtn.setOnClickListener(

                (v) -> {

                    String white = "#FFFFFF";
                    preferences.edit().putString("bgColor", white).apply();
                    preferences.edit().putString("typeColor", "#808080").apply();
                    finish();
                }
        );

        blueBtn.setOnClickListener(

                (v) -> {

                    String blue = "#3F51B5";
                    preferences.edit().putString("bgColor", blue).apply();
                    preferences.edit().putString("typeColor", "#FFFFFF").apply();
                    finish();
                }
        );



    }

    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("colors", MODE_PRIVATE);

        String bgColor = preferences.getString("bgColor", "#FFFFFF");
        String typeColor = preferences.getString("typeColor", "#FFFFFF");
        background.setBackgroundColor(Color.parseColor(bgColor));
        tittleGrade.setTextColor(Color.parseColor(typeColor));
        textName.setTextColor(Color.parseColor(typeColor));
    }
}


