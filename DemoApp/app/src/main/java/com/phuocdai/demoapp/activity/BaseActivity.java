package com.phuocdai.demoapp.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.phuocdai.demoapp.R;

public abstract class BaseActivity extends Activity implements OnClickListener {

    protected Context mContext;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setupView();
    }

    /**
     * setup view for activity
     */
    protected void setupView() {

    }

    @Override
    public void onClick(View v) {

    }

    protected void cleanData() {

    }

    /**
     * setup actionBar
     * @param showHomeAsUp - show homeAsUp
     * @param showTitle - show title of action bar
     */
    public void setupActionBar(boolean showHomeAsUp, boolean showTitle) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(showHomeAsUp);
            actionBar.setDisplayShowTitleEnabled(showTitle);
        }
    }

    /**
     * Show loading dialog
     */
    public void showDialogLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()){
            return;
        }
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setMessage(getString(R.string.BaseActivity_mess_loading));
            mProgressDialog.setCancelable(false);
            mProgressDialog.setCanceledOnTouchOutside(false);
        }
        mProgressDialog.show();
    }

    /**
     * Dismiss Loading dialog
     */
    public void DismissDialogLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
}
