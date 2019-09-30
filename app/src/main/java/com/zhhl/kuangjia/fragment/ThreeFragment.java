package com.zhhl.kuangjia.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.activitys.EditingActivity;
import com.zhhl.kuangjia.activitys.MeEdition;
import com.zhhl.kuangjia.activitys.Mepersonal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by qgl on 2019/9/23 16:44.
 */
public class ThreeFragment extends Fragment {

    @BindView(R.id.logo)
    SimpleDraweeView logo;
    @BindView(R.id.zdf_r1)
    RelativeLayout zdfR1;
    @BindView(R.id.zdf_r2)
    RelativeLayout zdfR2;
    @BindView(R.id.th_editing)
    RelativeLayout th_editing;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.threefragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    // TODO: Rename and change types and number of parameters
    public static ThreeFragment newInstance(String requestJson) {
        ThreeFragment fragment = new ThreeFragment();
        Bundle args = new Bundle();
//        args.putString("requestJson", requestJson);
//        args.putString("gid", gid);
//        args.putString("idno", idno);
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({R.id.zdf_r1, R.id.zdf_r2, R.id.th_editing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zdf_r1:
                Intent intent = new Intent(getActivity(), Mepersonal.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.zdf_r2:
                Intent intent1 = new Intent(getActivity(), MeEdition.class);
                startActivityForResult(intent1, 2);
                break;
            case R.id.th_editing:
                Intent intent2 = new Intent(getActivity(), EditingActivity.class);
                startActivityForResult(intent2, 3);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == -1) {
                    Toast.makeText(getActivity(), "退出了登录", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "回调了", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                break;
            case 3:
                if (resultCode == -1) {
                    Toast.makeText(getActivity(), "保存资料了", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
