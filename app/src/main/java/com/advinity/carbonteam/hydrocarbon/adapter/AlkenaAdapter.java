package com.advinity.carbonteam.hydrocarbon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.modal.Alkena;

import java.util.List;

/**
 * Created by afdolash on 24/11/16.
 */

public class AlkenaAdapter extends RecyclerView.Adapter<AlkenaAdapter.MyViewHolder> {

    private List<Alkena> alkenaList;

    public AlkenaAdapter(List<Alkena> alkenaList) {
        this.alkenaList = alkenaList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutorial, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Alkena alkena = alkenaList.get(position);

        holder.title.setText(alkena.getName());
        holder.subtitle.setText(alkena.getFormula());
    }

    @Override
    public int getItemCount() {
        return alkenaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, other, subtitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
            subtitle = (TextView) itemView.findViewById(R.id.item_subtitle);
        }
    }
}
