package com.zhhl.kuangjia;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhhl.kuangjia.base.BaseActivity;
import com.zhhl.kuangjia.bean.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/10/10 15:15.
 */
public class RegisterActivity extends BaseActivity {
    @BindView(R.id.rename)
    EditText rename;
    @BindView(R.id.repass)
    EditText repass;
    @BindView(R.id.regis)
    Button regis;
    private String name ;
    private String pass ;

    @Override
    protected int getLayoutId() {
        return R.layout.registeractivity;
    }

    @Override
    protected void initView() {
        rename.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if ("".equals(rename.getText().toString().trim())) {
                    regis.setEnabled(false);
                } else {
                    if (!repass.getText().toString().trim().equals("")) {
                        regis.setEnabled(true);
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        repass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ("".equals(repass.getText().toString().trim())) {
                    regis.setEnabled(false);
                } else {
                    if (!rename.getText().toString().trim().equals("")) {
                        regis.setEnabled(true);
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initData() {

    }



    @OnClick(R.id.regis)
    public void onViewClicked(View view) {
        name = rename.getText().toString().trim();
        pass = repass.getText().toString().trim();
        switch (view.getId()){
            case R.id.regis:
                User user = new User(name,pass);
                user.save();
                break;
        }
    }
}
