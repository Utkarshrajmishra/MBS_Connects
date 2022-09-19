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

public class Paper_Adapter extends RecyclerView.Adapter<Paper_Adapter.PaperViewHolder> {

    public Paper_Adapter(Context context, List<AssigmentData> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<AssigmentData> list;

    @NonNull
    @Override
    public Paper_Adapter.PaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.paper_item_layout, parent, false);

        return new Paper_Adapter.PaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Paper_Adapter.PaperViewHolder holder, int position) {
        holder.title.setText(list.get(position).getPdfTitle());

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

    public class PaperViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private Button download;
        public PaperViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.paper_title);
            download=itemView.findViewById(R.id.paper_download_btn);
        }
    }
}
