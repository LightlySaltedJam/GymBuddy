package com.example.gymbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    CheckBox remember;
    Button login, register;
    User myUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        remember = findViewById(R.id.remember);
        login = findViewById(R.id.loginButton);
        register = findViewById(R.id.registerButton);

        myUser = User.getInstance();

//        AppDatabase ad = AppDatabase.getInstance(this);
//
//        UserDao userDao = ad.userDao();
//        List results = userDao.getAll();
//        Log.d("error", String.valueOf(results.size()));


        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");

        if (checkbox.equals("true")) {
            Intent rememberIntent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(rememberIntent);
        } else if (checkbox.equals("false")) {
            Toast.makeText(this, "Please Sign In", Toast.LENGTH_SHORT).show();
        }

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "GymBuddy will remember that", Toast.LENGTH_SHORT).show();
                } else if (!compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "GymBuddy forgot", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void login(View view) {

        Intent intent = new Intent(this, HomeActivity.class);

//        if(myUser.firstName.isEmpty() || myUser.lastName.isEmpty() || myUser.email.isEmpty() || myUser.username.isEmpty() || myUser.password.isEmpty()) {
//            Toast.makeText(LoginActivity.this, "User not registered", Toast.LENGTH_LONG).show();
//            return;
//        }

//        if (username.getText().toString().equals(myUser.username) && password.getText().toString().equals(myUser.password)) {
        if(username.getText().toString().equals(myUser.username) && password.getText().toString().equals(myUser.password)) {
            //correct password
            startActivity(intent);
            username.getText().clear();
            password.getText().clear();
        } else {
            //wrong password
            username.getText().clear();
            password.getText().clear();
            Toast.makeText(LoginActivity.this, "Incorrect Username of Password", Toast.LENGTH_LONG).show();
        }
    }

    public void signUp(View view) {
        Intent signUpIntent = new Intent(this, SignUpActivity.class);
        startActivity(signUpIntent);
    }
}