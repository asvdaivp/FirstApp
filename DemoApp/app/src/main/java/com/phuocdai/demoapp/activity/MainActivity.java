package com.phuocdai.demoapp.activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;

import com.phuocdai.demoapp.R;
import com.phuocdai.demoapp.fragment.BlankFragment;
import com.phuocdai.demoapp.fragment.TagFragment;
import com.phuocdai.demoapp.listener.TabListener;


public class MainActivity extends BaseActivity {

    ActionBar.Tab tagTab,blankTab;
    Fragment tagFragment = new TagFragment();
    Fragment blankFragment = new BlankFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setupView() {
        super.setupView();
        setContentView(R.layout.activity_main);
        setupActionBar(false, true);
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab = actionBar.newTab()
                .setText("aaa")
                .setTabListener(new TabListener<TagFragment>(
                        this, "artist", TagFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("bbb")
                .setTabListener(new TabListener<BlankFragment>(
                        this, "album", BlankFragment.class));
        actionBar.addTab(tab);
    }



}
