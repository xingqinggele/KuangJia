package com.zhhl.kuangjia.app;

import android.app.Application;
import android.content.Context;

import com.example.toollibrary.Library;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by qgl on 2019/9/19 17:25.
 */
public class MyAppliction extends Application
{

    @Override
    public void onCreate()
    {

        super.onCreate();
        Fresco.initialize(this);
        Library.init(this);
        Library.setData("http://192.168.1.113","8080","/log","重点人员关注","107");
    }
}
