package com.countrytable.view.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.countrytable.controller.error.ErrorHandler;
import com.countrytable.controller.transit.FragmentAction;
import com.fsm.transit.core.ITransitManager;


public abstract class AbstractActivity extends AppCompatActivity {

    protected ITransitManager<FragmentAction> transitManager;
    protected ErrorHandler errorHandler;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayoutRes());
        createErrorHandler();
        createTransitManager();
        if (getTransitManager() != null) {
            getTransitManager().setCurrentContainer(getMainFragmentContainerRes());
        }
        initStartFragment(savedInstanceState);
        initView();
    }

    protected void initStartFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Class<? extends Fragment> clazz = getFragmentForStart();
            if (clazz != null) {
                getTransitManager().switchFragment(getFragmentForStart(), getIntent().getExtras(), false);
            }
        }
    }

    protected void initView() {
    }

    public ITransitManager<FragmentAction> getTransitManager() {
        return transitManager;
    }

    public ErrorHandler getErrorHandler() {
        return errorHandler;
    }

    protected abstract void createErrorHandler();


    protected abstract Class<? extends Fragment> getFragmentForStart();

    protected abstract void createTransitManager();

    protected abstract int getActivityLayoutRes();

    protected abstract int getMainFragmentContainerRes();


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1 && getTransitManager() != null)
            getTransitManager().back();
        else
            finish();
    }
}
