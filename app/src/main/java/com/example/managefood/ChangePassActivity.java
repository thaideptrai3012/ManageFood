package com.example.managefood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class ChangePassActivity extends AppCompatActivity {
    EditText oldPassTxt, newPassTxt, xacNhanMatKhauTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        oldPassTxt = findViewById(R.id.oldPassTxt);
        newPassTxt = findViewById(R.id.newPassTxt);
        xacNhanMatKhauTxt = findViewById(R.id.xacNhanMatKhauTxt);
    }
}