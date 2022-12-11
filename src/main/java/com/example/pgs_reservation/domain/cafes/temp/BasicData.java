package com.example.pgs_reservation.domain.cafes.temp;

import com.example.pgs_reservation.domain.cafes.entity.CafeEntity;
import com.example.pgs_reservation.domain.cafes.entity.LayoutEntity;
import com.example.pgs_reservation.domain.cafes.entity.SeatEntity;
import com.example.pgs_reservation.domain.cafes.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class BasicData {

    private final CafeRepository cafeRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void saveBasicData(){

        CafeEntity build = CafeEntity.builder()
                .managerId(1L)
                .build();

        HashMap<String, String> contract = new HashMap<>();
        contract.put("엄마", "살려줘");
        contract.put("엔텍", "붙어라");
        contract.put("부장님", "사랑해욥");

        build
                .registerCatalog(contract, "되라되라되라")
                .addBanUser(1L, 3, "못생김")
                .registerLayout("이것은 그리드입니다");

        LayoutEntity layoutEntity = build.getLayout().addSeat(SeatEntity.Status.ENABLE);

        layoutEntity.getSeats().get(0).registerPriceInfo(10000, DayOfWeek.MONDAY, LocalTime.of(3, 0), LocalTime.of(4, 0));

        cafeRepository.save(build);
    }
}
