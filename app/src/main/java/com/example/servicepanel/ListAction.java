package com.example.servicepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ListAction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_action);

        TextView nameTxt = findViewById(R.id.nameTextView);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");

        nameTxt.setText(name);
    }
}