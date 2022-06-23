package com.world.countries.data.repository;

import com.world.countries.data.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {


    Optional<Country> findByCountryNameEqualsIgnoreCase(String countryName);



    List<Country> findByCountryNameContainsIgnoreCase(String countryName);


    Page<Country> findByCountryNameContainsIgnoreCase(String countryName, Pageable pageable);
}
