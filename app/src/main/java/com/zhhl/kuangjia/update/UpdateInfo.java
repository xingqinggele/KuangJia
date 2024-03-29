package com.zhhl.kuangjia.update;


import com.zhhl.kuangjia.R;

/**
 * Created by  Marlon on 2018/1/23.
 * Describe 更新信息
 */
public class UpdateInfo {

    // 是否静默下载：有新版本时不提示直接下载
    public boolean isSilent = false;

    // 是否强制安装：不安装无法使用app
    public boolean isForce = false;
    // 是否可忽略该版本
    public boolean isIgnorable = true;

    public int versionCode;
    public String versionName;
    public String updateContent;
    public long size;

    /**
     * Dialog 提示文字自定义
     * 国际化适配
     */
    public int title = R.string.update_app_title; //提示
    public int confirm = R.string.update_app_confirm;  //确定
    public int updateNow = R.string.update_app_updateNow; //立即更新
    public int laterSay = R.string.update_app_tlaterSay; //稍后再说
    public int ignorable = R.string.update_app_ignorable; //忽略



}
