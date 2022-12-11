package com.example.pgs_reservation.domain.cafes.dto;

import lombok.Data;

import java.util.List;

@Data
public class LayoutDto {

    private long layoutId;

    private long cafeId;

    private String layoutGrid;

    private List<SeatDto> seats;
}
