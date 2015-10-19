package com.countrytable.remote.service;

import com.countrytable.model.Country;
import com.countrytable.remote.IService;

import java.util.List;

public class CountriesService extends AbstractRestService<List<Country>> {

    @Override
    protected void run(IService API) {
        serviceResponseObject = API.getCountries();
    }
}
