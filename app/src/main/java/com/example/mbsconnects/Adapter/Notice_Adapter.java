package com.example.mbsconnects.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbsconnects.HelperClass.NoticeData;
import com.example.mbsconnects.R;



import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Notice_Adapter extends RecyclerView.Adapter<Notice_Adapter.NoticeViewAdapter> {

    private Context context;
    private ArrayList<NoticeData> list;

    public Notice_Adapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notice_itemfeed, parent, false);

        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {

        NoticeData currentItem = list.get(position);
        holder.title_notice.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getData());
        holder.time.setText(currentItem.getTime());


        try {
            if (currentItem.getImage() != null)
                Picasso.get().load(currentItem.getImage()).into(holder.image_notice);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {

        private TextView title_notice, date, time;
        private ImageView image_notice;

        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.notice_date);
            time = itemView.findViewById(R.id.notice_time);
            title_notice = itemView.findViewById(R.id._notice_title);
            image_notice = itemView.findViewById(R.id._notice_image);
        }
    }
}
