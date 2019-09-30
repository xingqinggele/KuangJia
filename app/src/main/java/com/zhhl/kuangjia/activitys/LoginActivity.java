package com.zhhl.kuangjia.activitys;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qgl on 2019/9/30 9:07.
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;
    private String user;
    private String pass;

    @Override
    protected int getLayoutId() {
        return R.layout.loginactivity;
    }

    @Override
    protected void initView() {
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ("".equals(username.getText().toString().trim())) {
                    login.setEnabled(false);
                } else {
                    if (!password.getText().toString().trim().equals(""))
                    {
                        login.setEnabled(true);
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ("".equals(password.getText().toString().trim())) {
                    login.setEnabled(false);
                } else {
                    login.setEnabled(true);
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


}
