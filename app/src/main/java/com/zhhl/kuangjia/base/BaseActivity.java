package com.zhhl.kuangjia.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.gyf.barlibrary.ImmersionBar;

import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.update.NotificationInfo;
import com.zhhl.kuangjia.update.UpdateInfo;
import com.zhhl.kuangjia.update.UpdateManager;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by qgl on 2019/9/19 15:35.
 */
public abstract class BaseActivity extends FragmentActivity implements ViewTreeObserver.OnGlobalLayoutListener {
    private ImmersionBar mImmersionBar;//状态栏沉浸
    public static List<Activity> activitys;
    protected Context mContext;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statusBarConfig().init();
        if (activitys == null) {
            activitys = new ArrayList<Activity>();
        }
        activitys.add(this);
        mContext = this;
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
        ButterKnife.bind(this);
        initView();
        initData();
        /////TODO 穿裙子镇不住了。。。。
        Log.e("System:", " 快快请佛祖！！！");
        System.err.println("////////////////////////////////////////////////////////////////////\n" +
                "//                          _ooOoo_                               //\n" +
                "//                         o8888888o                              //\n" +
                "//                         88\" . \"88                              //\n" +
                "//                         (| ^_^ |)                              //\n" +
                "//                         O\\  =  /O                              //\n" +
                "//                      ____/`---'\\____                           //\n" +
                "//                    .'  \\\\|     |//  `.                         //\n" +
                "//                   /  \\\\|||  :  |||//  \\                        //\n" +
                "//                  /  _||||| -:- |||||-  \\                       //\n" +
                "//                  |   | \\\\\\  -  /// |   |                       //\n" +
                "//                  | \\_|  ''\\---/''  |   |                       //\n" +
                "//                  \\  .-\\__  `-`  ___/-. /                       //\n" +
                "//                ___`. .'  /--.--\\  `. . ___                     //\n" +
                "//              .\"\" '<  `.___\\_<|>_/___.'  >'\"\".                  //\n" +
                "//            | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |                 //\n" +
                "//            \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /                 //\n" +
                "//      ========`-.____`-.___\\_____/___.-`____.-'========         //\n" +
                "//                           `=---='                              //\n" +
                "//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //\n" +
                "//            佛祖保佑       永不宕机     永无BUG                 //\n" +
                "////////////////////////////////////////////////////////////////////");
    }

    /**
     * 初始化沉浸式状态栏
     */
    private ImmersionBar statusBarConfig() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.colorAccent)
                .statusBarDarkFont(statusBarDarkFont())    //默认状态栏字体颜色为黑色
                .keyboardEnable(false, WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                        | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
        //必须设置View树布局变化监听，否则软键盘无法顶上去，还有模式必须是SOFT_INPUT_ADJUST_PAN
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        return mImmersionBar;
    }

    /**
     * 获取状态栏字体颜色
     */
    public boolean statusBarDarkFont() {
        //返回false表示白色字体
        return false;
    }

    /**
     * 退出应用
     *
     * @param context
     */
    public void exitApp(Context context) {// 循环结束当前所有Activity
        for (Activity ac : activitys) {
            if (ac != null) {
                ac.finish();
            }
        }
    }

    //Toast
    public void showToast(String text) {
        Toast.makeText(BaseActivity.this, text + "", Toast.LENGTH_SHORT).show();
    }

    //Log
    public void shouLog(String Interface, String text) {
        Log.e(Interface, text + "");
    }

    @Override
    public void onGlobalLayout() {

    }

    //引入布局
    protected abstract int getLayoutId();

    //初始化控件
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    //升级
    public void upadateSystem() {
        updateApk(BaseActivity.this, "", "", true, true, 10000000, "", BaseActivity.this.getResources().getString(R.string.app_name));
    }

    /**
     * @param hitContent  提示更新内容
     * @param versionName 更新版本名
     * @param isForce     是否强制升级
     * @param isSlient    是否静默安装
     * @param fileSize    Apk文件大小
     * @param apkURL      Apk下载链接
     * @param apkName     Apk名称
     */
    public void updateApk(Context mContext, String hitContent, String versionName, boolean isForce, boolean isSlient, long fileSize, String apkURL, String apkName) {
        //不用害怕 根据英文名称直译就可以
        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.versionName = versionName;
        updateInfo.versionCode = 10;
        updateInfo.isForce = isForce;
        updateInfo.size = fileSize;
        updateInfo.updateContent = hitContent;
        if (isForce) {
            updateInfo.isIgnorable = false;
        }
        NotificationInfo notificationInfo = new NotificationInfo(R.mipmap.ic_launcher, R.mipmap.ic_launcher, apkName, "正在下载中", hitContent);
        new UpdateManager(mContext, apkURL, apkName, isSlient, updateInfo, notificationInfo).init();
    }

    /**
     * 获取本地软件版本号
     */
    public static int getLocalVersion(Context ctx) {
        int localVersion = 0;
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    /**
     * 获取本地软件版本号名称
     */
    public static String getLocalVersionName(Context ctx) {
        String localVersion = "";
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    //开启dialog
    public void onDialog(String text) {
        if (progressDialog == null)
            progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(text + "");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    //关闭dialog
    public void offDialog() {
        progressDialog.dismiss();
    }
}
