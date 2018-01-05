package com.example.snwak_000.ghn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPassword2 extends AppCompatActivity {
    TextView message;
    String email;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password2);
        message = (TextView)findViewById(R.id.textViewFP2);
        email = getIntent().getExtras().getString("userEmail");     //email from last activity
        ok = (Button)findViewById(R.id.tempOK);
        message.setText("link to reset password has been sent to "+ email + " follow the link to create new password");

        then();
    }

    public void then() {
        //replace with code for Reset email link

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });

    }

    public void nextActivity(){
        Intent intent = new Intent(this, ForgotPassword3.class);
        startActivity(intent);
    }
}
