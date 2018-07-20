package com.example.ismailamassi.app_store.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismailamassi.app_store.R;
import com.example.ismailamassi.app_store.SystemControl.SystemControl;
import com.example.ismailamassi.app_store.SystemControl.Users;


public class CreateAccountActivity extends AppCompatActivity {
    Button create_account_btn;
    EditText username_ed, email_ed, password_ed;
    TextView current_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Button create_account_btn = findViewById(R.id.create_account_btn);
        TextView current_account = findViewById(R.id.current_account);
        create_account_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create_account();
            }
        });
        current_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    public Users create_account() {
        final EditText username_ed = findViewById(R.id.username_ed);
        final EditText email_ed = findViewById(R.id.email_ed);
        final EditText password_ed = findViewById(R.id.password_ed);

        String username = username_ed.getText().toString();
        String email = username_ed.getText().toString();
        String password = username_ed.getText().toString();

        Users tmp = null;
        for (Users user : SystemControl.users) {
            if ((email.equals(user.email) || username.equals(user.username))) {
                tmp = user;
                Toast toast = Toast.makeText(CreateAccountActivity.this, "هذا المستخدم موجود مسبقاً", Toast.LENGTH_SHORT);
                toast.show();
                break;
            }
        }
        if (tmp == null) {
            if (username.length() < 6) {
                Toast toast = Toast.makeText(CreateAccountActivity.this, "يرجى إدخال إسم مستخدم صحيح", Toast.LENGTH_SHORT);
                toast.show();
            } else if ((email.contains("@") && !email.endsWith(".com") && email.length() >= 10)) {
                Toast toast = Toast.makeText(CreateAccountActivity.this, "يرجى إدخال بريد إلكتروني صحيح", Toast.LENGTH_SHORT);
                toast.show();
            } else if (password.length() >= 6 && password.length() <= 32) {
                Toast toast = Toast.makeText(CreateAccountActivity.this, "يرجى إدخال كلمة مرور صحيحة بين 6 و 32 خانة", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                Users user = new Users(username, email, password);
                tmp = user;
                Toast toast = Toast.makeText(CreateAccountActivity.this, "تم إنشاء الحساب بنجاح", Toast.LENGTH_SHORT);
                toast.show();
            }

        }
        return tmp;
    }
}
