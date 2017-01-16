package com.atguigu.lmm.myplay.Fragemnt;


import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.atguigu.lmm.myplay.Base.BaseFragment;
import com.atguigu.lmm.myplay.R;
import com.atguigu.lmm.myplay.Utils.Constant;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Mancy_Lin on 2017-01-16.
 */

public class netVideoFragment extends BaseFragment {
    // private TextView textView;
    @ViewInject(R.id.listview)
    private ListView listView;
    @ViewInject(R.id.tv_no_media)
    private TextView tv_no_media;


    @Override
    public View initView() {

       /* textView = new TextView(mContext);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);

        return textView;*/
        View view = View.inflate(mContext, R.layout.fragment_net_video, null);
        x.view().inject(netVideoFragment.this, view);
        return view;

    }

    public void initData() {
        super.initData();
        getDataFromNet();
    }

    private void getDataFromNet() {
        //网络的路径
        RequestParams params = new RequestParams(Constant.NET_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e("TAG", "xUtils3联网成功==" + result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void onRefrshData() {
        super.onRefrshData();

    }


}
