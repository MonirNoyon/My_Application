package com.example.contactwithrecyclerandcardview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView cntctImge;
    TextView nameText,cntctNumber;
    ClickableItem clickableItem;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        nameText = itemView.findViewById(R.id.itemDataTextViewId);
        cntctNumber = itemView.findViewById(R.id.descriptionNumberId);
        cntctImge = itemView.findViewById(R.id.cntctImageId);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        this.clickableItem.onItemClick(view,getLayoutPosition());

    }

    public void setItemClickListener(ClickableItem item)
    {
        this.clickableItem =item;
    }
}
