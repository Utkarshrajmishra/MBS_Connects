package com.example.mbsconnects.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbsconnects.HelperClass.AssigmentData;
import com.example.mbsconnects.R;

import java.util.List;

public class Assignemt_Adapter extends RecyclerView.Adapter<Assignemt_Adapter.AssigmentViewHolder> {


    public Assignemt_Adapter(Context context, List<AssigmentData> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<AssigmentData> list;

    @NonNull
    @Override
    public Assignemt_Adapter.AssigmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.assignment_item_layout, parent, false);

        return new Assignemt_Adapter.AssigmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Assignemt_Adapter.AssigmentViewHolder holder, int position) {

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

    public class AssigmentViewHolder extends RecyclerView.ViewHolder {

        private TextView title,time,date;
        private Button download;


        public AssigmentViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.assignment_title);
            time=itemView.findViewById(R.id.assignment_time);
            date=itemView.findViewById(R.id.assignment_date);
            download=itemView.findViewById(R.id.assignment_download_btn);

        }
    }
}
