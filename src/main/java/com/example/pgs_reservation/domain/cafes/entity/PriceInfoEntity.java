package com.example.pgs_reservation.domain.cafes.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class PriceInfoEntity {

    @Id
    private long priceInfoNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private SeatEntity seat;

    private DayOfWeek dayOfWeek;

    private LocalTime timeFrom;

    private LocalTime timeTo;

    private int timePrice;

}
