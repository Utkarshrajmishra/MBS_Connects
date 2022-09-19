package com.example.mbsconnects.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbsconnects.HelperClass.AssigmentData;
import com.example.mbsconnects.HelperClass.EbookData;
import com.example.mbsconnects.R;

import java.util.ArrayList;
import java.util.List;

public class homework_Adapter extends RecyclerView.Adapter<homework_Adapter.HomeworkViewHolder> {

    public homework_Adapter(Context context, List<AssigmentData> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<AssigmentData> list;

    @NonNull
    @Override
    public homework_Adapter.HomeworkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homework_item_layout, parent, false);

        return new HomeworkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull homework_Adapter.HomeworkViewHolder holder, int position) {

        holder.title.setText(list.get(position).getPdfTitle());
        holder.date.setText(list.get(position).getDate());
        holder.time.setText(list.get(position).getTime());
        String stu=list.get(position).getPdfUrl();
        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(stu));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeworkViewHolder extends RecyclerView.ViewHolder {

        private TextView title,time,date;
        private Button download;

        public HomeworkViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.homework_title);
            download=itemView.findViewById(R.id.download_btn);
            time=itemView.findViewById(R.id.time);
            date=itemView.findViewById(R.id.date);


        }
    }


    }


