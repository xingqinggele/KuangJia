package com.zhhl.kuangjia.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/9/23 10:16.
 */
public class JieTuActivity extends BaseActivity {

    @BindView(R.id.sim_img)
    SimpleDraweeView simImg;
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;

    @Override
    protected int getLayoutId() {
        return R.layout.jietuactivity;
    }

    @Override
    protected void initView() {
        title.setText("截图Activity");
        String filePath=getIntent().getStringExtra("file");
        String imageUri = "file://" + filePath; //SD卡图片
        simImg.setImageURI(imageUri);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.filsh})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.filsh:
                finish();
                break;
        }
    }
}
