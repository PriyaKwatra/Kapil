package com.example.acer.kapil;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class MedicineRecyclerClass extends RecyclerView.Adapter<MedicineRecyclerClass.ViewHolder> implements Filterable {
      MedicineFragment frag;
    Context c;
    ArrayList<MedicineList> dList;
    //FriendFilter friendFilter;
     ArrayList<MedicineList> filteredList;
    RecyclerView recyclerView;
    View v;

    public MedicineRecyclerClass(Context c, ArrayList<MedicineList> dList,RecyclerView recyclerView,MedicineFragment frag)
    {this.c=c;
        this.dList=dList;
        this.filteredList = dList;
        this.recyclerView=recyclerView;
        this.frag = frag;
        this.v=v;
        getFilter();
    }


    @Override
    public MedicineRecyclerClass.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(c);
        View v=inflater.inflate(R.layout.recyclerlayout,parent,false);
        MedicineRecyclerClass.ViewHolder holder=new MedicineRecyclerClass.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MedicineRecyclerClass.ViewHolder holder, int position) {
        Log.e("chal",filteredList.get(position).getName());
        holder.name.setText(filteredList.get(position).getName());
        holder.cost.setText(Float.valueOf(filteredList.get(position).getCostprice())+"" );
        holder.sell.setText(Float.valueOf(filteredList.get(position).getSellingprice())+"" );
        holder.piece.setText(Integer.valueOf(filteredList.get(position).getPieces())+"" );
        holder.type.setText(filteredList.get(position).getType());

    }

    @Override
    public int getItemCount() {
        return filteredList.size();

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


    @Override
    public Filter getFilter() {


   return new  Filter() {
       @Override
       protected FilterResults performFiltering(CharSequence constraint) {
           FilterResults filterResults = new FilterResults();
           if (constraint != null && constraint.length() > 0) {
               ArrayList<MedicineList> tempList = new ArrayList<>();
               for (MedicineList product : dList) {
                   if (product.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                       tempList.add(product);
                   }
               }

               filterResults.count = tempList.size();
               filterResults.values = tempList;
           } else {
               filterResults.count = dList.size();
               filterResults.values = dList;
           }
           return filterResults;
       }

       @Override
       protected void publishResults(CharSequence constraint, FilterResults results) {
           //  int n=filteredList.size();
           //filteredList.clear();
           // notifyItemRangeRemoved(0,n);
           //filteredList.addAll((ArrayList<MedicineList>) results.values);
           //notifyItemRangeInserted(0,filteredList.size());

           //}



           filteredList.clear();
           filteredList.addAll((ArrayList<MedicineList>) results.values);
           frag.callThis(filteredList);

           //MedicineRecyclerClass.this.notifyDataSetChanged();
          // Log.e("YEP", "hellooo");
           for (MedicineList product : filteredList) {
               Log.e("hiiopp", product.getName());
               //synchronized(this){
               //  this.notifyAll();
               //}
           }
       }


   };}}