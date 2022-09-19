package com.example.mbsconnects.navigation_fragments;

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

import com.example.mbsconnects.Adapter.homework_Adapter;
import com.example.mbsconnects.HelperClass.AssigmentData;
import com.example.mbsconnects.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class homework_fragment extends Fragment {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<AssigmentData> list;
    private homework_Adapter adapter;
    private DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_homework_fragment, container, false);



        recyclerView = view.findViewById(R.id.book_recyclerview);
        progressBar = view.findViewById(R.id.book_progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        reference = FirebaseDatabase.getInstance().getReference().child("Home-Work");

        getHomework();

        return view;
    }
    private void getHomework() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<AssigmentData>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    AssigmentData data = snapshot1.getValue(AssigmentData.class);
                    list.add(0,data);
                }
                adapter = new homework_Adapter(getContext(), list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error! " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
    }


}