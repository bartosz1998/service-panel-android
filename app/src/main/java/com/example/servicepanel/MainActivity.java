package com.example.servicepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRegisterBtnClick (View view){
        TextView txtLogin = findViewById(R.id.textView);
        TextView txtPassword = findViewById(R.id.textView2);

        EditText edtTxtLogin = findViewById(R.id.editTextLogin);
        EditText edtTxtPassword = findViewById(R.id.editTextPassword);

        txtLogin.setText(edtTxtLogin.getText().toString());
        txtPassword.setText(edtTxtPassword.getText().toString());
    }
}