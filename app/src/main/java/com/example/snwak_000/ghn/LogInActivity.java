package com.example.snwak_000.ghn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

public class LogInActivity extends AppCompatActivity {
    private EditText user;
    private EditText password;
    private Button login, forgotPswd;
    private TextView errorMessage;
    String userInput, passwordInput, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        /*
        Assigning Variable ID
         */
        user = (EditText) findViewById(R.id.usernameLogIn);
        password = (EditText) findViewById(R.id.passwordLogIn);
        login = (Button) findViewById(R.id.loginButton2);
        forgotPswd = (Button) findViewById(R.id.forgotPassword);
        errorMessage = (TextView) findViewById(R.id.logInErrorMessage);

        then();
    }

    public void then(){
        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                user.setBackground(getDrawable(R.drawable.text_border_valid));
            }

            @Override
            public void afterTextChanged(Editable editable) {
                userInput = user.getText().toString();
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password.setBackground(getDrawable(R.drawable.text_border_valid));
            }

            @Override
            public void afterTextChanged(Editable editable) {
                passwordInput = password.getText().toString();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userInput.isEmpty()){
                    errorMessage.setText("Enter a valid username or email");
                    user.setBackground(getDrawable(R.drawable.text_border_error));
                    return;
                }

                if(passwordInput.isEmpty()){
                    errorMessage.setText("Enter a valid password");
                    password.setBackground(getDrawable(R.drawable.text_border_error));
                    return;
                }

                //confirm with server
                if(verifyLogInDetails()){
                    next = "login";
                    nextActivity(next);
                }else{
                    errorMessage.setText("Details you entered do not match");
                    user.setBackground(getDrawable(R.drawable.text_border_error));
                    password.setBackground(getDrawable(R.drawable.text_border_error));
                    return;
                }

            }
        });

        forgotPswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next = "forgotPassword";
                nextActivity(next);
            }
        });
    }

    //Communicate/verify details with server and return boolean
    public boolean verifyLogInDetails(){
        ////
        return true || false;
    }

    public void nextActivity(String type){
        Intent intent;
        if(type.equalsIgnoreCase("login")) {
            intent = new Intent(this, RegularUserActivity.class);
            startActivity(intent);
        }
        if(type.equalsIgnoreCase("forgotPassword")){
            intent = new Intent(this, ForgotPassword.class);
            startActivity(intent);
        }
    }

}
