package com.example.toshiba_l15w.androidcafe;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by TOSHIBA-L15W on 1/21/2018.
 */

public class FragmentList extends Fragment {

    @Nullable
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_list,null);
        setupRecyclerView(view);

        return view;
    }
    private void setupRecyclerView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(),
                MenuData.getListMenu());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }
}

