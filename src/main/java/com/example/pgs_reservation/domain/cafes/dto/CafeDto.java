package com.example.pgs_reservation.domain.cafes.dto;

import ch.qos.logback.core.Layout;
import lombok.Data;

import java.util.List;

@Data
public class CafeDto {

    private long cafeId;

    private long managerId;

    private CafeCatalogDto catalog;

    private List<BannedUserDto> banList;

    private LayoutDto layout;
}
