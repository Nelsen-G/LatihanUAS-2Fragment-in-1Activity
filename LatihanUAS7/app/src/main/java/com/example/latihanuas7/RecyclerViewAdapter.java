package com.example.latihanuas7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<Dosen> listDosen;

    private ItemClickListener itemClickListener;

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    private Context c;

    public RecyclerViewAdapter(ArrayList<Dosen> listDosen, Context c) {
        this.listDosen = listDosen;
        this.c = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dosen_individual, parent, false);

        return new MyViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Dosen dosen = listDosen.get(position);

        holder.dosenName.setText(dosen.getName());
        holder.dosenAge.setText(String.valueOf(dosen.getAge()));

    }

    @Override
    public int getItemCount() {
        return listDosen.size();
    }
}
