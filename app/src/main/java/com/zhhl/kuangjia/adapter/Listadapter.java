package com.zhhl.kuangjia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.bean.Databean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qgl on 2019/9/20 14:44.
 */
public class Listadapter extends RecyclerView.Adapter<Listadapter.ViewHolder> {

    private Context mContext;
    private List<Databean> dataList = new ArrayList<>();

    public void addAllData(List<Databean> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void clearData() {
        this.dataList.clear();
    }

    public Listadapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.key_name.setText(dataList.get(position).getName());
        holder.pass.setText(dataList.get(position).getPass());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView key_name;
        public TextView pass;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            key_name = itemView.findViewById(R.id.name);
            pass = itemView.findViewById(R.id.pass);

        }
    }
}
