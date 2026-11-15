package com.example.dwa_ekrany;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.dwa_ekrany.NAME";
    public static final String EXTRA_EMAIL = "com.example.dwa_ekrany.EMAIL";

    TextView tvSummary;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvSummary = findViewById(R.id.tvSummary);
        btnBack = findViewById(R.id.btnBack);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String email = getIntent().getStringExtra(EXTRA_EMAIL);

        tvSummary.setText(
                "Imię i nazwisko: " + name + "\n\n"
                        + "E-mail: " + email
        );

        btnBack.setOnClickListener(v -> finish());
    }
}