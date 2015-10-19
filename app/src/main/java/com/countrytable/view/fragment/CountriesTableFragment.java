package com.countrytable.view.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.countrytable.R;
import com.countrytable.controller.transit.FragmentAction;
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

    @Bind(R.id.tv_refresh)
    TextView tvRefresh;

    private CountriesAdapter countriesAdapter;

    @Override
    protected void initView(View view) {
        countriesAdapter = new CountriesAdapter(getActivity(), R.layout.item_country);
        lvCountries.setAdapter(countriesAdapter);
        countriesAdapter.setListener(new CountriesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Country country) {
                getTransitManager().switchBy(FragmentAction.FRAGM_MAP, country.toBundle());
            }
        });
        tvRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        RemoteManager.getCountries(new SimpleRemoteServiceCallback<List<Country>>() {
            @Override
            public void onSuccess(List<Country> result) {
                if (result != null) {
                    countriesAdapter.clear();
                    countriesAdapter.addAll(result);
                }
            }
        });
    }
}
