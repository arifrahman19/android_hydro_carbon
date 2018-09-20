package com.advinity.carbonteam.hydrocarbon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.modal.Alkuna;

import java.util.List;

/**
 * Created by afdolash on 24/11/16.
 */

public class AlkunaAdapter extends RecyclerView.Adapter<AlkunaAdapter.MyViewHolder> {

    private List<Alkuna> alkunaList;

    public AlkunaAdapter(List<Alkuna> alkunaList) {
        this.alkunaList = alkunaList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutorial, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Alkuna alkuna = alkunaList.get(position);

        holder.title.setText(alkuna.getName());
        holder.subtitle.setText(alkuna.getFormula());
    }

    @Override
    public int getItemCount() {
        return alkunaList.size();
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
