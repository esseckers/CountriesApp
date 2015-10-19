package com.countrytable.remote;


import com.countrytable.model.Country;
import com.countrytable.remote.model.JSONRestResponse;

import java.util.List;

import retrofit.http.GET;

public interface IService {

    @GET("/query_cities")
    JSONRestResponse<List<Country>> getCountries();
}
