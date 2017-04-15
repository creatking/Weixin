package com.bignerdranch.android.weixin;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mDatas;
    private TextView mNoteTextView;
    private TextView mArticleTextView;
    private TextView mFriendTextView;
    private TextView mSelfTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mNoteTextView=(TextView)findViewById(R.id.id_tv_note);
        mArticleTextView=(TextView)findViewById(R.id.id_tv_article);
        mFriendTextView=(TextView)findViewById(R.id.id_tv_friend);
        mSelfTextView=(TextView)findViewById(R.id.id_tv_self);

        mDatas = new ArrayList<Fragment>();
        NoteMainTabFragment tab01 = new NoteMainTabFragment();
        ArticleMainTabFragment tab02 = new ArticleMainTabFragment();
        FriendMainTabFragment tab03 = new FriendMainTabFragment();
        SelfMainTabFragment tab04 = new SelfMainTabFragment();
        mDatas.add(tab01);
        mDatas.add(tab02);
        mDatas.add(tab03);
        mDatas.add(tab04);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int arg0) {
                return mDatas.get(arg0);
            }

            @Override
            public int getCount() {
                return mDatas.size();
            }
        };
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int arg0) {
                resetTextView();
                switch (arg0){
                    case 0:
                        mNoteTextView.setTextColor(Color.GREEN);
                        break;
                    case 1:
                        mArticleTextView.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        mFriendTextView.setTextColor(Color.GREEN);
                        break;
                    case 3:
                        mSelfTextView.setTextColor(Color.GREEN);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
            protected void resetTextView(){
                mNoteTextView.setTextColor(Color.BLACK);
                mArticleTextView.setTextColor(Color.BLACK);
                mFriendTextView.setTextColor(Color.BLACK);
                mSelfTextView.setTextColor(Color.BLACK);
            }
        });
    }
}
