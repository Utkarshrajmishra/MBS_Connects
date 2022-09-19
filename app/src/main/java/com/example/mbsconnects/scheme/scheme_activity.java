package com.example.mbsconnects.scheme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mbsconnects.Adapter.Scheme_Adapter;
import com.example.mbsconnects.HelperClass.schemeData;
import com.example.mbsconnects.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class scheme_activity extends AppCompatActivity {

    String timetable;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<schemeData> list;
    private Scheme_Adapter adapter;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);

        timetable=getIntent().getStringExtra("parent");
        timetable=timetable.toString();
        recyclerView = findViewById(R.id.scheme_recyclerview);
        progressBar = findViewById(R.id.scheme_progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        reference = FirebaseDatabase.getInstance().getReference().child(timetable);

        getScheme();
    }

    private void getScheme() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    schemeData data = snapshot1.getValue(schemeData.class);
                    list.add(0,data);
                }
                adapter = new Scheme_Adapter( scheme_activity.this, list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(scheme_activity.this, "Error! " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
    }
}