package com.zhhl.kuangjia.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/9/29 13:45.
 */
public class MeEdition extends BaseActivity {
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.edtion_number)
    TextView edtionNumber;
    @BindView(R.id.edtion_name)
    TextView edtionName;

    @Override
    protected int getLayoutId() {
        return R.layout.meedition;
    }

    @Override
    protected void initView() {
        title.setText("版本信息");

    }

    @Override
    protected void initData() {
        edtionNumber.setText(getLocalVersion(MeEdition.this)+"");
        edtionName.setText(getLocalVersionName(MeEdition.this)+"");
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
