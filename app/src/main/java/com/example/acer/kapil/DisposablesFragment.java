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
public class DisposablesFragment extends Fragment implements View.OnClickListener {


    RecyclerView recyclerView;
    public static DisposablesFragment newInstance(ArrayList<DisposableList> disposables) {

        Bundle args = new Bundle();
        args.putParcelableArrayList("abc",disposables);

        DisposablesFragment fragment = new DisposablesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragmentlayout,container,false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        Bundle b=getArguments();
      ArrayList<DisposableList>   list= b.getParcelableArrayList("abc");
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new DisposableRecyclerClass(getContext(),list));
        FloatingActionButton mButton =(FloatingActionButton)v.findViewById(R.id.mbutton);

       mButton.setOnClickListener(this);







        return v;}

    @Override
    public void onClick(View v) {
        CustomDialog cdd=new CustomDialog(getContext(),"disposables");
        cdd.show();
    }
}
