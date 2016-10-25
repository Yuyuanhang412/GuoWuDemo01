package com.bwie.guowudemo01.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bwie.guowudemo01.R;
import com.bwie.guowudemo01.bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * Created by w8888 on 2016/10/24.
 */
public class BumenAdapter extends BaseAdapter{
    private Context context;
   private List<Bean.DataEntity.ForumListEntity> list;
    private ImageLoader imageLoa;

    public BumenAdapter(Context context, List<Bean.DataEntity.ForumListEntity> list) {

        this.context=context;
        this.list=list;
       // imageLoa=ImageLoader.getInstance();
        //imageLoa.init(ImageLoaderConfiguration.createDefault(context));

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
        if(convertView==null){
            vh=new ViewHolder();
            convertView=View.inflate(context, R.layout.fragment_bumen_item,null);
            vh.image_bumen= (ImageView) convertView.findViewById(R.id.image_fragm_bumen);
            vh.tv_bumen= (TextView) convertView.findViewById(R.id.tv_fragm_title);
            convertView.setTag(vh);

        }else{
            vh= (ViewHolder) convertView.getTag();
        }

        //List<Bean.DataEntity.ForumListEntity.GroupEntity> bean= list.get(position).getGroup();

        //imageLoa.displayImage(bean.get(position).getPhoto(),vh.image_bumen);

        vh.tv_bumen.setText(list.get(position).getName());

        return convertView;
    }


    class ViewHolder{
        private ImageView image_bumen;
        private TextView tv_bumen;

    }

}
