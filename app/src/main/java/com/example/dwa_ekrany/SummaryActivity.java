package com.example.dwa_ekrany;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.dwa_ekrany.NAME";
    public static final String EXTRA_EMAIL = "com.example.dwa_ekrany.EMAIL";
    public static final String EXTRA_RESULT = "com.example.dwa_ekrany.RESULT";

    TextView tvSummary;
    Button btnBack, btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvSummary = findViewById(R.id.tvSummary);
        btnBack = findViewById(R.id.btnBack);
        btnAccept = findViewById(R.id.btnAccept);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String email = getIntent().getStringExtra(EXTRA_EMAIL);

        tvSummary.setText(
                "Imię i nazwisko: " + name + "\n\n"
                        + "E-mail: " + email
        );

        btnBack.setOnClickListener(v -> finish());

        btnAccept.setOnClickListener(v -> {
            Intent result = new Intent();
            result.putExtra(EXTRA_RESULT, "Zgłoszenie zostało zatwierdzone");

            setResult(RESULT_OK, result);
            finish();
        });
    }
}