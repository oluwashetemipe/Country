package com.world.countries.data.repository;

import com.world.countries.data.model.Country;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryRepositoryTest {
    @Autowired
    CountryRepository countryRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    @Transactional
    void addCountry(){
        Country country = new Country();
        country.setCountryName("Nigeria");
        country.setId(UUID.randomUUID().toString());
        countryRepository.save(country);
        assertEquals("Nigeria",country.getCountryName());
    }


    @Test
    @Transactional
    void findByCountryNameEqualsIgnoreCase() {
        Country country=new Country();
        country.setCountryName("Nigeria");
        country.setId(UUID.randomUUID().toString());
        countryRepository.save(country);
        Optional<Country> foundCountry=countryRepository.findByCountryNameEqualsIgnoreCase("Nigeria");
        if(foundCountry.isPresent()){
        assertEquals(country.getCountryName(),foundCountry.get().getCountryName());
        assertEquals(country.getId(),foundCountry.get().getId());
        }
    }

    @Test
    @Transactional
    void findByCountryNameContainsIgnoreCaseWithPageable() {
        Country country=new Country();
        country.setCountryName("Nigeria");
        country.setId(UUID.randomUUID().toString());
        Country country2=new Country();
        country2.setCountryName("Niger");
        country2.setId(UUID.randomUUID().toString());
        countryRepository.save(country);
        countryRepository.save(country2);
        Pageable pageable = PageRequest.of((0), 2);
        Page<Country> foundCountry=countryRepository.findByCountryNameContainsIgnoreCase("Nig",pageable);
        int countryList=foundCountry.getContent().size();
        assertEquals(2,countryList);
    }
    @Test
    @Transactional
    void findByCountryNameContainsIgnoreCaseWithoutPageable() {
        Country country=new Country();
        country.setCountryName("Nigeria");
        country.setId(UUID.randomUUID().toString());
        Country country2=new Country();
        country2.setCountryName("Niger");
        country2.setId(UUID.randomUUID().toString());
        countryRepository.save(country);
        countryRepository.save(country2);
        List<Country> foundCountry=countryRepository.findByCountryNameContainsIgnoreCase("Nig");
        int sizeOfList=foundCountry.size();
        assertEquals(2,sizeOfList);
    }
}