package com.arch.presentation.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class WebViewScroll extends WebView{

    private OnScrollChangeListener onScrollChangeListener;

    public WebViewScroll(Context context) {
        this(context,null);
    }

    public WebViewScroll(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public WebViewScroll(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollChangeListener != null) {

            onScrollChangeListener.onScrollChange(this, l, t, oldl, oldt);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.onScrollChangeListener = onScrollChangeListener;
    }


    public OnScrollChangeListener getOnScrollChangeListener() {
        return onScrollChangeListener;
    }


    public interface OnScrollChangeListener {
        void onScrollChange(WebView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY);
    }


}
