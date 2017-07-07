package com.why.best.commonadapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by why on 2017/7/7.
 */

public class ViewHolder {

    private final SparseArray<View> mViews;
    private final View mConverView;

    private ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mViews = new SparseArray<>();
        mConverView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConverView.setTag(this);
    }

    /**
     * 拿到一个view对象
     *
     * @param context
     * @param converView
     * @return
     */
    public static ViewHolder getViews(Context context, View converView, ViewGroup parent, int layoutId, int position) {
        if (converView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) converView.getTag();
    }

    /**
     * 通过控件的id获取对应的控件,如果没有则加入views
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConverView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConverView() {
        return mConverView;
    }


    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text)
    {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int drawableId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }


}
