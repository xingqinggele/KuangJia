package com.zhhl.kuangjia.activitys;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhhl.kuangjia.MainActivity;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/9/29 16:46.
 */
public class ConstraintLayout extends BaseActivity {
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;
    @Override
    protected int getLayoutId() {
        return R.layout.constraintlayout;
    }

    @Override
    protected void initView() {
        title.setText("ConstraintLayout");
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.filsh)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.filsh:
                finish();
                break;

        }
    }
}
