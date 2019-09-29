package com.zhhl.kuangjia.activitys.EventBus;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;
import com.zhhl.kuangjia.bean.Databean;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * Created by qgl on 2019/9/29 14:59.
 */
public class EvenActivity1 extends BaseActivity {
    @BindView(R.id.eventbus)
    Button eventbus;
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;
    @Override
    protected int getLayoutId() {
        return R.layout.evenactivity1;
    }

    @Override
    protected void initView() {
        title.setText("EvenActivity1");
        EventBus.getDefault().register(this);

    }

    @Override
    protected void initData() {

    }
    public void onEventMainThread(Databean event) {

        shouLog("EvenActivity1name",event.getName());
        shouLog("EvenActivity1pass",event.getPass());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @OnClick({R.id.eventbus,R.id.filsh})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.eventbus:
                Intent intent = new Intent(EvenActivity1.this,EvenActivity2.class);
                startActivity(intent);
                break;
            case R.id.filsh:
                finish();
                break;
        }
    }

}
