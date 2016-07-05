package com.viremtechnologies.backbone;

import android.view.View;

public class MainActivity extends BaseDrawerActivity {



    @Override
    protected void initViews() {
        super.initViews();
        activateFloatingButton(true);
    }

    @Override
    protected int getBaseLayout() {
        return R.layout.activity_base_drawer;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListeners() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected boolean isFloatingButtonVisible() {
        return false;
    }
}
