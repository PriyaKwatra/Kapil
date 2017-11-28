package com.example.acer.kapil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by acer on 24.11.2017.
 */

public class GroceryFragment  extends Fragment implements View.OnClickListener {
RecyclerView recyclerView;
    public static GroceryFragment newInstance(ArrayList<GroceryList> grocery) {

        Bundle args = new Bundle();
        args.putParcelableArrayList("abc",grocery);

        GroceryFragment fragment = new GroceryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragmentlayout,container,false);
        Bundle b=getArguments();
        recyclerView=(RecyclerView)v.findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<GroceryList>list= b.getParcelableArrayList("abc");
        recyclerView.setAdapter(new GroceryRecyclerClass(getContext(),list));

        FloatingActionButton mButton =(FloatingActionButton)v.findViewById(R.id.mbutton);
        mButton.setOnClickListener(this);



        return v;
    }

    @Override
    public void onClick(View v) {
        CustomDialog cdd=new CustomDialog(getContext(),"grocery");
        cdd.show();
    }
}
