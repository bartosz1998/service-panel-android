package com.example.servicepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListAction extends AppCompatActivity {

    private ProgressBar circular_pro;
    private TextView status;

    private int progressStatus ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_action);



       TextView nameTxt = findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("value");

        switch(name){
            case "OCZEKUJE NA REALIZACJE":
                progressStatus = 25;
                break;
            case "ZAKOŃCZONO":
                progressStatus = 100;
                break;
            case "BĘDZIE KONTYNUOWANE":
                progressStatus = 50;
                break;
            case "W TRAKCIE":
                progressStatus = 75;
                break;
        }

        nameTxt.setText(name);


        circular_pro=(ProgressBar) findViewById(R.id.progressbar_circular);
        status=(TextView) findViewById(R.id.text_status);

        circular_pro.setProgress(progressStatus);
        status.setText(progressStatus+"%");
    }

}