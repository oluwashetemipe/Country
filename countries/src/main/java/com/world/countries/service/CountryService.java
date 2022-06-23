package com.world.countries.service;

import com.world.countries.data.model.Country;
import com.world.countries.web.dto.AddCountryDto;
import com.world.countries.web.dto.CountryListResponseDto;
import com.world.countries.web.dto.SearchCountryRequestDto;
import com.world.countries.web.exceptions.CountryException;

import java.util.List;

public interface CountryService {
    Country addCountry(AddCountryDto addCountryDTO) throws CountryException;


    CountryListResponseDto findByPartialSearch(SearchCountryRequestDto searchCountryRequestDto,int limit,int offset) throws CountryException;
}
