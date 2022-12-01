package com.example.servicepanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private ArrayList<User> usersList;
    private RecyclerView recyclerView;
    private recyclerAdapter.RecyclerViewClickListener listener;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.tabeleView);
        usersList = new ArrayList<>();

        setUserInfo();
        setAdapter();

        findViewById(R.id.add).setOnClickListener(view -> {
            //usersList.add(new User("1","Żabka","oczekiwanie","warszawa"));
            //adapter.notifyItemRemoved(usersList.size()-1);
            Intent intent = new Intent(this,Add_Event.class);
            startActivity(intent);
        });
    }

    private void setAdapter(){
        setOnClickListener();
        recyclerAdapter adapter = new recyclerAdapter(usersList,listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


    }

    private void setOnClickListener() {
        listener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("id", usersList.get(position).getId());
                intent.putExtra("name", usersList.get(position).getName());
                intent.putExtra("object", usersList.get(position).getObject());
                intent.putExtra("status", usersList.get(position).getStatus());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo(){
        usersList.add(new User("1","Żabka","Zakończono","kraków"));
        usersList.add(new User("2","Auchan","W trakcie","Warszawa"));
        usersList.add(new User("3","Auchan","Oczekiwanie","Sosnowiec"));
    }
}