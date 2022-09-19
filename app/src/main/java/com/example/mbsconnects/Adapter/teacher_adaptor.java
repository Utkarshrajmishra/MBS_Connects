package com.example.mbsconnects.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbsconnects.HelperClass.teacher_Data;
import com.example.mbsconnects.R;

import com.example.mbsconnects.courses.bca;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class teacher_adaptor extends RecyclerView.Adapter<teacher_adaptor.teacherviewadapoter> {
    private List<teacher_Data> list;
    private Context context;


    public teacher_adaptor(Context context, ArrayList<teacher_Data> list) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public teacherviewadapoter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.teacher_item_layout,parent, false);
        return new teacherviewadapoter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull teacherviewadapoter holder, int position) {
        teacher_Data item=list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());

        try {
            Picasso.get().load(item.getImage()).into(holder.image);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class teacherviewadapoter extends RecyclerView.ViewHolder {

        private TextView name,email;

        private ImageView image;

        public teacherviewadapoter(@NonNull View itemView) {
            super(itemView);

            name=(TextView) itemView.findViewById(R.id.teacheranme);
            email=(TextView) itemView.findViewById(R.id.teacheremail2);
            image=itemView.findViewById(R.id.teacherphoto2);

        }
    }
}
