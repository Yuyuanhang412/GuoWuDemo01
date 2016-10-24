package com.bwie.guowudemo01.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwie.guowudemo01.R;
import com.bwie.guowudemo01.adapter.ZhenWuAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by w8888 on 2016/10/24.
 */
public class Lianbo extends android.support.v4.app.Fragment {

    private List<String> list=new ArrayList<String>();
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=View.inflate(getActivity(), R.layout.fragment_zhengwu,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addData();
        lv= (ListView) getActivity().findViewById(R.id.lv_fragm_zhengwu);
        lv.setAdapter(new ZhenWuAdapter(getActivity(),list));

    }

    private void addData() {

        for(int i=0;i<30;i++){

            list.add("text"+i);

        }

    }


}
