package com.atguigu.lmm.myplay;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.atguigu.lmm.myplay.Base.BaseFragment;
import com.atguigu.lmm.myplay.Fragemnt.NetAudioFragment;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RadioGroup rg_main;

    /**
     * 装多个Fragment
     */
    private ArrayList<BaseFragment> fragments;
    /**
     * 下标位置
     */
    private int position;

    /**
     * 缓存的Fragment
     */
    private Fragment tempFragment;

    SensorManager sensorManager;
    JCVideoPlayer.JCAutoFullscreenListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initFragment();
        setListener();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();

    }

    private void initView() {

    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new NetAudioFragment());//网络音频

        //默认显示本地视频
//        swichFragment(position);
        defultFragemtn(fragments.get(position));


    }

    private void defultFragemtn(BaseFragment baseFragment) {

        tempFragment = to;
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, to).commit();

    }

    private void setListener() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(sensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
        JCVideoPlayer.releaseAllVideos();
    }


    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

}

}

