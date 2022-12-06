package com.example.servicepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.servicepanel.db.AppDatabase;
import com.example.servicepanel.db.DataEvent;

public class AddNewUserActivity extends AppCompatActivity {

    String[] items = {"OCZEKUJE NA REALIZACJE","ZAKOŃCZONO","BĘDZIE KONTYNUOWANE","W TRAKCIE"};

    AutoCompleteTextView autoCompleteTxt;

    ArrayAdapter<String> adapterItems;

    String item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText saveNameEvent = findViewById(R.id.saveNameEvent);
        final EditText saveStatusEvent = findViewById(R.id.saveStatusEvent);

        Button saveButton = findViewById(R.id.saveButton);

        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);

        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 item = parent.getItemAtPosition(position).toString();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(saveNameEvent.getText().toString(), item);
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