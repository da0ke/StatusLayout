package cn.da0ke.statuslayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.lang.reflect.Method;

/**
 * Created by da0ke on 2017/11/9
 *
 * 使用方法：
 * 1.布局文件中在合适的地方加入EmptyLayout，通常放在FrameLayout下
 * 2.获取EmptyLayout对象
 *      EmptyLayout emptyLayout = findViewById(R.id.emptyLayout);
 * 3.使用EmptyLayout方法
 *      emptyLayout.showProgress();
 *      emptyLayout.showLoading();
 *      emptyLayout.showEmpty();
 *      emptyLayout.showError();
 *      emptyLayout.errorClick(this,"initData");
 *      emtpyLayout.hide();
 *
 */

public class StatusLayout extends LinearLayout {
    //空数据页面
    private ViewGroup mEmptyView;
    //加载中页面
    private ViewGroup mLoadingView;
    //加载失败页面
    private ViewGroup mErrorView;
    //加载中遮罩
    private ViewGroup mProgressView;

    public StatusLayout(Context context) {
        super(context);
        init();
    }

    public StatusLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StatusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public StatusLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(mInflater != null) {
            mEmptyView = (ViewGroup) mInflater.inflate(R.layout.emptylayout_layout_empty,this,false);
            mLoadingView = (ViewGroup) mInflater.inflate(R.layout.emptylayout_layout_loading,this,false);
            mErrorView = (ViewGroup) mInflater.inflate(R.layout.emptylayout_layout_error,this,false);
            mProgressView = (ViewGroup) mInflater.inflate(R.layout.emptylayout_layout_progress,this,false);

            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            mEmptyView.setLayoutParams(layoutParams);
            mLoadingView.setLayoutParams(layoutParams);
            mErrorView.setLayoutParams(layoutParams);
            mProgressView.setLayoutParams(layoutParams);

            this.addView(mLoadingView);
            this.addView(mEmptyView);
            this.addView(mErrorView);
            this.addView(mProgressView);

            showLoading();
        }
    }

    public void showEmpty() {
        this.setVisibility(VISIBLE);
        mEmptyView.setVisibility(VISIBLE);
        mLoadingView.setVisibility(GONE);
        mErrorView.setVisibility(GONE);
        mProgressView.setVisibility(GONE);
    }

    public void showLoading() {
        this.setVisibility(VISIBLE);
        mEmptyView.setVisibility(GONE);
        mLoadingView.setVisibility(VISIBLE);
        mErrorView.setVisibility(GONE);
        mProgressView.setVisibility(GONE);
    }

    public void showError() {
        this.setVisibility(VISIBLE);
        mEmptyView.setVisibility(GONE);
        mLoadingView.setVisibility(GONE);
        mErrorView.setVisibility(VISIBLE);
        mProgressView.setVisibility(GONE);
    }

    public void showProgress() {
        this.setVisibility(VISIBLE);
        mEmptyView.setVisibility(GONE);
        mLoadingView.setVisibility(GONE);
        mErrorView.setVisibility(GONE);
        mProgressView.setVisibility(VISIBLE);
    }

    public void hide() {
        this.setVisibility(GONE);
    }

    public void errorClick(final Object base, final String method, final Object... parameters) {
        mErrorView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = parameters.length;
                Class<?>[] paramsTypes = new Class<?>[length];
                for (int i = 0; i < length; i++) {
                    paramsTypes[i] = parameters[i].getClass();
                }
                try {
                    Method m = base.getClass().getDeclaredMethod(method, paramsTypes);
                    m.setAccessible(true);
                    m.invoke(base, parameters);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
