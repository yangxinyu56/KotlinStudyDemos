package com.yxy.kotlinstudydemos.adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class ImageViewAttrAdapter {
    @BindingAdapter(value = {"url","placeHolder"},requireAll = false)
    public static void setImage(ImageView imageView , String url, int placeHolder){
        Glide.with(imageView.getContext()).load(url).placeholder(placeHolder).into(imageView);
    }
}
