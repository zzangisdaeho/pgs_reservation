package com.example.pgs_reservation.domain.cafes.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class BannedUserEntity {

    @Id
    private long banNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafeId")
    private CafeEntity cafe;

    private long userId;

    private ZonedDateTime bannedDate;

    private ZonedDateTime banExpireDate;

    private String reason;
}
