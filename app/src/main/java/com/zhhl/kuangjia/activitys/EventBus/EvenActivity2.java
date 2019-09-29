package com.zhhl.kuangjia.activitys.EventBus;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;
import com.zhhl.kuangjia.bean.Databean;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * Created by qgl on 2019/9/29 14:59.
 */
public class EvenActivity2 extends BaseActivity {
    @BindView(R.id.fanhui)
    Button fanhui;
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;

    private List<Databean>aa = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.evenactivity2;
    }

    @Override
    protected void initView() {
        title.setText("EvenActivity2");
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.fanhui,R.id.filsh})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.fanhui:
                for (int i = 0;i<=5;i++){
                    Databean databean = new Databean();
                    databean.setName("name"+i);
                    databean.setPass("pass"+i);
                    aa.add(databean);
                }
                EventBus.getDefault().post(aa.get(1));
                finish();
                break;
            case R.id.filsh:
                finish();
                break;
        }
    }
}
