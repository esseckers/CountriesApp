package com.countrytable.view.activity;

import android.app.Fragment;

import com.countrytable.R;
import com.countrytable.controller.error.ActivityErrorHandler;
import com.countrytable.controller.transit.MainTransitManager;
import com.countrytable.view.fragment.CountriesTableFragment;

public class MainActivity extends AbstractActivity {

    @Override
    protected void createErrorHandler() {
        errorHandler = new ActivityErrorHandler(this);
    }

    @Override
    protected Class<? extends Fragment> getFragmentForStart() {
        return CountriesTableFragment.class;
    }

    @Override
    protected void createTransitManager() {
        transitManager = new MainTransitManager(this);
    }

    @Override
    protected int getActivityLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected int getMainFragmentContainerRes() {
        return R.id.fragment_container;
    }
}
