 package com.example.mbsconnects.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mbsconnects.Adapter.Assignemt_Adapter;
import com.example.mbsconnects.HelperClass.AssigmentData;
import com.example.mbsconnects.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

 public class assignment_activity extends AppCompatActivity {

     private RecyclerView recyclerView;
     private ProgressBar progressBar;
     private ArrayList<AssigmentData> list;
     private Assignemt_Adapter adapter;
     private DatabaseReference reference;
     String stu;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_assignment);

         stu=getIntent().getStringExtra("assignment_type");

         recyclerView = findViewById(R.id.assignment_recyclerview);
         progressBar = findViewById(R.id.assignment_progressBar);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
         recyclerView.setHasFixedSize(true);
         reference = FirebaseDatabase.getInstance().getReference().child(stu);

         getHomework();


     }

     private void getHomework() {
         reference.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {
                 list = new ArrayList<AssigmentData>();
                 for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                     AssigmentData data = snapshot1.getValue(AssigmentData.class);
                     list.add(0, data);
                 }
                 adapter = new Assignemt_Adapter(assignment_activity.this, list);
                 recyclerView.setAdapter(adapter);
                 adapter.notifyDataSetChanged();
                 progressBar.setVisibility(View.GONE);


             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {
                 Toast.makeText(assignment_activity.this, "Error! " + error.getMessage(), Toast.LENGTH_SHORT).show();
             }


         });
     }
 }
