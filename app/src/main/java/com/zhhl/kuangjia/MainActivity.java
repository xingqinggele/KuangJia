package com.zhhl.kuangjia;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.toollibrary.okhttp.exception.OkHttpException;
import com.example.toollibrary.okhttp.listener.DisposeDataListener;
import com.example.toollibrary.okhttp.request.RequestParams;
import com.zhhl.kuangjia.activitys.TableActivity;
import com.zhhl.kuangjia.base.BaseActivity;
import com.zhhl.kuangjia.fragment.OneFragment;
import com.zhhl.kuangjia.fragment.ThreeFragment;
import com.zhhl.kuangjia.fragment.TwoFragment;
import com.zhhl.kuangjia.uri.RequestCenter;
import com.zhhl.kuangjia.view.DragFloatActionButton;


import butterknife.BindView;
import butterknife.OnClick;

public class   MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String[] BASIC_PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
    };
    private static int REQUEST_PERMISSION_CODE = 1;

    @BindView(R.id.floatbutton)
    DragFloatActionButton floatbutton;
    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.rb_message)
    RadioButton rbMessage;
    @BindView(R.id.rb_address)
    RadioButton rbAddress;
    @BindView(R.id.rb_work)
    RadioButton rbWork;
    @BindView(R.id.rg_footer)
    RadioGroup rgFooter;
    boolean isgowork = false;
    boolean isgoaddress = false;
    boolean isgoagency = false;
    private FragmentTransaction transaction;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, BASIC_PERMISSIONS, REQUEST_PERMISSION_CODE);
            }
        }
        rgFooter.setOnCheckedChangeListener(this);
        rgFooter.check(R.id.rb_message);

        // 我们首先新建一个本地分支“test02”，然后做出一些修改后commit。如图：
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        isgowork = intent.getBooleanExtra("isgowork", false);
        isgoaddress = intent.getBooleanExtra("isgoaddress", false);
        if (isgowork) {
            rbMessage.performClick();
        }
        if (isgoaddress) {
            rbAddress.performClick();
        }
        if (isgoagency) {
            rbWork.performClick();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        hideAllFragment(transaction);
        switch (i) {
            case R.id.rb_message:
                if (oneFragment == null) {
                    oneFragment = new OneFragment().newInstance("requestJson");

                    transaction.add(R.id.content, oneFragment);
                } else {
                    transaction.show(oneFragment);
                }
                break;

            case R.id.rb_address:
                if (twoFragment == null) {
                    twoFragment = new TwoFragment().newInstance("");
                    transaction.add(R.id.content, twoFragment);
                } else {
                    transaction.show(twoFragment);
                }
                break;
            case R.id.rb_work:
                if (threeFragment == null) {
                    threeFragment = new ThreeFragment().newInstance("");
                    transaction.add(R.id.content, threeFragment);
                } else {
                    transaction.show(threeFragment);
                }

                break;
        }
        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (oneFragment != null) this.transaction.hide(oneFragment);
        if (twoFragment != null) this.transaction.hide(twoFragment);
        if (threeFragment != null) this.transaction.hide(threeFragment);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
    }

    @OnClick(R.id.floatbutton)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.floatbutton:
                Intent intent = new Intent(MainActivity.this, TableActivity.class);
                startActivity(intent);
                break;

        }
    }
}
