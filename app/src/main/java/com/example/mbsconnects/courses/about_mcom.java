package com.example.mbsconnects.courses;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mbsconnects.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class about_mcom extends Fragment {

    private DatabaseReference reference;
    private TextView fee;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view= inflater.inflate(R.layout.fragment_about_mcom, container, false);

        fee=view.findViewById(R.id.mcom_year_fee);
        reference = FirebaseDatabase.getInstance().getReference().child("fees").child("MCo").child("fee_term1");

        getFee();
     return view;
    }

    private void getFee() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);

                // our value to our text view in below line.
                fee.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error!"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}