package com.zhhl.kuangjia.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.toollibrary.Utils.ILogUploadImpl;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.activitys.CeshiActivity;
import com.zhhl.kuangjia.activitys.JieTuActivity;
import com.zhhl.kuangjia.activitys.ShuiyinActivity;
import com.zhhl.kuangjia.activitys.TableActivity;

import java.io.File;
import java.io.FileOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by qgl on 2019/9/23 16:43.
 */
public class OneFragment extends Fragment {

    @BindView(R.id.txt1)
    TextView txt1;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    Unbinder unbinder;
    private static final String ARG = "arg";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onefragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        txt1.setText(getArguments().getString( ARG));
//        new ILogUploadImpl("调起的参数","1","返回的参数").sendLog();
        return view;
    }

    // TODO: Rename and change types and number of parameters
    public static OneFragment newInstance(String requestJson) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        args.putString(ARG, requestJson);
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({R.id.btn1, R.id.btn2,R.id.btn3,R.id.btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Intent intent = new Intent(getActivity(), CeshiActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.btn2:
                //截图
                btn2.setVisibility(View.GONE);
                View dView = getActivity().getWindow().getDecorView();
                dView.destroyDrawingCache();
                dView.setDrawingCacheEnabled(false);
                dView.buildDrawingCache();
                Bitmap bitmap = Bitmap.createBitmap(dView.getDrawingCache());
                if (bitmap != null) {
                    try {
                        // 获取内置SD卡路径
                        String sdCardPath = Environment.getExternalStorageDirectory().getPath();
                        // 图片文件路径
                        String filePath = sdCardPath + File.separator + System.currentTimeMillis() + "screenshot.png";
                        File file = new File(filePath);
                        FileOutputStream os = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);
                        os.flush();
                        os.close();
                        btn2.setVisibility(View.VISIBLE);
                        Intent intent1 = new Intent(getActivity(), JieTuActivity.class);
                        intent1.putExtra("file", filePath);
                        getActivity().startActivity(intent1);
                    } catch (Exception e) {
                    }
                }
                break;
            case R.id.btn3:
                Intent intent1 = new Intent(getActivity(), TableActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn4:
                Intent intent2 = new Intent(getActivity(), ShuiyinActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == -1) {
                    if (data != null) {
                        txt1.setText(data.getStringExtra("pass_data"));
                    }
                } else if (resultCode == 2) {
                    if (data != null) {
                        txt1.setText(data.getStringExtra("name"));
                    }
                }
                break;
        }
    }




}
