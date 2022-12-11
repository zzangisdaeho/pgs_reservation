package com.example.pgs_reservation.domain.cafes.dto;

import com.example.pgs_reservation.domain.cafes.entity.SeatEntity;
import lombok.Data;

import java.util.List;

@Data
public class SeatDto {

    private long layoutId;

    private long seatId;

    private SeatEntity.Status status;

    private List<PriceInfoDto> priceList;




}
