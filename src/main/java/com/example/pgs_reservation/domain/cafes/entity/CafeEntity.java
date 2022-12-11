package com.example.pgs_reservation.domain.cafes.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@SequenceGenerator(
        name="CAFE_SEQ_GENERATOR", //시퀀스 제너레이터 이름
        sequenceName="CAFE_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
@Getter
@SuperBuilder
@NoArgsConstructor
public class CafeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAFE_SEQ_GENERATOR")
    private long cafeId;

    private long managerId;

    @Embedded
    private CafeCatalogEntity catalog;

    @OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<BannedUserEntity> banList = new ArrayList<>();

    @OneToOne(mappedBy = "cafe", cascade = CascadeType.ALL, orphanRemoval = true)
    private LayoutEntity layout;

    public CafeEntity registerCatalog(Map<String, String> contract, String description){

        this.catalog = CafeCatalogEntity.builder()
                .contract(contract)
                .description(description)
                .images(null)
                .location(null)
                .build();

        return this;
    }

    public CafeEntity addBanUser(long userId, int banPeriod, String reason){
        BannedUserEntity build = BannedUserEntity.builder()
                .cafe(this)
                .bannedDate(ZonedDateTime.now())
                .banExpireDate(ZonedDateTime.now().plusDays(banPeriod))
                .userId(userId)
                .reason(reason)
                .build();

        this.banList.add(build);

        return this;
    }

    public CafeEntity registerLayout(String layoutGrid){
        this.layout = LayoutEntity.builder()
                .cafe(this)
                .layoutGrid(layoutGrid)
                .seats(new ArrayList<>())
                .build();

        return this;
    }


}
