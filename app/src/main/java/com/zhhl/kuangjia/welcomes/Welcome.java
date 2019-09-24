package com.zhhl.kuangjia.welcomes;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.toollibrary.Utils.ILogUploadImpl;
import com.example.toollibrary.activity.BaseActivity;
import com.example.toollibrary.bean.CardInfo;
import com.example.toollibrary.bean.LoginBean;
import com.example.toollibrary.listener.CallBack;
import com.example.toollibrary.listener.PermissionListener;
import com.example.toollibrary.projectwrapper.SplashActivityWrapper;

import java.util.List;

/**
 * Created by qgl on 2019/9/19 16:28.
 */
public class Welcome extends SplashActivityWrapper
{
//    private static String[] PERMISSIONS_STORAGE = {
//            "android.permission.READ_EXTERNAL_STORAGE",
//            "android.permission.WRITE_EXTERNAL_STORAGE",
//            "android.permission.ACCESS_FINE_LOCATION"};




    @Override
    public void login(String s, LoginBean loginBean)
    {
        Log.e("ok","OK");
        Log.e("ok",loginBean.getId());
//        机构信息
        getCardInfo(new CallBack() {
            @Override
            public void onSuccess(String var) {
//                tv2.setText(CardInfo.create(var).getObj().getDepName());
                Log.e("aaaaa", CardInfo.create(var).getObj().getDepName());
            }

            @Override
            public void onError(String var) {
                Log.e("aaaaa", var);

            }
        });

    }

    @Override
    public void uaacApiError(String s) {
        Log.e("NO","NO");


    }


//    @Override
//    protected void getCardInfo(final CallBack callBack)
//    {

//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        new ILogUploadImpl("调起的参数","1","返回的参数").sendLog();

    }

//    public void Jurisdiction() {
//        requestRuntimePermissions(PERMISSIONS_STORAGE, new PermissionListener() {
//            @Override
//            public void granted() {
//                //权限申请通过
//            }
//
//            @Override
//            public void denied(List<String> deniedList) {
//                //权限申请未通过
//                for (String denied : deniedList) {
//                    if (denied.equals("android.permission.ACCESS_FINE_LOCATION")) {
//
//                        Toast.makeText(Welcome.this, "请检查是否打开定位权限！", Toast.LENGTH_LONG).show();
//
//                    } else {
//
//                        Toast.makeText(Welcome.this, "请检查是否打开！", Toast.LENGTH_LONG).show();
//
//                    }
//                }
//            }
//        });
//    }





}
