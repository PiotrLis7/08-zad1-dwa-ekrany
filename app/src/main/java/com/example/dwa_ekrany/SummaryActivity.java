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
    Button btnBack, btnAccept, btnShare;

    String summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvSummary = findViewById(R.id.tvSummary);
        btnBack = findViewById(R.id.btnBack);
        btnAccept = findViewById(R.id.btnAccept);
        btnShare = findViewById(R.id.btnShare);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String email = getIntent().getStringExtra(EXTRA_EMAIL);

        summary = "Imię i nazwisko: " + name + "\n\n"
                + "E-mail: " + email;

        tvSummary.setText(summary);

        btnBack.setOnClickListener(v -> finish());

        btnAccept.setOnClickListener(v -> {
            Intent result = new Intent();
            result.putExtra(EXTRA_RESULT, "Zgłoszenie zostało zatwierdzone");

            setResult(RESULT_OK, result);
            finish();
        });

        btnShare.setOnClickListener(v -> shareSummary());
    }

    private void shareSummary() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, summary);

        startActivity(Intent.createChooser(intent, "Udostępnij podsumowanie"));
    }
}