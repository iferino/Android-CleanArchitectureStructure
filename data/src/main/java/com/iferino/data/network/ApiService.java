package com.iferino.data.network;


import com.iferino.data.entity.CountryEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("rest/v2/all")
    Observable<List<CountryEntity>> getCountryList();
}

