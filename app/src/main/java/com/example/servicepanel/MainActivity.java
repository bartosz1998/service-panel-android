package com.example.servicepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String[][] loginData = {
            {"1","kowalski@essystemk.pl","one"},
            {"2","nowak@essystemk.pl","two"},
    };

     @SuppressLint("SetTextI18n")
     public void onRegisterBtnClick (View view){

         TextView txtLogin = findViewById(R.id.textView);
        TextView txtPassword = findViewById(R.id.textView2);

         //String login = "";
         String password = "one";

         EditText edtTxtLogin = findViewById(R.id.editTextLogin);
         EditText edtTxtPassword = findViewById(R.id.editTextPassword);


         String login = edtTxtLogin.getText().toString();
         password = edtTxtPassword.getText().toString();

         txtPassword.setText(login);

         for(int i = 0; i < loginData.length; i++){
             if(login.equals(loginData[i][1])){
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                break;
             }else{
                txtLogin.setText("Wpisz poprawny login lub haslo");
             }
         }
//             if(Objects.equals(loginData[i][1], login) && Objects.equals(loginData[i][2], password)){
//                     Intent intent = new Intent(MainActivity.this,MainActivity2.class);
//                     startActivity(intent);
//             }
         }
}
