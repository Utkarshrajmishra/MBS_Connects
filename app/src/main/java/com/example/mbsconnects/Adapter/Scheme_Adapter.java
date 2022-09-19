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

import com.example.mbsconnects.HelperClass.schemeData;
import com.example.mbsconnects.R;

import java.util.List;

public class Scheme_Adapter extends RecyclerView.Adapter<Scheme_Adapter.schemeViewHolder> {

    public Scheme_Adapter(Context context, List<schemeData> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<schemeData> list;

    @NonNull
    @Override
    public Scheme_Adapter.schemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.scheme_item_layout, parent, false);

        return new Scheme_Adapter.schemeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Scheme_Adapter.schemeViewHolder holder, int position) {
            holder.title.setText(list.get(position).getPdfTitle());
            holder.date.setText(list.get(position).getDate());
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

    public class schemeViewHolder extends RecyclerView.ViewHolder {
        private TextView title,date;
        private Button download;
        public schemeViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.scheme_title);
            date=itemView.findViewById(R.id.scheme_date);
            download= itemView.findViewById(R.id.download_btn_scheme);
        }
    }
}
