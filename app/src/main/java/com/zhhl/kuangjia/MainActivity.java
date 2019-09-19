package com.zhhl.kuangjia;

import android.os.Bundle;

import com.example.toollibrary.okhttp.exception.OkHttpException;
import com.example.toollibrary.okhttp.listener.DisposeDataListener;
import com.example.toollibrary.okhttp.request.RequestParams;
import com.zhhl.kuangjia.Uri.RequestCenter;
import com.zhhl.kuangjia.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        // 网络请求
        RequestParams params = new RequestParams();
        params.put("", "");
        RequestCenter.request_Url(params, new DisposeDataListener() {
            //成功
            @Override
            public void onSuccess(Object o) {

            }

            //失败
            @Override
            public void onFailure(OkHttpException e) {

            }
        });
    }


}
