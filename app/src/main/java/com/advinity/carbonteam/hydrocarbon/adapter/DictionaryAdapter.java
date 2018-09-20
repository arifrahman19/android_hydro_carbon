package com.advinity.carbonteam.hydrocarbon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.modal.Alkuna;
import com.advinity.carbonteam.hydrocarbon.modal.Dictionary;

import java.util.List;

/**
 * Created by afdolash on 25/11/16.
 */

public class DictionaryAdapter extends RecyclerView.Adapter<DictionaryAdapter.MyViewHolder> {

    private List<Dictionary> dictionaryList;

    public DictionaryAdapter(List<Dictionary> dictionaryList) {
        this.dictionaryList = dictionaryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dictionary, parent, false);

        return new DictionaryAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DictionaryAdapter.MyViewHolder holder, int position) {
        Dictionary dictionary = dictionaryList.get(position);

        holder.title.setText(dictionary.getTitle());
        holder.content.setText(dictionary.getContent());
    }

    @Override
    public int getItemCount() {
        return dictionaryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, content;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
            content = (TextView) itemView.findViewById(R.id.item_content);
        }
    }

}
