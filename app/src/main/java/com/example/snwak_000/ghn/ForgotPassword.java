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

import org.w3c.dom.Text;

public class ForgotPassword extends AppCompatActivity {
    TextView message, errorMessage;
    Button go;
    EditText userEmail;
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        message = (TextView)findViewById(R.id.textViewFP1);
        userEmail = (EditText)findViewById(R.id.emailText);
        go = (Button)findViewById(R.id.goButton);
        errorMessage = (TextView)findViewById(R.id.errorFP1);

        then();
    }

    public void then(){
        userEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                userEmail.setBackground(getDrawable(R.drawable.text_border_valid));
            }

            @Override
            public void afterTextChanged(Editable editable) {
                email = userEmail.getText().toString();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.isEmpty()){
                    errorMessage.setText("Enter a valid email address");
                    userEmail.setBackground(getDrawable(R.drawable.text_border_error));
                    return;
                }
                next();
            }
        });
    }

    public void next(){
        Intent intent = new Intent(this, ForgotPassword2.class);
        intent.putExtra("userEmail", email);
        startActivity(intent);
    }
}
