package com.zhhl.kuangjia.welcomes;

import android.os.Bundle;
import android.widget.Toast;

import com.example.toollibrary.activity.BaseActivity;
import com.example.toollibrary.listener.PermissionListener;

import java.util.List;

/**
 * Created by qgl on 2019/9/19 16:28.
 */
public class Welcome extends BaseActivity {
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.ACCESS_FINE_LOCATION"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void Jurisdiction() {
        requestRuntimePermissions(PERMISSIONS_STORAGE, new PermissionListener() {
            @Override
            public void granted() {
                //权限申请通过
            }

            @Override
            public void denied(List<String> deniedList) {
                //权限申请未通过
                for (String denied : deniedList) {
                    if (denied.equals("android.permission.ACCESS_FINE_LOCATION")) {

                        Toast.makeText(Welcome.this, "请检查是否打开定位权限！", Toast.LENGTH_LONG).show();

                    } else {

                        Toast.makeText(Welcome.this, "请检查是否打开！", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }




}
