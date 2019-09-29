package com.zhhl.kuangjia.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.zhhl.kuangjia.MainActivity;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;
import com.zhhl.kuangjia.fragment.ThreeFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/9/29 11:09.
 */
public class Mepersonal extends BaseActivity {
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;
    @Override
    protected int getLayoutId() {
        return R.layout.mepersonal;
    }

    @Override
    protected void initView() {
        title.setText("个人资料");

    }

    @Override
    protected void initData() {

    }


    @OnClick( {R.id.filsh,R.id.out_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.filsh:
                finish();
                break;
            case R.id.out_login:
                Intent intent = new Intent(this, ThreeFragment.class);
                intent.putExtra("pass_data", "123");
                setResult(-1, intent);
                finish();
                break;
        }
    }
}
