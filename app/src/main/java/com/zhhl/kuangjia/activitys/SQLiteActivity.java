package com.zhhl.kuangjia.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;
import com.zhhl.kuangjia.bean.User;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/9/25 8:44.
 */
public class SQLiteActivity extends BaseActivity {
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.sq_btn1)
    Button sqBtn1;
    @BindView(R.id.sq_btn11)
    Button sqBtn11;
    @BindView(R.id.sq_btn2)
    Button sqBtn2;
    @BindView(R.id.sq_btnn22)
    Button sqBtnn22;
    @BindView(R.id.sq_btn3)
    Button sqBtn3;
    @BindView(R.id.sq_btn33)
    Button sqBtn33;
    @BindView(R.id.sq_btn4)
    Button sqBtn4;
    @BindView(R.id.sq_btn44)
    Button sqBtn44;

    @Override
    protected int getLayoutId() {
        return R.layout.sqliteactivity;
    }

    @Override
    protected void initView() {
        title.setText("SQLiteActivity");

    }

    @Override
    protected void initData() {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.filsh,R.id.sq_btn1, R.id.sq_btn11, R.id.sq_btn2, R.id.sq_btnn22, R.id.sq_btn3, R.id.sq_btn33, R.id.sq_btn4, R.id.sq_btn44})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.filsh:
                finish();
                break;
            case R.id.sq_btn1:
                User user = new User("青格乐1", "123", "男");
                user.save();
                break;
            case R.id.sq_btn11:
                for (int i = 1; i <= 5; i++) {
                    User newslistBean = new User();
                    newslistBean.setName("青格勒" + i);
                    newslistBean.setPassword("密码" + i);
                    newslistBean.setSex("男" + i);
                    newslistBean.save();
                }
                break;
            case R.id.sq_btn2:
                User user1 = User.findById(User.class, 47);
                String name = user1.getName();
                String password = user1.getPassword();
                String sex = user1.getSex();
                shouLog("SQLiteActivity1", name + password + sex);
                break;
            case R.id.sq_btnn22:
                List<User> user2 = User.listAll(User.class);
                for (int i = 0; i <= user2.size() - 1; i++) {
                    shouLog("SQLiteActivity1", user2.get(i).getName());
                    shouLog("SQLiteActivity2", user2.get(i).getPassword());
                    shouLog("SQLiteActivity3", user2.get(i).getSex());
                    shouLog("SQLiteActivity4", user2.get(i).getId()+"");

                }
                break;
            case R.id.sq_btn3:
                List<User> user3 = User.find(User.class, "name = ?", "青格乐1");
                for (int i = 0; i <= user3.size() - 1; i++) {
                    shouLog("SQLiteActivity3", user3.get(i).getName());
                    shouLog("SQLiteActivity3", user3.get(i).getPassword());
                    shouLog("SQLiteActivity3", user3.get(i).getSex());
                    shouLog("SQLiteActivity4", user3.get(i).getId()+"");

                }
                break;
            case R.id.sq_btn33:
                User user4 = User.findById(User.class, 47);
                user4.setName("希拉里");
                user4.save();
                break;
            case R.id.sq_btn4:
                User user5 = User.findById(User.class, 1);
                user5.delete();
                break;
            case R.id.sq_btn44:
                User.deleteAll(User.class);
                break;

        }
    }
}
