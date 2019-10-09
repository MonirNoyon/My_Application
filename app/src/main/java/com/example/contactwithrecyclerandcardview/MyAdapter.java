package com.example.contactwithrecyclerandcardview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<Model> names;
    Context context;


    public MyAdapter(ArrayList<Model> names, Context context) {
        this.names=names;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.rowlayout,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        holder.nameText.setText(names.get(position).getTitle());
        holder.cntctNumber.setText(names.get(position).getNumber());
        holder.cntctImge.setImageResource(names.get(position).getImage());


        holder.setItemClickListener(new ClickableItem() {
            @Override
            public void onItemClick(View view, int position) {
                String gtitle = names.get(position).getTitle();
                String gNumber = names.get(position).getNumber();

                BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.cntctImge.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);

                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("iTitle",gtitle);
                intent.putExtra("iNumber",gNumber);
                intent.putExtra("img",bytes);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return names.size();
    }
}
