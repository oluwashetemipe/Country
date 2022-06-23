package com.world.countries.service;

import com.world.countries.data.model.Country;
import com.world.countries.data.repository.CountryRepository;
import com.world.countries.web.dto.AddCountryDto;
import com.world.countries.web.dto.CountryResponseDto;
import com.world.countries.web.dto.CountryListResponseDto;
import com.world.countries.web.dto.SearchCountryRequestDto;
import com.world.countries.web.exceptions.CountryException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Country addCountry(AddCountryDto addCountryDTO) throws CountryException {
        if(addCountryDTO.getCountryName().isBlank()||addCountryDTO.getCountryName().isEmpty()){
            throw new CountryException("Country Name Cannot be Empty");
        }
        Optional<Country> countryPresent=countryRepository.findByCountryNameEqualsIgnoreCase(addCountryDTO.getCountryName());
        if(countryPresent.isPresent()){
            throw new CountryException("Country Has already been created");
        }
        Country country=new Country();
        country.setCountryName(addCountryDTO.getCountryName());
        country.setId(UUID.randomUUID().toString());
        countryRepository.save(country);
        return country;
    }




    @Override
    public CountryListResponseDto getCountriesList(int page, int size) {
        //create pageable
        Pageable pageable = PageRequest.of((page - 1), size);
        //find all return page
        Page<Country> countries = countryRepository.findAll(pageable);
        //get total size of list
        int totalSizeOfList = countryRepository.findAll().size();
        //get the contents from page
        List<Country> countryList = countries.getContent();
        //create a dto list for contents
        List<CountryResponseDto> countryResponseDtoArrayList = new ArrayList<>();
        for (Country country : countryList) {
            //loop through contents
            CountryResponseDto countryResponseDto = new CountryResponseDto();
            //map contents to dto
            modelMapper.map(country, countryResponseDto);
            //add dto to dto list
            countryResponseDtoArrayList.add(countryResponseDto);
        }
        //create response object
        CountryListResponseDto countryListResponseDto = new CountryListResponseDto();
        //set data into response object
        countryListResponseDto.setCountryListResponseDto(countryResponseDtoArrayList);
        //set data into response object
        countryListResponseDto.setSizeOfList(totalSizeOfList);
        //return response object
        return countryListResponseDto;
    }




    @Override
    public CountryListResponseDto findByPartialSearch(SearchCountryRequestDto searchCountryRequestDto,int page,int size) throws CountryException {
        if(searchCountryRequestDto.getCountryName().isBlank()||searchCountryRequestDto.getCountryName().isEmpty()){
            throw new CountryException("Country Name Cannot be Empty");
        }
        //create pageable

        Pageable pageable = PageRequest.of((page - 1), size);
        //find all return page
        Page<Country> countries = countryRepository.findByCountryNameContainsIgnoreCase(searchCountryRequestDto.getCountryName(),pageable);
        //get total size of list
        int totalSizeOfList = countryRepository.findByCountryNameContainsIgnoreCase(searchCountryRequestDto.getCountryName()).size();
        //get the contents from page
        List<Country> countryList = countries.getContent();
        //create a dto list for contents
        List<CountryResponseDto> countryResponseDtoArrayList = new ArrayList<>();
        for (Country country : countryList) {
            //loop through contents
            CountryResponseDto countryResponseDto = new CountryResponseDto();
            //map contents to dto
            modelMapper.map(country, countryResponseDto);
            //add dto to dto list
            countryResponseDtoArrayList.add(countryResponseDto);
        }
        //create response object
        CountryListResponseDto countryListResponseDto = new CountryListResponseDto();
        //set data into response object
        countryListResponseDto.setCountryListResponseDto(countryResponseDtoArrayList);
        //set data into response object
        countryListResponseDto.setSizeOfList(totalSizeOfList);
        //return response object
        return countryListResponseDto;
    }


}
