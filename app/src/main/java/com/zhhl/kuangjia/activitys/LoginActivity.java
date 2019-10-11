package com.zhhl.kuangjia.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zhhl.kuangjia.MainActivity;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.RegisterActivity;
import com.zhhl.kuangjia.base.BaseActivity;
import com.zhhl.kuangjia.bean.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.register)
    TextView register;
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
                    if (!password.getText().toString().trim().equals("")) {
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
                    if (!username.getText().toString().trim().equals(""))
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




    @OnClick({R.id.register,R.id.login})
    public void onViewClicked(View view) {
        user = username.getText().toString().trim();
        pass = password.getText().toString().trim();
        switch (view.getId()){
            case R.id.login:
                List<User> user1 = User.find(User.class, "name = ?",user);
                for (int i = 0; i <= user1.size()-1 ; i++) {
                    shouLog("LoginActivity", user1.get(i).getName());
                    shouLog("LoginActivity", user1.get(i).getPassword());
                    shouLog("LoginActivity", user1.get(i).getId()+"");

                    if (pass.equals(user1.get(i).getPassword()))
                    {
                        showToast("登录成功");
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }




                break;
            case R.id.register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
