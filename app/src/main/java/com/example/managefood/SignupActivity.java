package com.example.managefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private Button buttonSignup;
    private EditText llfullname;
    private EditText llphonenumber;
    private EditText llemail;
    private EditText llpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        buttonSignup = findViewById(R.id.buttonSignup);
        llfullname = findViewById(R.id.llfullname);
        llphonenumber = findViewById(R.id.llphonenumber);
        llemail = findViewById(R.id.llemail);
        llpassword = findViewById(R.id.llpassword);


        buttonSignup.setOnClickListener(v -> {
            if (llfullname.getText().toString().isEmpty() || llphonenumber.getText().toString().isEmpty() || llphonenumber.getText().toString().isEmpty() || llemail.getText().toString().isEmpty() || llpassword.getText().toString().isEmpty()) {
                Toast.makeText(SignupActivity.this,
                        "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(SignupActivity.this,
                        "Create Successful!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivityForResult(intent, 0);
                return;
            }
        });

    }
}