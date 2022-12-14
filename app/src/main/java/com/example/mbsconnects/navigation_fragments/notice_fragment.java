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

import com.example.mbsconnects.Adapter.Notice_Adapter;
import com.example.mbsconnects.HelperClass.NoticeData;
import com.example.mbsconnects.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class notice_fragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<NoticeData> list;
    private Notice_Adapter adapter;
    private DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_notice_fragment, container, false);

        recyclerView=view.findViewById(R.id.deletenotice_recyclerview);
        progressBar=view.findViewById(R.id.deletenotice_progressBar);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        reference= FirebaseDatabase.getInstance().getReference().child("Notice");

        getNotice();

        return view;
    }

    private void getNotice() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for(DataSnapshot dataSnapshot:snapshot.getChildren())

                {
                    NoticeData data=dataSnapshot.getValue(NoticeData.class);
                    list.add(0,data);
                }
                adapter=new Notice_Adapter(getContext(),list);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(adapter);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error! "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}