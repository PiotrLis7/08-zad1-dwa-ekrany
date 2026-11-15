package com.example.dwa_ekrany;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);

            intent.putExtra(
                    SummaryActivity.EXTRA_NAME,
                    etName.getText().toString()
            );

            intent.putExtra(
                    SummaryActivity.EXTRA_EMAIL,
                    etEmail.getText().toString()
            );

            startActivity(intent);
        });
    }
}