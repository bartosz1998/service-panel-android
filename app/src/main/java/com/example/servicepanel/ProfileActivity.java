package com.example.servicepanel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private ArrayList<ValueData> valueDataList;
    private ArrayList<User> usersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        TextView nameTextId = findViewById(R.id.nameTextId);
        TextView nameTextEvent = findViewById(R.id.nameTextEvent);
        TextView nameTextStatus = findViewById(R.id.nameTextStatus);
        TextView nameTextObject = findViewById(R.id.nameTextObject);

        String username = "Username not set";
        String nameEvent = " ";
        String nameObject = " ";
        String nameStatus = " ";

        valueDataList = new ArrayList<>();

        setValueData();

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("id");
            nameEvent= extras.getString("name");
            nameObject = extras.getString("object");
            nameStatus = extras.getString("status");

        }

        nameTextId.setText(username);
        nameTextEvent.setText(nameEvent);
        nameTextObject.setText(nameObject);
        nameTextStatus.setText(nameStatus);

        findViewById(R.id.buttonDelete).setOnClickListener(view -> {
            //usersList.remove();
            Intent intent = new Intent(this,Add_Event.class);
            startActivity(intent);
        });
    }

    private void setValueData(){
        valueDataList.add(new ValueData("Kraków ul. Jana Pawła II","20.11.2022","20.10.2022"));
        valueDataList.add(new ValueData("Kraków ul. Jana Pawła II","20.11.2022","20.10.2022"));
        valueDataList.add(new ValueData("Kraków ul. Jana Pawła II","20.11.2022","20.10.2022"));
    }
}
