package com.atguigu.lmm.myplay.Fragemnt;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.lmm.myplay.Base.BaseFragment;

/**
 * Created by Mancy_Lin on 2017-01-16.
 */

public class RviewFragment extends BaseFragment {
    private TextView textView;

    @Override
    public View initView() {

        textView = new TextView(mContext);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);

        return textView;
    }

    public void initData() {
        super.initData();
        textView.setText("Rview");
    }

    @Override
    public void onRefrshData() {
        super.onRefrshData();
        textView.setText("Rview");

    }
}
