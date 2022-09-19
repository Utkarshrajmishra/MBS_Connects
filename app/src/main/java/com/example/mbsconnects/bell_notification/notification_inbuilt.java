package com.example.mbsconnects.bell_notification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mbsconnects.Adapter.notify_Adapter;
import com.example.mbsconnects.HelperClass.notify_data;
import com.example.mbsconnects.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class notification_inbuilt extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<notify_data> list;
    private notify_Adapter adapter;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_inbuilt);


        recyclerView = findViewById(R.id.notify_recyclerview);
        progressBar = findViewById(R.id.notify_progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        reference = FirebaseDatabase.getInstance().getReference().child("app_notification");

        getNotify();
    }

    private void getNotify() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<notify_data>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    notify_data data = snapshot1.getValue(notify_data.class);
                    list.add(0, data);
                }
                adapter = new notify_Adapter(notification_inbuilt.this, list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(notification_inbuilt.this, "Error! " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });

    }
}

