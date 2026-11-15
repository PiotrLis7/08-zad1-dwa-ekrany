package com.example.dwa_ekrany;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;
    Button btnNext;

    ActivityResultLauncher<Intent> summaryLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnNext = findViewById(R.id.btnNext);

        summaryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String message = result.getData().getStringExtra(
                                SummaryActivity.EXTRA_RESULT
                        );

                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                    }
                }
        );

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);

            intent.putExtra(SummaryActivity.EXTRA_NAME,
                    etName.getText().toString());

            intent.putExtra(SummaryActivity.EXTRA_EMAIL,
                    etEmail.getText().toString());

            summaryLauncher.launch(intent);
        });
    }
}