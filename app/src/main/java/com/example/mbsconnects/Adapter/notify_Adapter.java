package com.example.mbsconnects.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbsconnects.HelperClass.AssigmentData;
import com.example.mbsconnects.HelperClass.notify_data;
import com.example.mbsconnects.R;

import java.util.List;

public class notify_Adapter extends RecyclerView.Adapter<notify_Adapter.notifyViewHolder> {
    public notify_Adapter(Context context, List<notify_data> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<notify_data> list;
    @NonNull
    @Override
    public notify_Adapter.notifyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notify_item_layout, parent, false);

        return new notify_Adapter.notifyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull notify_Adapter.notifyViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.time.setText(list.get(position).getTime());
        holder.body.setText(list.get(position).getBody());
        holder.date.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class notifyViewHolder extends RecyclerView.ViewHolder {
        private TextView title,body,time,date;
        public notifyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.notify_title);
            body=itemView.findViewById(R.id.notify_body);
            time=itemView.findViewById(R.id.notify_time);
            date=itemView.findViewById(R.id.notify_date);
        }
    }
}
