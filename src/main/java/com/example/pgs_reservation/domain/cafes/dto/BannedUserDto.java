package com.example.pgs_reservation.domain.cafes.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class BannedUserDto {

    private long cafeId;

    private long userId;

    private ZonedDateTime bannedDate;

    private ZonedDateTime banExpireDate;

    private String reason;
}
