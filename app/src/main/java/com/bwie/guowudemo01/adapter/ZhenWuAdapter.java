package com.bwie.guowudemo01.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bwie.guowudemo01.R;
import com.bwie.guowudemo01.bean.Bean;

import java.util.List;

/**
 * Created by w8888 on 2016/10/24.
 */
public class ZhenWuAdapter extends BaseAdapter{

    private Context context;
    private List<Bean.DataEntity.ForumListEntity.GroupEntity> list;

    public ZhenWuAdapter(Context context, List<Bean.DataEntity.ForumListEntity.GroupEntity> list) {

        this.context=context;
        this.list=list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            vh=new ViewHolder();
            convertView=View.inflate(context, R.layout.fragment_zhengwu_item,null);
            vh.tv_id= (TextView) convertView.findViewById(R.id.tv_fragm_zhenwu_id);
            vh.tv_name= (TextView) convertView.findViewById(R.id.tv_fragm_zhenwu_name);
            convertView.setTag(vh);

        }else{
            vh= (ViewHolder) convertView.getTag();
        }

        vh.tv_id.setText(list.get(position).getId()+"");
        vh.tv_name.setText(list.get(position).getDescription());
        return convertView;
    }

    class ViewHolder{

        private TextView tv_id,tv_name;
    }

}
