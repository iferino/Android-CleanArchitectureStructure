package com.iferino.domain.repositoryContractor

import com.iferino.domain.entity.Country
import io.reactivex.Observable

interface CountryRepositoryContractor {

    fun getCountryList() : Observable<List<Country>>
}