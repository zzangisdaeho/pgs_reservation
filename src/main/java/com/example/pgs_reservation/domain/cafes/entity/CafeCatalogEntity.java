package com.example.pgs_reservation.domain.cafes.entity;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;
import java.util.Map;

@Embeddable
@SuperBuilder
@NoArgsConstructor
public class CafeCatalogEntity {

    private String description;

    //TODO image 타입으로 추후 변경
    @ElementCollection
    private List<String> images;

    //TODO 위치 타입으로 추후 변경
    private String location;

    @ElementCollection
    private Map<String, String> contract;

}
