package com.bwie.guowudemo01.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwie.guowudemo01.R;
import com.bwie.guowudemo01.adapter.ZhenWuAdapter;
import com.bwie.guowudemo01.bean.Bean;
import com.bwie.guowudemo01.utils.HttpGet;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by w8888 on 2016/10/24.
 */
public class Lianbo extends android.support.v4.app.Fragment {

    private boolean isViewCreated;
    private boolean isLoadDataCompleted;

    private ListView lv;
    private String weekurl="http://open.qyer.com/qyer/bbs/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915";

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

        initView();


    }

    private void initView() {

        lv= (ListView) getActivity().findViewById(R.id.lv_fragm_zhengwu);
       // lv.setAdapter(new ZhenWuAdapter(getActivity(),list));
        isViewCreated=true;

    }

    private void addData() {

        new AsyncTask<Void,Void,String>(){
            @Override
            protected String doInBackground(Void... params) {
                String str = HttpGet.Getstr(weekurl);
                return str;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                Gson gson = new Gson();
                Bean bean = gson.fromJson(s, Bean.class);
                List<Bean.DataEntity.ForumListEntity.GroupEntity> list = bean.getData().getForum_list().get(0).getGroup();

                //适配器
                lv.setAdapter(new ZhenWuAdapter(getActivity(), list));
            }
        }.execute();

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser && isViewCreated)//只有在用户可见以及初始化之后才加载数据
        {
            lazyLoad();
        }

    }

    private void lazyLoad(){
        if (!isLoadDataCompleted){
            initView();
            addData();
            isLoadDataCompleted=true;

        }
    }

    //这里需要重置状态，不然加载了之后就没办法再重新加载了
    @Override
    public void onDestroy() {
        super.onDestroy();
        isLoadDataCompleted=false;
    }
}
