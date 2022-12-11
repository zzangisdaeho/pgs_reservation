package com.example.pgs_reservation.domain.cafes.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class SeatEntity {

    @ManyToOne
    @JoinColumn(name = "layoutId")
    private LayoutEntity layout;

    @Id
    private long seatId;

    @Enumerated(EnumType.STRING)
    private Status seatStatus;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<PriceInfoEntity> priceList = new ArrayList<>();

    public enum Status {

        ENABLE("사용 가능"), DISABLE("사용 불가능");

        private String ko;

        Status(String ko) {
            this.ko = ko;
        }

        public String getKo() {
            return ko;
        }
    }

    public SeatEntity registerPriceInfo(int price, DayOfWeek dayOfWeek, LocalTime from, LocalTime to){
        this.priceList.add(PriceInfoEntity.builder()
                .timePrice(price)
                .dayOfWeek(dayOfWeek)
                .seat(this)
                .timeFrom(from)
                .timeTo(to)
                .build());

        return this;
    }

}
