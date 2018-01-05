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

public class ForgotPassword3 extends AppCompatActivity {
    TextView message, alertMessage;
    EditText password1, password2;
    Button go3;
    String p1, p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password3);
        message = (TextView)findViewById(R.id.textViewFP3);
        alertMessage = (TextView)findViewById(R.id.textView2FP3);
        password1 = (EditText)findViewById(R.id.password1FP3);
        password2 = (EditText)findViewById(R.id.password2FP3);
        go3 = (Button)findViewById(R.id.buttonFP3);

        then();
    }

    public void then(){
       password1.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password1.setBackground(getDrawable(R.drawable.text_border_valid));
           }

           @Override
           public void afterTextChanged(Editable editable) {

               p1 = password1.getText().toString();
           }
       });

        password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password2.setBackground(getDrawable(R.drawable.text_border_valid));
            }

            @Override
            public void afterTextChanged(Editable editable) {

                p2 = password2.getText().toString();
            }
        });

        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p1.isEmpty() || p2.isEmpty()){
                    alertMessage.setText("Fill in the necessary fields");
                    password2.setBackground(getDrawable(R.drawable.text_border_error));
                    password1.setBackground(getDrawable(R.drawable.text_border_error));
                    return;
                }

                if(p1.equalsIgnoreCase(p2)){
                    alertMessage.setText("passwords match");


                    //code to send info to server


                    next();
                }else{
                    alertMessage.setText("passwords do not match");
                    password2.setBackground(getDrawable(R.drawable.text_border_error));
                    password1.setBackground(getDrawable(R.drawable.text_border_error));
                    return;
                }
            }
        });
    }

    public void next(){
        Intent intent = new Intent(this, ForgotPassword4.class);
        startActivity(intent);
    }
}
