package com.example.fitness_1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter {
    List<fetchdata> fetchdataList;

    public HelperAdapter(List<fetchdata> fetchdataList) {
        this.fetchdataList = fetchdataList;
    }

    public HelperAdapter(Object o) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolderClass viewHolderClass=new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass=(ViewHolderClass)holder;
        fetchdata fetchdata= fetchdataList.get(position);
        viewHolderClass.pushups.setText(fetchdata.getPushups());
        viewHolderClass.pullups.setText(fetchdata.getPullups());
        viewHolderClass.squats.setText(fetchdata.getSquats());
        viewHolderClass.plunk.setText(fetchdata.getPlunk());
        viewHolderClass.situps.setText(fetchdata.getSitups());
        viewHolderClass.date.setText(fetchdata.getDate());


    }

    @Override
    public int getItemCount() {
        return fetchdataList.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder{
        TextView pushups,pullups,squats,plunk,situps,date;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            pushups=itemView.findViewById(R.id.pushups);
            pullups=itemView.findViewById(R.id.pullups);
            squats=itemView.findViewById(R.id.squats);
            plunk=itemView.findViewById(R.id.plunk);
            situps=itemView.findViewById(R.id.situps);
            date=itemView.findViewById(R.id.date1);
        }
    }
}
