package com.atguigu.lmm.myplay.Fragemnt;


import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.atguigu.lmm.myplay.Adapter.NetAudioFragmentAdapter;
import com.atguigu.lmm.myplay.Base.BaseFragment;
import com.atguigu.lmm.myplay.Bean.NetAudioBean;
import com.atguigu.lmm.myplay.R;
import com.atguigu.lmm.myplay.Utils.CacheUtils;
import com.atguigu.lmm.myplay.Utils.Constant;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mancy_Lin on 2017-01-16.
 */

public class NetAudioFragment extends BaseFragment {
    /**
     * 数据集合
     */

    private static final String TAG = NetAudioFragment.class.getSimpleName();
    @Bind(R.id.listview)
    ListView listview;
    @Bind(R.id.progressbar)
    ProgressBar progressbar;
    @Bind(R.id.tv_nomedia)
    TextView tvNomedia;
    private NetAudioFragmentAdapter myAdapter;


    @Override
    public View initView() {
        Log.e(TAG, "网络音频UI被初始化了");
        View view = View.inflate(mContext, R.layout.fragment_net_audio, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "网络音频数据初始化了");
        String saveJson = CacheUtils.getString(mContext, Constant.NET_AUDIO_URL);
        if (!TextUtils.isEmpty(saveJson)) {
            processData(saveJson);
        }

        getDataFromNet();
    }

    private void getDataFromNet() {
        RequestParams reques = new RequestParams(Constant.NET_AUDIO_URL);
        x.http().get(reques, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Log.e("TAG", "1111111");
                CacheUtils.putString(mContext, Constant.NET_AUDIO_URL, result);
                LogUtil.e("onSuccess==" + result);
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("onError==" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("onCancelled==" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("onFinished==");
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    /* textView = new TextView(mContext);
     textView.setTextColor(Color.RED);
     textView.setGravity(Gravity.CENTER);
     textView.setTextSize(25);



}*/


    private void processData(String json) {
        NetAudioBean netAudioBean = paraseJons(json);
        List<NetAudioBean.ListBean> datas = netAudioBean.getList();

        if (datas != null && datas.size() > 0) {
            //有视频
            tvNomedia.setVisibility(View.GONE);
            //设置适配器
            myAdapter = new NetAudioFragmentAdapter(mContext,datas);
            listview.setAdapter(myAdapter);
        } else {
            //没有视频
            tvNomedia.setVisibility(View.VISIBLE);
        }

        progressbar.setVisibility(View.GONE);

    }

    private NetAudioBean paraseJons(String json) {
        return new Gson().fromJson(json, NetAudioBean.class);
    }


}

