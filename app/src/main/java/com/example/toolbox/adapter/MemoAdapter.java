package com.example.toolbox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.toolbox.R;
import com.example.toolbox.bean.MemoBean;

import java.util.List;

public class MemoAdapter extends BaseAdapter {
    // 布局服务
    private LayoutInflater layoutInflater;
    private List<MemoBean> list;

    public MemoAdapter(Context context, List<MemoBean> list) {
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;

    }

    @Override
    public int getCount() {
        // 如果为空，返回0，否则返回其大小
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            // 如果convertView为空

            // 通过inflate()加载界面的布局文件
            convertView = layoutInflater.inflate(R.layout.memo_item_layout, null);
            // 创建一个ViewHolder对象，并初始化内容和时间
            viewHolder = new ViewHolder(convertView);
            // 通过setTag()将其添加到convertView进行缓存
            convertView.setTag(viewHolder);
        } else {
            // 如果convertView不为空
            // 直接使用getTag方法进行获取
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MemoBean memoInfo = (MemoBean)getItem(position);
        viewHolder.tvMemoContent.setText(memoInfo.getMemoContent());
        viewHolder.tvMemoTime.setText(memoInfo.getMemoTime());
        return convertView;
    }

    class ViewHolder {
        TextView tvMemoContent;
        TextView tvMemoTime;

        // 构造方法，用于初始化item界面中的控件
        public ViewHolder(View view) {
            tvMemoContent = (TextView) view.findViewById(R.id.item_content);
            tvMemoTime = (TextView) view.findViewById(R.id.item_time);
        }
    }
}
