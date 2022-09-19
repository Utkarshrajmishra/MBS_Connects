package com.example.mbsconnects.courses;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mbsconnects.Adapter.teacher_adaptor;
import com.example.mbsconnects.HelperClass.teacher_Data;
import com.example.mbsconnects.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class bcom_faculty extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<teacher_Data> list;
    private teacher_adaptor adapter;
    private DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_bcom_faculty, container, false);


        recyclerView =view.findViewById(R.id.bcom_recycler);
        progressBar = view.findViewById(R.id.bcom_progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        reference = FirebaseDatabase.getInstance().getReference().child("teacher").child("BCom");

        showTeacher();

        return view;
    }

    private void showTeacher() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    teacher_Data data = snapshot1.getValue(teacher_Data.class);
                    list.add(data);
                }
                adapter = new teacher_adaptor( getContext(), list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error! "+ error.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });



    }
}