package com.advinity.carbonteam.hydrocarbon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.modal.Alkana;

import java.util.List;

/**
 * Created by afdolash on 24/11/16.
 */

public class AlkanaAdapter extends RecyclerView.Adapter<AlkanaAdapter.MyViewHolder> {

    private List<Alkana> alkanaList;

    public AlkanaAdapter(List<Alkana> alkanaList) {
        this.alkanaList = alkanaList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutorial, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Alkana alkana = alkanaList.get(position);

        holder.title.setText(alkana.getName());
        holder.subtitle.setText(alkana.getFormula());
    }

    @Override
    public int getItemCount() {
        return alkanaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, subtitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
            subtitle = (TextView) itemView.findViewById(R.id.item_subtitle);
        }
    }
}
