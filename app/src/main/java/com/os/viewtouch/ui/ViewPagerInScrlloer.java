package com.os.viewtouch.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.os.viewtouch.BaseViewPagerAdapter;
import com.os.viewtouch.ItemAdapter;
import com.os.viewtouch.R;
import com.os.viewtouch.base.RecyclerUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xujun
 * @explain 这个Activity是用来演示ScrollView里面嵌套ViewPager的外部解决法的
 * @time 2016/10/25 15:43.
 */
public class ViewPagerInScrlloer extends AppCompatActivity {
    ViewPager mViewPager;
    TextView mTextView;

    RecyclerView mRecyclerView;
    private List<Fragment> mFragments;
    private BaseViewPagerAdapter mBaseViewPagerAdapter;
    private ArrayList<String> mList;
    private ItemAdapter mItemAdapter;

   ScrollView mNoHorizontalScrollView;
    private boolean first=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_in_scrlloer);
        initView();


        initListener();

        initData();
    }


    private void scroll() {
        mNoHorizontalScrollView.scrollTo(0,0);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus  && first){
            first=false;
            scroll();
        }
    }

    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mTextView.setText(String.format("%d/8", position + 1));
            }
        });

    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTextView = (TextView) findViewById(R.id.tv_page);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mNoHorizontalScrollView=(ScrollView) findViewById(R.id.NoHorizontalScrollView);
    }

    private void initData() {


        mList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String s = String.format("我是第%d个测试Item", i);
            mList.add(s);
        }
        mItemAdapter = new ItemAdapter(this, mList);
        RecyclerUtils.init(mRecyclerView);
        mRecyclerView.setAdapter(mItemAdapter);

        mFragments = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ImageFragment imageFragment = ImageFragment.newInstance(R.drawable.huoying);
            mFragments.add(imageFragment);
        }

        mBaseViewPagerAdapter = new BaseViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mBaseViewPagerAdapter);

    }
}
