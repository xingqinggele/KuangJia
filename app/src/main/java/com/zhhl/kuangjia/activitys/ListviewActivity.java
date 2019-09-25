package com.zhhl.kuangjia.activitys;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.adapter.Listadapter;
import com.zhhl.kuangjia.base.BaseActivity;
import com.zhhl.kuangjia.bean.Databean;
import com.zhhl.kuangjia.bean.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qgl on 2019/9/20 14:33.
 */
public class ListviewActivity extends BaseActivity implements PullLoadMoreRecyclerView.PullLoadMoreListener {

    @BindView(R.id.one_listview)
    PullLoadMoreRecyclerView oneListview;
    private RecyclerView mRecyclerView;
    Listadapter listAdapter;
    List<Databean> datalist;
    private int mCount = 1;
    @BindView(R.id.filsh)
    RelativeLayout filsh;
    @BindView(R.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title.setText("ListViewActivity");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.listviewactivity;
    }

    @Override
    protected void initView() {
        //获取mRecyclerView对象
        mRecyclerView = oneListview.getRecyclerView();
        //代码设置scrollbar无效？未解决！
        mRecyclerView.setVerticalScrollBarEnabled(true);
        //设置下拉刷新是否可见
//        oneListview.setRefreshing(true);
        //设置是否可以下拉刷新
//        oneListview.setPullRefreshEnable(true);
        //设置是否可以上拉刷新
        oneListview.setPushRefreshEnable(true);
        //显示下拉刷新
        oneListview.setRefreshing(false);
        //设置上拉刷新文字
        oneListview.setFooterViewText("loading");
        //设置上拉刷新文字颜色
//        oneListview.setFooterViewTextColor(R.color.mred);
        //设置加载更多背景色
//        oneListview.setFooterViewBackgroundColor(R.color.white);
        oneListview.setLinearLayout();
        oneListview.setOnPullLoadMoreListener(this);

        listAdapter = new Listadapter(this);
        oneListview.setAdapter(listAdapter);

    }

    @Override
    protected void initData() {
        datalist = new ArrayList<Databean>();
        for (int i = 0; i <= 5; i++) {
            Databean newslistBean = new Databean();
            newslistBean.setName("这是第" + i + "个新闻的标题");
            newslistBean.setPass("这是第" + i + "个新闻的内容");
            datalist.add(newslistBean);
        }


        listAdapter.addAllData(datalist);
        oneListview.setPullLoadMoreCompleted();
    }

    private void setRefresh() {
        listAdapter.clearData();
        mCount = 1;
    }

    @Override
    public void onRefresh() {
        setRefresh();
        initData();
    }

    @Override
    public void onLoadMore() {
        mCount = mCount + 1;
        initData();
    }

    @OnClick(R.id.filsh)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.filsh:
                finish();
                break;
        }
    }
}
