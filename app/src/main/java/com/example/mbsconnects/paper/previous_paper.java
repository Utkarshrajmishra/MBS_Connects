package com.example.mbsconnects.paper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mbsconnects.Adapter.Paper_Adapter;
import com.example.mbsconnects.HelperClass.AssigmentData;
import com.example.mbsconnects.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class previous_paper extends AppCompatActivity {

    String timetable;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<AssigmentData> list;
    private Paper_Adapter adapter;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_paper);

        timetable=getIntent().getStringExtra("paper_type");

        recyclerView = findViewById(R.id.paper_recyclerview);
        progressBar = findViewById(R.id.paper_progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        reference = FirebaseDatabase.getInstance().getReference().child(timetable);

        getPaper();
    }

    private void getPaper() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<AssigmentData>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    AssigmentData data = snapshot1.getValue(AssigmentData.class);
                    list.add(0,data);
                }
                adapter = new Paper_Adapter( previous_paper.this, list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(previous_paper.this, "Error! " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
    }
}