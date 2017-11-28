package com.example.acer.kapil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by acer on 24.11.2017.
 */

public class DisposableRecyclerClass extends RecyclerView.Adapter<DisposableRecyclerClass.ViewHolder> {
    Context c;
    ArrayList<DisposableList> dList;

    public DisposableRecyclerClass(Context c, ArrayList<DisposableList> dList)
    {

            this.c=c;
        this.dList=dList;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(c);
        View v=inflater.inflate(R.layout.recyclerlayout,parent,false);
       ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.name.setText(dList.get(position).getName());
        holder.cost.setText(Float.valueOf(dList.get(position).getCostprice())+"" );
        holder.sell.setText(Float.valueOf(dList.get(position).getSellingprice())+"" );
        holder.piece.setText(Integer.valueOf(dList.get(position).getPieces())+"" );
        holder.type.setText(dList.get(position).getType());

    }

    @Override
    public int getItemCount() {
        return dList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
         TextView name;
        TextView cost;
        TextView sell;
        TextView piece;
        TextView type;

        public ViewHolder(View itemView) {
            super(itemView);
             name=(TextView)itemView.findViewById(R.id.name);
            cost=(TextView)itemView.findViewById(R.id.cost);
            sell=(TextView)itemView.findViewById(R.id.sell);
            piece=(TextView)itemView.findViewById(R.id.piece);
            type=(TextView)itemView.findViewById(R.id.type);

        }
    }



}
