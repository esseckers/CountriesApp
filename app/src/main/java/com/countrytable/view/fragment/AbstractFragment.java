package com.countrytable.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.countrytable.controller.error.ErrorHandler;
import com.countrytable.controller.transit.FragmentAction;
import com.countrytable.remote.IRemoteServiceCallback;
import com.countrytable.remote.model.Fail;
import com.countrytable.view.activity.AbstractActivity;
import com.countrytable.view.annotation.Layout;
import com.fsm.transit.core.ITransitManager;

import butterknife.ButterKnife;

public abstract class AbstractFragment extends Fragment {
    private ErrorHandler errorHandler;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getViewLayout(), container, false);
        ButterKnife.bind(this, view);
        initView(view);
        initView(view, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        initView(view, null);
    }

    protected void initView(View view, Bundle bundle) {
    }

    protected int getViewLayout() {
        Layout layout = this.getClass().getAnnotation(Layout.class);
        return layout != null ? layout.value() : 0;
    }

    /**
     * special fragment manager, do all switch use this object.
     *
     * @return instance of {@link com.fsm.transit.core.ITransitManager}
     */
    public ITransitManager<FragmentAction> getTransitManager() {
        if (getActivity() != null) {
            return ((AbstractActivity) getActivity()).getTransitManager();
        } else {
            return null;
        }
    }

    /**
     * get Error Handler for handling error
     */
    public ErrorHandler getErrorHandler() {
        if (getActivity() != null) {
            return ((AbstractActivity) getActivity()).getErrorHandler();
        } else {
            return null;
        }
    }

    public abstract class SimpleRemoteServiceCallback<T> implements IRemoteServiceCallback<T> {

        @Override
        public void onStartTask() {
            errorHandler = getErrorHandler();
            if (errorHandler != null) {
                errorHandler.manageLoadDialog(true);
            }
        }

        @Override
        public void onFailure(Fail fail) {
            if (errorHandler != null) {
                errorHandler.handleFail(fail);
            }
        }

        @Override
        public void onSuccess(T result) {
        }

        @Override
        public void onFinishTask() {
            if (errorHandler != null) {
                errorHandler.manageLoadDialog(false);
            }
        }
    }
}
