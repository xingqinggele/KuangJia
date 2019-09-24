package com.zhhl.kuangjia.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.adapter.FullyGridLayoutManager;
import com.zhhl.kuangjia.adapter.L_GridImageAdapter;
import com.zhhl.kuangjia.base.BaseActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by qgl on 2019/9/24 10:25.
 */
public class TableActivity extends BaseActivity {
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.iv_reason_more)
    TextView ivReasonMore;

    @BindView(R.id.btnMan)
    RadioButton btnMan;
    @BindView(R.id.btnWoman)
    RadioButton btnWoman;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    @BindView(R.id.tv_time_start)
    TextView tvTimeStart;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tj_btn)
    Button tjBtn;
    private OptionsPickerView reasonPicker;//时间;
    List<String> reasonlist = new ArrayList<>();
    @BindView(R.id.tv_reaseon)
    TextView tvReaseon;

    private L_GridImageAdapter adapter;
    //已经选择图片
    private List<LocalMedia> selectList = new ArrayList<>();
    //照片选择最大值
    private int maxSelectNum = 9;

    private String nianling;
    private String xingbie = "公";
    private String shijian;
    private String beizhu;


    @Override
    protected int getLayoutId() {
        return R.layout.tableactivity;
    }

    @Override
    protected void initView() {
        //性别
        RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                xingbie = radbtn.getText().toString();
                Toast.makeText(getApplicationContext(), "按钮组值发生年变,你选了" + radbtn.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void initData() {
        title.setText("录入Activity");
        initReason();
        init();
    }

    //年龄
    private void initReason() {
        reasonlist.add("1");
        reasonlist.add("2");
        reasonlist.add("3");
        reasonlist.add("4");
        reasonlist.add("5");
        reasonlist.add("6");
        reasonlist.add("7");
    reasonPicker = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
        @Override
        public void onOptionsSelect(int options1, int options2, int options3, View v) {
            tvReaseon.setText(reasonlist.get(options1) + " 岁");
        }
    }).setTitleText("请选择年龄").setContentTextSize(22).setTitleSize(22).setSubCalSize(21).build();
        reasonPicker.setPicker(reasonlist);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.tv_reaseon, R.id.tv_time_start, R.id.filsh, R.id.tj_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_reaseon:
                reasonPicker.show();
                break;
            case R.id.tv_time_start:
                selectTime(tvTimeStart);
                break;
            case R.id.filsh:
                finish();
                break;
            case R.id.tj_btn:
                postData();
                break;
        }
    }

    //时间
    private void selectTime(TextView textView) {
        TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                //设置时间
                textView.setText(getTime(date));

            }
        }).setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("", "月", "日", "时", "分", "秒")
                .build();
        pvTime.show();
    }

    //时间
    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    //图片
    private void init() {
        FullyGridLayoutManager manager = new FullyGridLayoutManager(mContext, 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new L_GridImageAdapter(mContext, onAddPicClickListener);
        adapter.setList(selectList);
        adapter.setSelectMax(maxSelectNum);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new L_GridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                PictureSelector.create(TableActivity.this).themeStyle(R.style.picture_default_style).openExternalPreview(position, selectList);
            }
        });

    }

    //图片
    private L_GridImageAdapter.onAddPicClickListener onAddPicClickListener = new L_GridImageAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {
            initSelectImage();
        }
    };

    //图片
    private void initSelectImage() {
        PictureSelector.create(TableActivity.this)
                .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .maxSelectNum(maxSelectNum)// 最大图片选择数量
                .minSelectNum(0)// 最小选择数量
                .imageSpanCount(4)// 每行显示个数
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选
                .previewImage(true)// 是否可预览图片
                .isCamera(true)// 是否显示拍照按钮
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                //.imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径
                .compress(true)// 是否压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .selectionMedia(selectList)// 是否传入已选图片
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code

    }

    //图片
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    for (LocalMedia media : selectList) {
                        Log.i("图片-----》", new File(media.getPath()).length() + "");
                        Log.i("压缩图片-----》", new File(media.getCompressPath()).length() + "");

//                        Bitmap bitmap = BitmapFactory.decodeFile(media.getCompressPath());
//                        iv_document.setImageBitmap(bitmap);
                        adapter.setList(selectList);
                        adapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    }

    //提交数据
    public void postData() {
        if (TextUtils.isEmpty(tvReaseon.getText().toString().trim()) || tvReaseon.getText().toString().trim().equals("请选择龄")) {
            showToast("请选择年龄");
            return;
        }
        if (TextUtils.isEmpty(tvTimeStart.getText().toString().trim()) || tvTimeStart.getText().toString().trim().equals("请选择时间")) {
            showToast("请选择时间");
            return;
        }

        if (TextUtils.isEmpty(etContent.getText().toString().trim())) {
            showToast("请输入备注");
            return;
        }

        nianling = tvReaseon.getText().toString().trim();
        shijian = tvTimeStart.getText().toString().trim();
        beizhu = etContent.getText().toString().trim();
        shouLog("TableActivity", nianling + "-->" + xingbie + "-->" + shijian + "-->" + beizhu);
        //上传多图时候用
        List<File> fils = new ArrayList<>();
        for (LocalMedia imgurl : selectList) {
            fils.add(new File(imgurl.getPath()));
            shouLog("TableActivity", imgurl.getPath());
        }

    }

}
