package com.example.pgs_reservation.domain.cafes.dto;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class PriceInfoDto {

    private long seatId;

    private DayOfWeek dayOfWeek;

    private LocalTime timeFrom;

    private LocalTime timeTo;

    private int price;
}
