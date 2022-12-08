package com.example.servicepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListAction extends AppCompatActivity {

    private ProgressBar circular_pro;
    private TextView status;

    private int progressStatus = 50;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_action);

        circular_pro=(ProgressBar) findViewById(R.id.progressbar_circular);
        status=(TextView) findViewById(R.id.text_status);

        circular_pro.setProgress(progressStatus);
        status.setText(progressStatus+"%");
        /*TextView nameTxt = findViewById(R.id.nameTextView);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");

        nameTxt.setText(name);*/
    }
}