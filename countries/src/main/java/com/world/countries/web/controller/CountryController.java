package com.world.countries.web.controller;

import com.world.countries.service.CountryService;
import com.world.countries.web.dto.AddCountryDto;
import com.world.countries.web.dto.SearchCountryRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("country/api")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/list-all-countries")
    public ResponseEntity<?> listAllCountries(@RequestParam(value = "page",defaultValue = "1") int limit,
                                             @RequestParam(value = "size",defaultValue = "3") int offset,@RequestBody SearchCountryRequestDto searchCountryRequestDto) {
        try {

            return new ResponseEntity<>(countryService.findByPartialSearch(searchCountryRequestDto,limit,offset), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }
    @PostMapping("/add-country")
    public ResponseEntity<?> addCountry(@RequestBody AddCountryDto addCountryDTO) {
        try {

            return new ResponseEntity<>(countryService.addCountry(addCountryDTO), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }



}
