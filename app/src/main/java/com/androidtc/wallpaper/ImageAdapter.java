package com.androidtc.wallpaper;


import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    public Integer[] mThumbs = {
            R.drawable.mamao,
            R.drawable.laranja,
            R.drawable.abacaxi,
            R.drawable.limao
    } ;

    public Context mContext;

    public ImageAdapter (Context c){
        mContext = c;
    }


    @Override
    public int getCount() {
        return mThumbs.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbs[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView (mContext);
        imageView.setImageResource (mThumbs[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,200));
        return imageView;
    }
}
