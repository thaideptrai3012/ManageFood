package com.example.managefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private Button buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        buttonSignup = findViewById(R.id.buttonSignup);

        buttonSignup.setOnClickListener(v -> {
            Toast.makeText(SignupActivity.this,
                    "Create Successful!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivityForResult(intent, 0);

        });

    }
}