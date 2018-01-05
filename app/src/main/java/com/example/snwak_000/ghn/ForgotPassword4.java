package com.example.snwak_000.ghn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForgotPassword4 extends AppCompatActivity {

    TextView message;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password4);
        message = (TextView)findViewById(R.id.textViewFP4);
        login = (Button)findViewById(R.id.buttonFP4);

        then();
    }

    public void then(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });
    }

    public void next(){
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }
}
