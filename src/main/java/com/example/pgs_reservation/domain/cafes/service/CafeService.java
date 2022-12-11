package com.example.pgs_reservation.domain.cafes.service;

import com.example.pgs_reservation.domain.cafes.dto.CafeDto;
import com.example.pgs_reservation.domain.cafes.entity.CafeEntity;
import com.example.pgs_reservation.domain.cafes.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {

    private final CafeRepository cafeRepository;
    private final ModelMapper mapper;

    public CafeDto readCafe(long cafeId) {
        CafeEntity findCafe = cafeRepository.findById(cafeId).orElseThrow(() -> new IllegalArgumentException("없는 cafe Id 입니다"));
        return mapper.map(findCafe, CafeDto.class);
    }
}
