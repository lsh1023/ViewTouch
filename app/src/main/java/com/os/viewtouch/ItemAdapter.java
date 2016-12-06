package com.os.viewtouch;

import android.content.Context;
import android.widget.TextView;

import com.os.viewtouch.base.BaseRecyclerAdapter;
import com.os.viewtouch.base.BaseRecyclerHolder;

import java.util.List;

/**
 * @ explain:
 * @ author：xujun on 2016/10/25 15:21
 * @ email：gdutxiaoxu@163.com
 */
public class ItemAdapter extends BaseRecyclerAdapter<String> {

    public ItemAdapter(Context context, List<String> datas) {
        super(context, R.layout.item_string, datas);
    }

    @Override
    public void convert(BaseRecyclerHolder holder, String item, int position) {
        TextView tv=holder.getView(R.id.tv);
        String s = mDatas.get(position);
        tv.setText(s);
    }
}
