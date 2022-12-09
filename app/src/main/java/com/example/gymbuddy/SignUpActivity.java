package com.example.gymbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText firstName, lastName, email, username, password;
    Button register, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        username = findViewById(R.id.usernameRegister);
        password = findViewById(R.id.passwordRegister);
        register = findViewById(R.id.registerButton);
        cancel = findViewById(R.id.cancelButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(cancel);
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(firstName)) {
            firstName.setError("First name required!");
        }
        if (isEmpty(lastName)) {
            lastName.setError("Last name required!");
        }
        if (isEmpty(email)) {
            email.setError("Email required!");
        }
        if (isEmpty(username)) {
            username.setError("Username required!");
        }
        if (isEmpty(password)) {
            password.setError("Password required!");
        }
    }
}