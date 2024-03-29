package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1, e2;
    Button b1;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean chkemailpass = db.emailpassword(email, password);
                if (chkemailpass == true) {
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                    Intent j = new Intent(Login.this, Home.class);
                    startActivity(j);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                }

                EmptyEditTextAfterDataInsert();
            }
        });

    }

    public void EmptyEditTextAfterDataInsert() {

        e1.getText().clear();

        e2.getText().clear();
    }
}
