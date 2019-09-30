package com.zhhl.kuangjia.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;
import com.zhhl.kuangjia.fragment.ThreeFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/9/30 8:41.
 */
public class EditingActivity extends BaseActivity {
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.logo)
    SimpleDraweeView logo;
    @BindView(R.id.preservation)
    Button preservation;
    @BindView(R.id.name)
    EditText name;

    @Override
    protected int getLayoutId() {
        return R.layout.editingactivity;
    }

    @Override
    protected void initView() {
        title.setText("编辑资料");

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.filsh, R.id.preservation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.filsh:
                finish();
                break;
            case R.id.preservation:
                Intent intent = new Intent(this, ThreeFragment.class);
                intent.putExtra("EditingActivity", "1");
                setResult(-1, intent);
                finish();
                break;
        }
    }


}
