package com.viremtechnologies.backbone.module.baseFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viremtechnologies.backbone.module.baseActivities.BaseActivity;


public abstract class BaseFragment extends Fragment {

    protected View parentView;

    protected Context context;

    private BaseActivity activity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayoutResource(), container, false);
        initView(parentView);
        return parentView;
    }


    public abstract int getLayoutResource();

    public abstract void initView(View view);

    protected void hideKeyboard() {
        if(getActivity() instanceof BaseActivity)   {
            activity =  (BaseActivity) getActivity();
            activity.hideKeyboard();
        }

    }
}
