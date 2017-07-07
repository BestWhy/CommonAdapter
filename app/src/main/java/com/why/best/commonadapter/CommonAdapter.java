package com.why.best.commonadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by why on 2017/7/7.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<T> mDatas;
    private int mItemLayoytId;

    public CommonAdapter(Context context, List<T> datas,int itemLayoytId) {

        this.mContext = context;
        this.mDatas = datas;
        mLayoutInflater = LayoutInflater.from(context);
        this.mItemLayoytId = itemLayoytId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        convert(viewHolder,getItem(position));
        return viewHolder.getConverView();
    }

    protected abstract void convert(ViewHolder viewHolder, T item);


    private ViewHolder getViewHolder(int position,View convertView,ViewGroup parent){
        return ViewHolder.getViews(mContext, convertView, parent, mItemLayoytId, position);
    }
}
