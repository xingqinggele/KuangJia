package com.zhhl.kuangjia.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.zhhl.kuangjia.MainActivity;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;

import app.dinus.com.loadingdrawable.LoadingView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/9/19 17:23.
 */
public class CeshiActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.cs_btn)
    Button csBtn;
    @BindView(R.id.cs_btn2)
    Button csBtn2;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.cs_btn3)
    Button csBtn3;
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.circle_brood_view)
    LoadingView circleBroodView;

    @Override
    protected int getLayoutId() {
        return R.layout.ceshiactivity;
    }

    @Override
    protected void initView() {
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorScheme(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                circleBroodView.setVisibility(View.GONE);
            }
        }, 3000);//3秒后执行Runnable中的run方法
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title.setText("测试Activity");
    }

    @OnClick({R.id.cs_btn, R.id.cs_btn2, R.id.cs_btn3,R.id.filsh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cs_btn:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("pass_data", "123");
                setResult(-1, intent);
                finish();
                break;
            case R.id.cs_btn2:
                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.putExtra("name", "青格乐");
                setResult(2, intent2);
                finish();
                break;
            case R.id.cs_btn3:
                Intent intent3 = new Intent(CeshiActivity.this, Map.class);
                startActivity(intent3);
                break;

            case R.id.filsh:
                finish();
                break;

        }
    }


    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

}
