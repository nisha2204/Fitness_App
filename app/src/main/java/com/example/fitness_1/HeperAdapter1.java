package com.example.fitness_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HeperAdapter1 extends RecyclerView.Adapter {
    List<fetchdata1> fetchdataList;

    public HeperAdapter1(List<fetchdata1> fetchdataList1) {
        this.fetchdataList = fetchdataList1;
    }

    public HeperAdapter1(Object o) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardio,parent,false);
        ViewHolderClass viewHolderClass=new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass=(ViewHolderClass)holder;
        fetchdata1 fetchdata= fetchdataList.get(position);
        viewHolderClass.distance.setText(fetchdata.getDistance());
        viewHolderClass.speed.setText(fetchdata.getSpeed());
        viewHolderClass.date.setText(fetchdata.getDate());

    }

    @Override
    public int getItemCount() {
        return fetchdataList.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder{
        TextView distance,speed,date;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            distance=itemView.findViewById(R.id.distance);
            speed=itemView.findViewById(R.id.speed);
            date=itemView.findViewById(R.id.date1);
        }
    }
}

