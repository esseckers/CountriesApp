package com.countrytable.view.fragment;

import android.view.View;
import android.widget.ListView;

import com.countrytable.R;
import com.countrytable.model.Country;
import com.countrytable.remote.RemoteManager;
import com.countrytable.view.adapter.CountriesAdapter;
import com.countrytable.view.annotation.Layout;

import java.util.List;

import butterknife.Bind;

@Layout(R.layout.fragm_countries)
public class CountriesTableFragment extends AbstractFragment {

    @Bind(R.id.lv_countries)
    ListView lvCountries;

    private CountriesAdapter countriesAdapter;

    @Override
    protected void initView(View view) {
        countriesAdapter = new CountriesAdapter(getActivity(), R.layout.item_country);
        lvCountries.setAdapter(countriesAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        RemoteManager.getCountries(new SimpleRemoteServiceCallback<List<Country>>() {
            @Override
            public void onSuccess(List<Country> result) {
                if (result != null) {
                    countriesAdapter.addAll(result);
                }
            }
        });
    }
}
