package com.zhhl.kuangjia.activitys;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/10/9 14:04.
 */
public class XianchengActivity extends BaseActivity {

    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;
    private Handler handler;
    private static final int UPDATE = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.xianchengactivity;
    }

    @Override
    protected void initView() {
        title.setText("线程");
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // TODO 接收消息并且去更新UI线程上的控件内容
                if (msg.what == UPDATE) {
                    shouLog("XianchengActivity", String.valueOf(msg.obj));
                }
                super.handleMessage(msg);
            }
        };

    }

    @Override
    protected void initData() {

        new Thread() {
            @Override
            public void run() {
                try {

                    for (int i = 0; i <= 10; i++) {
                        Thread.sleep(500);
                        Message message = new Message();
                        message.what = UPDATE;
                        message.obj = "更新后的值" + i;
                        handler.sendMessage(message);
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        }.start();
    }


    @OnClick(R.id.filsh)
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.filsh:
                finish();
                break;
        }
    }





}
