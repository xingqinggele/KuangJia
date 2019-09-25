package com.zhhl.kuangjia.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.adapter.Listadapter;
import com.zhhl.kuangjia.bean.Databean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by qgl on 2019/9/23 16:43.
 */
public class TwoFragment extends Fragment implements PullLoadMoreRecyclerView.PullLoadMoreListener {
    @BindView(R.id.one_search_input)
    EditText oneSearchInput;
    @BindView(R.id.one_listview)
    PullLoadMoreRecyclerView oneListview;
    RecyclerView mRecyclerView;
    Listadapter listAdapter;
    List<Databean> datalist;
    private int mCount = 1;
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.twofragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    // TODO: Rename and change types and number of parameters
    public static TwoFragment newInstance(String requestJson) {
        TwoFragment fragment = new TwoFragment();
        Bundle args = new Bundle();
//        args.putString("requestJson", requestJson);
//        args.putString("gid", gid);
//        args.putString("idno", idno);
        fragment.setArguments(args);
        return fragment;
    }

    public void initView() {
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
        listAdapter = new Listadapter(getActivity());
        oneListview.setAdapter(listAdapter);

    }

    public void initData() {
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
