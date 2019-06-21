package com.example.practice;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    EditText txtemail,txtpass;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtemail = (EditText) findViewById(R.id.txtemail);
        txtpass = (EditText) findViewById(R.id.txtpass);

        DatabaseHelper db = new DatabaseHelper(this);

        String s1 = txtemail.getText().toString();

        Cursor results = db.viewData(s1);

        if(results.moveToFirst()){
            txtemail.setText(results.getString(0));
            txtpass.setText(results.getString(1));
        }

    }
}
