package com.example.snwak_000.ghn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class LogInActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private TextView forgotPswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        /*
        Assigning Variable ID
         */
        username = (EditText) findViewById(R.id.usernameLogIn);
        password = (EditText) findViewById(R.id.passwordLogIn);
        login = (Button) findViewById(R.id.loginButton2);
        forgotPswd = (TextView) findViewById(R.id.forgotPassword);
    }
}
