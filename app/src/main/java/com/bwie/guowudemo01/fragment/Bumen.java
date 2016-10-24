package com.bwie.guowudemo01.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.bwie.guowudemo01.R;
import com.bwie.guowudemo01.adapter.BumenAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by w8888 on 2016/10/24.
 */
public class Bumen extends android.support.v4.app.Fragment {

    private GridView gv;
    private List<String> list=new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=View.inflate(getActivity(), R.layout.fragment_bumen,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addData();

        gv= (GridView) getActivity().findViewById(R.id.gv_fragm_bumen);
        gv.setAdapter(new BumenAdapter(getActivity(),list));
    }

   private void addData() {
        for(int i=0;i<30;i++){

            list.add("item"+i);

        }

   }
}
