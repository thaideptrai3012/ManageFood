package com.example.managefood;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText llfullname;
    private EditText llpassword;
    private EditText llrepassword;

    private TextView buttonforget;
    private TextView buttonSignup;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonforget = findViewById(R.id.buttonforget);
        buttonSignup = findViewById(R.id.butonSignup);
        btnLogin = findViewById(R.id.butonLogin);

        buttonSignup.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent);
        });

        buttonforget.setOnClickListener(v -> {

            showDialog();

        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(x);
            }
        });
    }

    public void showDialog() {

        Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_dialog_forgot);
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);


        llfullname = dialog.findViewById(R.id.llfullname);
        llrepassword = dialog.findViewById(R.id.llrepassword);
        llpassword = dialog.findViewById(R.id.llpassword);

        Button buttonchange = dialog.findViewById(R.id.buttonchange);

        buttonchange.setOnClickListener(v -> {

            if (llfullname.getText().toString().isEmpty() || llrepassword.getText().toString().isEmpty() || llpassword.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "Đổi mật khẩu thành công", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivityForResult(intent, 0);
                return;
            }
        });

        Button buttoncancle = dialog.findViewById(R.id.buttoncancle);
        buttoncancle.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivityForResult(intent, 0);

        });

    }
}