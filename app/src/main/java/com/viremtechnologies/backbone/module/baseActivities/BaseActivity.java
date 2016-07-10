package com.viremtechnologies.backbone.module.baseActivities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;

import com.viremtechnologies.backbone.R;


public abstract class BaseActivity extends TrackedActivity {


    protected int resultCode = RESULT_CANCELED;


    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


        ViewStub vs_container = (ViewStub) findViewById(R.id.vs_container);
        vs_container.setLayoutResource(getLayoutResource());
        vs_container.inflate();


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setHomeButtonEnabled(true);


        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle(getToolbarTitle());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        Intent intent = resultIntent();

        if (intent == null) {
            intent = new Intent();
            setResult(resultCode, intent);
        } else {
            setResult(RESULT_OK, intent);
        }

        super.finish();
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void setToolbarColor(int color) {
        toolbar.setBackgroundColor(color);
    }


    protected abstract int getToolbarTitle();


    protected void setToolbarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


    protected abstract int getLayoutResource();


    protected abstract Intent resultIntent();

}
