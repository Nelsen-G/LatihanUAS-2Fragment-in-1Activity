package com.example.latihanuas7;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView dosenName, dosenAge;

    public Button btnDetail;
    public MyViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        dosenName = itemView.findViewById(R.id.viewDosenName);
        dosenAge = itemView.findViewById(R.id.viewDosenAge);
        btnDetail = itemView.findViewById(R.id.viewDosenDetail);

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemClickListener!=null){
                    itemClickListener.onClicked(view, getAdapterPosition());
                }
            }
        });

    }
}
