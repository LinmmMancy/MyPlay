package com.atguigu.lmm.myplay.Hoder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.lmm.myplay.Bean.NetAudioBean;
import com.atguigu.lmm.myplay.R;
import com.atguigu.lmm.myplay.Utils.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.xutils.image.ImageOptions;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


class ImageHolder extends BaseViewHolder {
    TextView tvContext;
    ImageView ivImageIcon;

    ImageHolder(View convertView) {
        super(convertView);
        //中间公共部分 -所有的都有
        tvContext = (TextView) convertView.findViewById(R.id.tv_context);
        ivImageIcon = (ImageView) convertView.findViewById(R.id.iv_image_icon);

    }

    public void setData(NetAudioBean.ListBean mediaItem) {
        super.setData(mediaItem);
        //设置文本-所有的都有
        tvContext.setText(mediaItem.getText() + "_" + mediaItem.getType());
        //图片特有的

        ivImageIcon.setImageResource(R.drawable.bg_item);
        if (mediaItem.getImage() != null && mediaItem.getImage() != null && mediaItem.getImage().getSmall() != null) {
            Glide.with(mContext).load(mediaItem.getImage().getDownload_url().get(0)).placeholder(R.drawable.bg_item).error(R.drawable.bg_item).diskCacheStrategy(DiskCacheStrategy.ALL).into(ivImageIcon);
        }


    }
}


class TextHolder extends BaseViewHolder {
    TextView tvContext;

    TextHolder(View convertView) {
        super(convertView);
        //中间公共部分 -所有的都有
        tvContext = (TextView) convertView.findViewById(R.id.tv_context);


    }

    public void setData(NetAudioBean.ListBean mediaItem) {
        super.setData(mediaItem);
        //设置文本-所有的都有
        tvContext.setText(mediaItem.getText() + "_" + mediaItem.getType());
    }
}


class GifHolder extends BaseViewHolder {
    TextView tvContext;
    ImageView ivImageGif;
    private ImageOptions imageOptions;

    GifHolder(View convertView) {
        super(convertView);
        //中间公共部分 -所有的都有
        tvContext = (TextView) convertView.findViewById(R.id.tv_context);
        ivImageGif = (ImageView) convertView.findViewById(R.id.iv_image_gif);

        imageOptions = new ImageOptions.Builder()
                //包裹类型
                .setSize(ViewGroup.LayoutParams.WRAP_CONTENT, -2)
                //设置圆角
                .setRadius(DensityUtil.dip2px(5))
                .setIgnoreGif(false)//是否忽略gif图。false表示不忽略。不写这句，默认是true
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setLoadingDrawableId(R.drawable.video_default)
                .setFailureDrawableId(R.drawable.video_default)
                .build();

    }

    public void setData(NetAudioBean.ListBean mediaItem) {
        super.setData(mediaItem);
        //设置文本-所有的都有
        tvContext.setText(mediaItem.getText() + "_" + mediaItem.getType());

        //下面是gif
        if (mediaItem.getGif() != null && mediaItem.getGif() != null && mediaItem.getGif().getImages() != null) {
//                Glide.with(context).load(mediaItem.getGif().getImages().get(0)).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(ivImageGif);
            x.image().bind(ivImageGif, mediaItem.getGif().getImages().get(0), imageOptions);
        }

    }
}

static class ADHolder {
    TextView tvContext;
    ImageView ivImageIcon;
    Button btnInstall;

    ADHolder(View convertView) {
        //中间公共部分 -所有的都有
        tvContext = (TextView) convertView.findViewById(R.id.tv_context);
        btnInstall = (Button) convertView.findViewById(R.id.btn_install);
        ivImageIcon = (ImageView) convertView.findViewById(R.id.iv_image_icon);
    }
}
