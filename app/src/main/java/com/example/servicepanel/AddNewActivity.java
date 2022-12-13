package com.example.servicepanel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.servicepanel.db.AppDatabase;
import com.example.servicepanel.db.DataEvent;

public class AddNewActivity extends AppCompatActivity {

    String[] items;

    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    String item;

    EditText saveNameEvent, saveObject, saveAddressObject;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        items = getResources().getStringArray(R.array.list_status);

        saveNameEvent = findViewById(R.id.saveNameEvent);
        saveObject = findViewById(R.id.saveObject);
        saveAddressObject = findViewById(R.id.saveAddressObject);

        saveButton = findViewById(R.id.saveButton);

        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);

       listNameEvent();
       saveDataButton();
    }

    protected  void saveDataButton(){
        saveButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                LocalDate valueDateStart = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                String formattedString = valueDateStart.format(formatter);
                String dateStop = "Nie określono";

                saveNewUser(saveNameEvent.getText().toString(), item,saveObject.getText().toString(),saveAddressObject.getText().toString(), formattedString,dateStop);
            }
        });
    }

    protected void listNameEvent(){
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
            }
        });
    }

    private void saveNewUser(String nameEvent, String statusEvent, String object, String addressObject,String DateStart,String DateStop){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        DataEvent dataEvent = new DataEvent();
        dataEvent.eventName = nameEvent;
        dataEvent.statusEvent = statusEvent;
        dataEvent.object = object;
        dataEvent.objectAddress = addressObject;
        dataEvent.dateStart = DateStart;
        dataEvent.dateStop = DateStop;
        db.userDao().insert(dataEvent);

        finish();
    }
}