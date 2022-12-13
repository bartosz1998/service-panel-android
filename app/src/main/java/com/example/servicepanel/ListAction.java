package com.example.servicepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListAction extends AppCompatActivity {

    private ProgressBar circular_pro;
    private TextView status;
    TextView nameEventName, nameObject, nameObjectAddress, nameDateStart, nameDateStop;
    Bundle bundle;
    String name;

    private int progressStatus ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_action);

       nameEventName = findViewById(R.id.textEventName);
       nameObject = findViewById(R.id.textObject);
       nameObjectAddress = findViewById(R.id.textObjectAddress);
       nameDateStart = findViewById(R.id.textDateStart);
       nameDateStop = findViewById(R.id.dateStop);

        bundle = getIntent().getExtras();
        name = bundle.getString("value");

        nameEventName.setText(bundle.getString("event_name"));
        nameObject.setText(bundle.getString("object"));
        nameObjectAddress.setText(bundle.getString("object_address"));
        nameDateStart.setText(bundle.getString("date_start"));
        nameDateStop.setText(bundle.getString("date_stop"));

        circular_pro=(ProgressBar) findViewById(R.id.progressbar_circular);
        status=(TextView) findViewById(R.id.text_status);

        statusEventValue();

    }

    protected void statusEventValue(){

        if(name.equals(getResources().getString(R.string.wait_event))){
            progressStatus = 25;
        }else if(name.equals(getResources().getString(R.string.end_event))){
            progressStatus = 100;
        }else if(name.equals(getResources().getString(R.string.continue_event))){
            progressStatus = 50;
        }else if(name.equals(getResources().getString(R.string.now_event))){
            progressStatus = 75;
        }else{
            progressStatus = 0;
        }

        circular_pro.setProgress(progressStatus);
        status.setText(progressStatus+"%");

    }
}