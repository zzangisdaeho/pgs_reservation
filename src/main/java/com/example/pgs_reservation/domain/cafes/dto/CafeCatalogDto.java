package com.example.pgs_reservation.domain.cafes.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CafeCatalogDto {

    private String description;

    //TODO image 타입으로 추후 변경
    private List<String> images;

    //TODO 위치 타입으로 추후 변경
    private String location;

    private Map<String, String> contract;
}
