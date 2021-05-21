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
    private EditText llemail;
    private EditText llpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        buttonSignup = findViewById(R.id.buttonSignup);
        llfullname = findViewById(R.id.llfullname);
        llemail = findViewById(R.id.llemail);
        llpassword = findViewById(R.id.llpassword);


        buttonSignup.setOnClickListener(v -> {
            if (llfullname.getText().toString().isEmpty() || llemail.getText().toString().isEmpty() || llpassword.getText().toString().isEmpty()) {
                Toast.makeText(SignupActivity.this,
                        "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(SignupActivity.this,
                        "Đăng ký thành công!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivityForResult(intent, 0);
                return;
            }
        });

    }
}