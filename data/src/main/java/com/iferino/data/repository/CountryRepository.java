package com.iferino.data.repository;


import com.iferino.data.entity.CountryEntity;
import com.iferino.data.network.ApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CountryRepository {

    private ApiService apiService;

    @Inject
    public CountryRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<List<CountryEntity>> getCountryList() {
        return apiService.getCountryList();
    }
}

