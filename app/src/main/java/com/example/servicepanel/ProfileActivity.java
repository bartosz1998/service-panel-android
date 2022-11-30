package com.example.servicepanel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        TextView nameTxt = findViewById(R.id.nameTextView);
        String username = "Username not set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("username");
        }

        nameTxt.setText(username);
    }
}
