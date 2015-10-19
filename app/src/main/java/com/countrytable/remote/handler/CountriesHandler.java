package com.countrytable.remote.handler;

import com.countrytable.database.DataBaseGateway;
import com.countrytable.model.Country;
import com.countrytable.remote.IRemoteServiceCallback;
import com.countrytable.remote.model.JSONRestResponse;
import com.countrytable.remote.service.CountriesService;

import java.util.List;

public class CountriesHandler extends AbstractSimpleRemoteHandler<List<Country>> {

    public CountriesHandler(IRemoteServiceCallback<List<Country>> callback) {
        super(callback);
    }

    @Override
    protected JSONRestResponse<List<Country>> executeRemoteRoutine(Void... voids) {
        return executeService(new CountriesService());
    }

    @Override
    protected boolean checkSuccess(JSONRestResponse<List<Country>> result) {
        boolean res = super.checkSuccess(result);
        if (res) {
            List<Country> countries = result.getResult();
            DataBaseGateway.getInstance().clearCountries();
            DataBaseGateway.getInstance().saveCountries(countries);
        }
        return res;
    }
}
