package com.world.countries.service;

import com.world.countries.data.repository.CountryRepository;
import com.world.countries.web.dto.AddCountryDto;
import com.world.countries.web.dto.SearchCountryRequestDto;
import com.world.countries.web.exceptions.CountryException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CountryServiceImplTest {
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CountryService countryService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    @Transactional
    void testToAddCountriesExceptionally() throws CountryException {
        AddCountryDto addCountryDTO=new AddCountryDto();
        addCountryDTO.setCountryName("");
        assertThrows(CountryException.class, ()-> countryService.addCountry(addCountryDTO));
    }
    @Test
    @Transactional
    void testToAddCountry() throws CountryException{
        AddCountryDto addCountryDto = new AddCountryDto();
        addCountryDto.setCountryName("Nigeria");
        countryService.addCountry(addCountryDto);
        assertEquals("Nigeria", addCountryDto.getCountryName());
    }
    @Test
    @Transactional
    void testForPartialSearchExceptionally(){
        SearchCountryRequestDto searchCountryRequestDto=new SearchCountryRequestDto();
        searchCountryRequestDto.setCountryName("");
        assertThrows(CountryException.class,()->countryService.findByPartialSearch(searchCountryRequestDto,1,1));
    }
    @Test
    @Transactional
    void testForPartialSearchForEntireSize() throws CountryException {
        AddCountryDto addCountryDto=new AddCountryDto();
        addCountryDto.setCountryName("Nigeria");
        AddCountryDto addCountryDto2=new AddCountryDto();
        addCountryDto2.setCountryName("Niger");
        countryService.addCountry(addCountryDto);
        countryService.addCountry(addCountryDto2);
        SearchCountryRequestDto searchCountryRequestDto=new SearchCountryRequestDto();
        searchCountryRequestDto.setCountryName("I");
        int size=countryService.findByPartialSearch(searchCountryRequestDto,2,1).getSizeOfList();
       assertEquals(14,size);
    }
    @Test
    @Transactional
    void testForPartialSearchForOffsetSize() throws CountryException {
        AddCountryDto addCountryDto=new AddCountryDto();
        addCountryDto.setCountryName("Nigeria");
        AddCountryDto addCountryDto2=new AddCountryDto();
        addCountryDto2.setCountryName("Niger");
        countryService.addCountry(addCountryDto);
        countryService.addCountry(addCountryDto2);
        SearchCountryRequestDto searchCountryRequestDto=new SearchCountryRequestDto();
        searchCountryRequestDto.setCountryName("I");
        int size=countryService.findByPartialSearch(searchCountryRequestDto,2,12).getCountryListResponseDto().size();
        assertEquals(2,size);
    }

    @Test
    @Transactional
    void testForGetCountriesList() throws CountryException {
        int size=countryService.getCountriesList(1,3).getSizeOfList();
        assertEquals(18,size);
    }
    @Test
    @Transactional
    void testForGetCountriesListOffsetSize() throws CountryException {
        int size=countryService.getCountriesList(1,3).getCountryListResponseDto().size();
        assertEquals(1,size);
    }
}