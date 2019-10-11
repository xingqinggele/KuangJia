package com.zhhl.kuangjia.activitys;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/10/9 9:17.
 */
public class ServiceActivity1 extends BaseActivity {
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;

    @Override
    protected int getLayoutId() {
        return R.layout.serviceactivity1;
    }

    @Override
    protected void initView() {
        title.setText("服务");
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.filsh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.filsh:
                finish();
                break;
        }
    }
}
