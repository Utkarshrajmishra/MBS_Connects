package com.example.mbsconnects.navigation_fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mbsconnects.Adapter.Ebook_Adapter;
import com.example.mbsconnects.HelperClass.EbookData;
import com.example.mbsconnects.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class book_fragment extends Fragment {


    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<EbookData> list;
    private Ebook_Adapter adapter;
    private DatabaseReference reference;
    private EditText search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_fragment, container, false);

        search = view.findViewById(R.id.book_search_bar);
        recyclerView = view.findViewById(R.id.book_recyclerview);
        progressBar = view.findViewById(R.id.book_progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        reference = FirebaseDatabase.getInstance().getReference().child("Book");


        getBook();


        return view;
    }

    private void getBook() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    EbookData data = snapshot1.getValue(EbookData.class);
                    list.add(data);
                }
                adapter = new Ebook_Adapter(getContext(), list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                search.setVisibility(View.VISIBLE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error! " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
    }

    private void filter(String toString) {

        ArrayList<EbookData> filterlist = new ArrayList<>();
        for (EbookData items : list) {
            for (EbookData item : list) {
                if (item.getPdfTitle().toLowerCase().contains(toString.toLowerCase())) {
                    filterlist.add(item);
                }

            }
            adapter.FilteredList(filterlist);
        }
    }
}