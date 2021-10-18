package com.scaef.scaef_backend.utils;

import com.github.javafaker.Faker;
import com.scaef.scaef_backend.dto.CidDTO;
import com.scaef.scaef_backend.entity.Cid;

public class CidUtils {

    private static final Faker faker = Faker.instance();

    public static CidDTO createFakeCidDTO(){
        return CidDTO.builder()
            .cod(faker.numerify("M0###"))
            .build();
    }

    public static Cid createFakeCid(){
        return Cid.builder()
            .cod(faker.numerify("M0###"))
            .build();
    }

    public static Cid createFakeCidFrom(CidDTO cidDTO){
        return Cid.builder()
            .cod(cidDTO.getCod())
            .build();
    }
    

}