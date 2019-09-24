package com.zhhl.kuangjia.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/9/20 15:15.
 */
public class Map extends BaseActivity {

    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.img4)
    ImageView img4;
    @BindView(R.id.img5)
    ImageView img5;
    @BindView(R.id.img6)
    ImageView img6;
    @BindView(R.id.img7)
    ImageView img7;
    @BindView(R.id.img8)
    ImageView img8;
    @BindView(R.id.img9)
    ImageView img9;
    @BindView(R.id.img10)
    ImageView img10;
    @BindView(R.id.img11)
    ImageView img11;
    @BindView(R.id.img12)
    ImageView img12;
    @BindView(R.id.d1)
    TextView d1;
    @BindView(R.id.d2)
    TextView d2;
    @BindView(R.id.d3)
    TextView d3;
    @BindView(R.id.d4)
    TextView d4;
    @BindView(R.id.txt1)
    TextView txt1;
    @BindView(R.id.txt2)
    TextView txt2;
    @BindView(R.id.txt3)
    TextView txt3;
    @BindView(R.id.txt4)
    TextView txt4;
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;
    @Override
    protected int getLayoutId() {
        return R.layout.map;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title.setText("MapActivity");
    }

    @OnClick({R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9, R.id.img10, R.id.img11, R.id.img12,R.id.filsh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img1:
                txt1.setTextColor(this.getResources().getColor(R.color.mred));//通过获得资源文件进行设置。
                d1.setBackground(this.getResources().getDrawable(R.drawable.btn_bg2));
                txt2.setTextColor(this.getResources().getColor(R.color.mblue));//通过获得资源文件进行设置。
                d2.setBackground(this.getResources().getDrawable(R.drawable.btn_bg1));
                txt3.setTextColor(this.getResources().getColor(R.color.mblue));//通过获得资源文件进行设置。
                d3.setBackground(this.getResources().getDrawable(R.drawable.btn_bg1));
                break;
            case R.id.img2:
                txt1.setTextColor(this.getResources().getColor(R.color.mblue));//通过获得资源文件进行设置。
                d1.setBackground(this.getResources().getDrawable(R.drawable.btn_bg1));
                txt2.setTextColor(this.getResources().getColor(R.color.mred));//通过获得资源文件进行设置。
                d2.setBackground(this.getResources().getDrawable(R.drawable.btn_bg2));
                txt3.setTextColor(this.getResources().getColor(R.color.mblue));//通过获得资源文件进行设置。
                d3.setBackground(this.getResources().getDrawable(R.drawable.btn_bg1));

                break;
            case R.id.img3:
                txt1.setTextColor(this.getResources().getColor(R.color.mblue));//通过获得资源文件进行设置。
                d1.setBackground(this.getResources().getDrawable(R.drawable.btn_bg1));
                txt2.setTextColor(this.getResources().getColor(R.color.mblue));//通过获得资源文件进行设置。
                d2.setBackground(this.getResources().getDrawable(R.drawable.btn_bg1));
                txt3.setTextColor(this.getResources().getColor(R.color.mred));//通过获得资源文件进行设置。
                d3.setBackground(this.getResources().getDrawable(R.drawable.btn_bg2));
                break;
            case R.id.img4:
                break;
            case R.id.img5:
                break;
            case R.id.img6:
                break;
            case R.id.img7:
                break;
            case R.id.img8:
                break;
            case R.id.img9:
                break;
            case R.id.img10:
                break;
            case R.id.img11:
                break;
            case R.id.img12:
                break;
            case R.id.filsh:
                finish();
                break;
        }
    }
}
