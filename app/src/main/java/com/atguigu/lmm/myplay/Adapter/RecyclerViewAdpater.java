package com.atguigu.lmm.myplay.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.lmm.myplay.Bean.NetAudioBean;
import com.atguigu.lmm.myplay.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mancy_Lin on 2017-01-16.
 */
public class RecyclerViewAdpater extends RecyclerView.Adapter<RecyclerViewAdpater.MyViewHolder> {

    private final Context context;
    private final ArrayList<String> datas;


    public RecyclerViewAdpater(Context context, List<NetAudioBean.ListBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    /**
     * 相当于ListView适配器中的getView的创建holder布局
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_hello, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_text.setText(datas.get(position));
        holder.iv_icon.setBackgroundResource(R.mipmap.ic_launcher);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_text;
        private ImageView iv_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_text = (TextView) itemView.findViewById(R.id.tv_text);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);

        }
    }

}




