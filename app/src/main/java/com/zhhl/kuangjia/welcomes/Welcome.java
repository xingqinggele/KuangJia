package com.zhhl.kuangjia.welcomes;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.toollibrary.Utils.ILogUploadImpl;
import com.example.toollibrary.activity.BaseActivity;
import com.example.toollibrary.bean.CardInfo;
import com.example.toollibrary.bean.LoginBean;
import com.example.toollibrary.listener.CallBack;
import com.example.toollibrary.listener.PermissionListener;
import com.example.toollibrary.projectwrapper.SplashActivityWrapper;

import java.util.List;

/**
 * Created by qgl on 2019/9/19 16:28.
 */
public class Welcome extends SplashActivityWrapper {
    @Override
    public void login(String s, LoginBean loginBean) {
        Log.e("ok", "OK");
        Log.e("ok", loginBean.getId());
//        机构信息
        getCardInfo(new CallBack() {
            @Override
            public void onSuccess(String var) {
                Log.e("aaaaa", CardInfo.create(var).getObj().getDepName());
            }

            @Override
            public void onError(String var) {
                Log.e("aaaaa", var);

            }
        });

    }

    @Override
    public void uaacApiError(String s) {
        Log.e("NO", "NO");


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
