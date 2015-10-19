package com.countrytable.controller.transit;

import android.app.Activity;

import com.countrytable.view.fragment.CountriesTableFragment;
import com.countrytable.view.fragment.MainMapFragment;
import com.fsm.transit.core.AbstractTransitManager;
import com.fsm.transit.core.TransitData;
import com.fsm.transit.core.TransitResultData;

public class MainTransitManager extends AbstractTransitManager<FragmentAction> {

    /**
     * Pass {@link Activity} in args
     *
     * @param activity {@link Activity}
     */
    public MainTransitManager(Activity activity) {
        super(activity);
    }

    {
        transitionsMap.put(new TransitData<FragmentAction>(CountriesTableFragment.class, FragmentAction.FRAGM_MAP), new TransitResultData<FragmentAction>(MainMapFragment.class, true));
    }
}
