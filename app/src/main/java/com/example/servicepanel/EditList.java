package com.example.servicepanel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.servicepanel.db.AppDatabase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditList extends AppCompatActivity {
    String[] items;
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    String item, dataStart,dataStop, id, textError;
    String txtSaveEventName, txtSaveObject, txtSaveAddressObject, txtAutoComplete,formattedString;
    EditText saveEventName, saveObject, saveAddressObject;
    Button update, stopButton;
    DateTimeFormatter formatter;
    LocalDate valueDateStart;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);

        items = getResources().getStringArray(R.array.list_status);
        textError = getResources().getString(R.string.text_field);

        saveEventName = findViewById(R.id.saveNameEvent);
        saveObject = findViewById(R.id.saveObject);
        saveAddressObject = findViewById(R.id.saveAddressObject);

        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

        update = findViewById(R.id.editButton);
        stopButton = findViewById(R.id.stopButton);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);

        listDataStatus();

        dataStart = getIntent().getExtras().getString("data_start");
        dataStop = getIntent().getExtras().getString("date_stop");
        id = getIntent().getExtras().getString("id");

        dateActual();

        updateButtonAction();
        stopActionButton();
    }

    protected void listDataStatus(){
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
            }
        });
    }

    protected void updateButtonAction(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonActivity(dataStop);
            }
        });
    }

    protected void stopActionButton(){
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonActivity(formattedString);
            }
        });
    }

    protected void buttonActivity(String dataValueStop) {
        txtSaveEventName = saveEventName.getText().toString().trim();
        txtSaveObject = saveObject.getText().toString().trim();
        txtSaveAddressObject = saveAddressObject.getText().toString().trim();
        txtAutoComplete = autoCompleteTxt.getText().toString().trim();

        if (txtSaveEventName.equals("") || txtSaveObject.equals("") || txtSaveAddressObject.equals("")) {
            Toast.makeText(EditList.this, textError, Toast.LENGTH_SHORT).show();
        } else{
            AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());
            db.userDao().updateData(txtSaveEventName,txtSaveObject,txtSaveAddressObject,txtAutoComplete,dataStart,dataValueStop, Integer.parseInt(id));

            Intent intent = new Intent(EditList.this,ListActivity.class);
            startActivity(intent);
    }}

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void dateActual(){
        valueDateStart = LocalDate.now();
        formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        formattedString = valueDateStart.format(formatter);
    }
}