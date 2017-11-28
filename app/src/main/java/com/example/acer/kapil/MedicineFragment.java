package com.example.acer.kapil;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;

public class MedicineFragment extends Fragment implements View.OnClickListener, SearchView.OnQueryTextListener{
RecyclerView recyclerView;
    MedicineRecyclerClass recyclerClass;
    public  MedicineFragment newInstance(ArrayList<MedicineList> medicines, SearchView searchView) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("abc", medicines);
        recyclerClass=new MedicineRecyclerClass(getContext(),medicines,recyclerView,MedicineFragment.this);
        MedicineFragment fragment = new MedicineFragment();
        fragment.setArguments(args);
        searchView.setOnQueryTextListener(this);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragmentlayout,container,false);
        Bundle b=getArguments();
        FloatingActionButton mButton =(FloatingActionButton)v.findViewById(R.id.mbutton);
        mButton.setOnClickListener(this);
        recyclerView=(RecyclerView)v.findViewById(R.id.recycler);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<MedicineList>list= b.getParcelableArrayList("abc");
        recyclerClass=new MedicineRecyclerClass(getContext(),list,recyclerView,MedicineFragment.this);
        recyclerView.setAdapter(recyclerClass);
        return v;
    }

    @Override
    public void onClick(View v) {
        CustomDialog cdd=new CustomDialog(getContext(),"fragmentlayout");
        cdd.show();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }



    @Override
    public boolean onQueryTextChange(String newText) {
        recyclerClass.getFilter().filter(newText);

        return true;
    }





    public void callThis(ArrayList<MedicineList> newList){
        ((MainActivity)getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerClass.notifyDataSetChanged();
            }
        });







    }










}
