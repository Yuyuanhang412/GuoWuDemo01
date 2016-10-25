package com.bwie.guowudemo01.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.bwie.guowudemo01.R;
import com.bwie.guowudemo01.adapter.BumenAdapter;
import com.bwie.guowudemo01.bean.Bean;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by w8888 on 2016/10/24.
 */
public class Bumen extends android.support.v4.app.Fragment {

    private GridView gv;
    private List<String> list=new ArrayList<String>();
    private String weekurl="http://open.qyer.com/qyer/bbs/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915";

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            Bean weekBean= (Bean) msg.obj;




            List<Bean.DataEntity.ForumListEntity>list=weekBean.getData().getForum_list();
            gv.setAdapter(new BumenAdapter(getActivity(),list));

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=View.inflate(getActivity(), R.layout.fragment_bumen,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        gv= (GridView) getActivity().findViewById(R.id.gv_fragm_bumen);




        new Thread(){

            @Override
            public void run() {

                try {
                    URL url = new URL(weekurl);

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    if (httpURLConnection.getResponseCode() == 200) {

                        InputStream inputStream = httpURLConnection.getInputStream();

                        //解析Gson
                        Gson gson = new Gson();
                        Bean weekbean = gson.fromJson(new InputStreamReader(inputStream), Bean.class);
                        Log.i("-------", weekbean.toString());
                        Message msg = Message.obtain();
                        msg.obj = weekbean;

                        handler.sendMessage(msg);

                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            };
        }.start();



    }

}
