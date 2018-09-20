package com.advinity.carbonteam.hydrocarbon.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.activity.EbookDetailsActivity;
import com.advinity.carbonteam.hydrocarbon.modal.Ebook;

import java.util.List;

/**
 * Created by afdolash on 02/12/16.
 */

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.MyViewHolder> {

    private Context mContext;
    private List<Ebook> ebookList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, subtitle;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.title);
            subtitle = (TextView)itemView.findViewById(R.id.subtitle);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            overflow = (ImageView) itemView.findViewById(R.id.overflow);
        }
    }

    public EbookAdapter(Context mContext, List<Ebook> ebookList) {
        this.mContext = mContext;
        this.ebookList = ebookList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ebook, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Ebook ebook = ebookList.get(position);
        holder.title.setText(ebook.getTitle());
        holder.subtitle.setText(ebook.getWriter());

        holder.thumbnail.setImageResource(ebook.getThumbnail());
        //Glide.with(mContext).load(ebook.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.overflow, ebook.getUrl());
            }
        });

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, ebook.getTitle()+ " is selected!", Toast.LENGTH_SHORT).show();

                // Send the data to other activity here
                Intent intent = new Intent(mContext, EbookDetailsActivity.class);
                intent.putExtra("title", ebook.getTitle());
                intent.putExtra("subtitle", ebook.getSubtitle());
                intent.putExtra("image", ebook.getImage());
                intent.putExtra("writer", ebook.getWriter());
                intent.putExtra("edition", ebook.getEdition());
                intent.putExtra("year", ebook.getYear());
                intent.putExtra("description", ebook.getDescription());
                intent.putExtra("url", ebook.getUrl());

                mContext.startActivity(intent);
            }
        });
    }

    private void showPopupMenu(View view, final String fileUrl) {
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();

        inflater.inflate(R.menu.menu_ebook, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ebook_download :
                        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
                        pdfIntent.setDataAndType(Uri.parse(fileUrl), "application/pdf");
                        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        try {
                            mContext.startActivity(pdfIntent);
                        } catch(ActivityNotFoundException e){
                            Toast.makeText(mContext, "Tidak ada aplikasi untuk membuka PDF file", Toast.LENGTH_SHORT).show();
                        }

                        return true;

                    default:
                }

                return false;
            }
        });
        popup.show();
    }

    @Override
    public int getItemCount() {
        return ebookList.size();
    }
}
