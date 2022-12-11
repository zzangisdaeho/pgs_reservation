package com.example.pgs_reservation.domain.cafes.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(
        name="LAYOUT_SEQ_GENERATOR", //시퀀스 제너레이터 이름
        sequenceName="LAYOUT_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
@Getter
@SuperBuilder
@NoArgsConstructor
public class LayoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LAYOUT_SEQ_GENERATOR")
    private long layoutId;

    @OneToOne
    @JoinColumn(name = "cafe_id")
    private CafeEntity cafe;

    private String layoutGrid;

    @OneToMany(mappedBy = "layout", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<SeatEntity> seats = new ArrayList<>();

    public LayoutEntity addSeat(SeatEntity.Status status){
        this.seats.add(SeatEntity.builder()
                .layout(this)
                .priceList(new ArrayList<>())
                .seatStatus(status)
                .build());

        return this;
    }
}
