package com.zhhl.kuangjia.activitys;


import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.Receiver.MyBRReceiver;
import com.zhhl.kuangjia.base.BaseActivity;
import com.zhhl.kuangjia.fragment.ThreeFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/9/30 14:04.
 */
public class ServiceActivity extends BaseActivity {
    private NotificationManager mManager;
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;

    @Override
    protected int getLayoutId() {
        return R.layout.serviceactivity;
    }

    @Override
    protected void initView() {
        title.setText("通知");
        mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        sendNotification();
    }

    public void sendNotification() {
        String channelId = "channelId";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelName = "这是用来测试的notification";
            createNotificationChannel(channelId, channelName, NotificationManagerCompat.IMPORTANCE_HIGH);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentTitle("标题");
        builder.setContentText("内容");
        Notification notification = builder.build();
        mManager.notify(1, notification);


    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        mManager.createNotificationChannel(channel);
    }



    @Override
    protected void initData() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @OnClick( R.id.filsh)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.filsh:
                finish();
                break;
        }
    }


}
