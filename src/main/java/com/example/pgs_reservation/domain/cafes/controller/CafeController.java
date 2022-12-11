package com.example.pgs_reservation.domain.cafes.controller;

import com.example.pgs_reservation.domain.cafes.dto.CafeDto;
import com.example.pgs_reservation.domain.cafes.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cafes")
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;

    @GetMapping
    public CafeDto getCafes(@RequestParam(name = "cafeId") long cafeId){
        return cafeService.readCafe(cafeId);
    }
}
