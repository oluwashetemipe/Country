package com.world.countries.web.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CountryListResponseDto {
    private int sizeOfList;
    private List<CountryResponseDto> countryListResponseDto= new ArrayList<>();



}
