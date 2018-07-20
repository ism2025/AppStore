package com.example.ismailamassi.app_store.activity;

import com.example.ismailamassi.app_store.SystemControl.SystemControl;
import com.example.ismailamassi.app_store.SystemControl.Users;
import com.example.ismailamassi.app_store.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login_btn;
    EditText email_ed, password_ed;
    TextView create_account;

    Users admin0 = new Users("admin0", "admin0@mail", "admin0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login_btn = (Button) findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findUser();

            }
        });

        final TextView create_account = findViewById(R.id.create_account);
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });

    }

    public Users findUser() {
        final EditText email_ed = findViewById(R.id.email_ed);
        final EditText password_ed = findViewById(R.id.password_ed);
        Users tmp = null;
        for (Users user : SystemControl.users) {
            if ((email_ed.getText().toString().equals(user.email) || email_ed.getText().toString().equals(user.username)) && password_ed.getText().toString().equals(user.password)) {
                tmp = user;
                break;
            }
        }
        if (tmp != null) {
            Toast toast = Toast.makeText(LoginActivity.this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(LoginActivity.this, "خطأ في إسم المستخدم أو كلمة المرور", Toast.LENGTH_SHORT);
            toast.show();
        }
        return tmp;

    }

}
