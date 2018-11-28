package com.iferino.domain.repository

import com.iferino.domain.entity.Country
import io.reactivex.Observable

interface CountryRepository {

    fun getCountryList() : Observable<List<Country>>
}