package com.example.servicepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.servicepanel.db.AppDatabase;
import com.example.servicepanel.db.DataEvent;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText saveNameEvent = findViewById(R.id.saveNameEvent);
        final EditText saveStatusEvent = findViewById(R.id.saveStatusEvent);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(saveNameEvent.getText().toString(), saveStatusEvent.getText().toString());
            }
        });

    }

    private void saveNewUser(String nameEvent, String statusEvent){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        DataEvent dataEvent = new DataEvent();
        dataEvent.eventName = nameEvent;
        dataEvent.object = statusEvent;
        db.userDao().insertUser(dataEvent);

        finish();
    }
}