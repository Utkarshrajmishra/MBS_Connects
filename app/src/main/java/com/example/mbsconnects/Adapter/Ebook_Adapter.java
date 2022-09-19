package com.example.mbsconnects.Adapter;

import android.app.DownloadManager;
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

import com.example.mbsconnects.HelperClass.EbookData;
import com.example.mbsconnects.R;

import java.util.ArrayList;
import java.util.List;

public class Ebook_Adapter extends RecyclerView.Adapter<Ebook_Adapter.EbookViewHolder> {

    public Ebook_Adapter(Context context, List<EbookData> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<EbookData> list;

    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout, parent, false);

        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder, int position) {


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

    public void FilteredList(ArrayList<EbookData> filterlist) {
        list=filterlist;
        notifyDataSetChanged();
    }

    public class EbookViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private Button download;

        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.book_title);
            download=itemView.findViewById(R.id.book_download_btn);
        }
    }
}
