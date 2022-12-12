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
    String[] items = {"OCZEKUJE NA REALIZACJE","ZAKOŃCZONO","BĘDZIE KONTYNUOWANE","W TRAKCIE"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);

        EditText saveEventName = findViewById(R.id.saveNameEvent);
        EditText saveObject = findViewById(R.id.saveObject);
        EditText saveAddressObject = findViewById(R.id.saveAddressObject);
        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
        Button update = findViewById(R.id.editButton);
        Button stopButton = findViewById(R.id.stopButton);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
            }
        });

        String dataStart = getIntent().getExtras().getString("data_start");
        String dataStop = getIntent().getExtras().getString("date_stop");
        String id = getIntent().getExtras().getString("id");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtSaveEventName = saveEventName.getText().toString().trim();
                String txtSaveObject = saveObject.getText().toString().trim();
                String txtSaveAddressObject = saveAddressObject.getText().toString().trim();
                String txtAutoComplete = autoCompleteTxt.getText().toString().trim();

                if(txtSaveEventName.equals("") || txtSaveObject.equals("") || txtSaveAddressObject.equals("")){
                    Toast.makeText(EditList.this, "All Field is required ...", Toast.LENGTH_SHORT).show();
                }else{
                    AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());

                    db.userDao().updateData(txtSaveEventName,txtSaveObject,txtSaveAddressObject,txtAutoComplete,dataStart,dataStop, Integer.parseInt(id));

                    Intent intent = new Intent(EditList.this,ListActivity.class);
                    startActivity(intent);
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String txtSaveEventName = saveEventName.getText().toString().trim();
                String txtSaveObject = saveObject.getText().toString().trim();
                String txtSaveAddressObject = saveAddressObject.getText().toString().trim();
                String txtAutoComplete = autoCompleteTxt.getText().toString().trim();

                LocalDate valueDateStart = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                String formattedString = valueDateStart.format(formatter);

                if(txtSaveEventName.equals("") || txtSaveObject.equals("") || txtSaveAddressObject.equals("")){
                    AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());
                    int idStop = Integer.parseInt(id);
                    db.userDao().updateDateStop(formattedString,idStop);

                    Intent intent = new Intent(EditList.this,ListActivity.class);
                    startActivity(intent);
                }else{
                    AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());

                    db.userDao().updateData(txtSaveEventName,txtSaveObject,txtSaveAddressObject,txtAutoComplete,dataStart,dataStop, Integer.parseInt(id));

                    Intent intent = new Intent(EditList.this,ListActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}