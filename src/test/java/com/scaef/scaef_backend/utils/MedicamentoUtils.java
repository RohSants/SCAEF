package com.scaef.scaef_backend.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.scaef.scaef_backend.dto.MedicamentoDTO;
import com.scaef.scaef_backend.entity.Medicamento;
import static com.scaef.scaef_backend.utils.CidUtils.createFakeCid;
import static com.scaef.scaef_backend.utils.CidUtils.createFakeCidDTO;
import static com.scaef.scaef_backend.utils.CidUtils.createFakeCidFrom;


public class MedicamentoUtils {
    
     private static final Faker faker = Faker.instance();

    public static MedicamentoDTO createFakeMedicamentoDTO() {
        return MedicamentoDTO.builder()
                .id(faker.number().numberBetween(0, 100))
                .nome(faker.medical().medicineName())
                .catReg(faker.medical().medicineName())
                .pcdt(faker.medical().symptoms())
                .dose(faker.numerify("##mg"))
                .forma(faker.name().firstName())
                .via(faker.name().firstName())
                .priA(faker.medical().medicineName())
                .classeT(faker.medical().symptoms())
                .cid(createFakeCidDTO())
                .build();
                
    }

    public static Medicamento createFakeMedicamento() {
        return Medicamento.builder()
                .id(faker.number().numberBetween(0, 100))
                .nome(faker.medical().medicineName())
                .catReg(faker.medical().medicineName())
                .pcdt(faker.medical().symptoms())
                .dose(faker.numerify("##mg"))
                .forma(faker.name().firstName())
                .via(faker.name().firstName())
                .priA(faker.medical().medicineName())
                .classeT(faker.medical().symptoms())
                .cid(createFakeCid())
                .build();
    }

    public static Medicamento createFakeMedicamentoFrom(MedicamentoDTO medicamentoDTO) {
        return Medicamento.builder()
                .id(medicamentoDTO.getId())
                .nome(medicamentoDTO.getNome())
                .catReg(medicamentoDTO.getCatReg())
                .pcdt(medicamentoDTO.getPcdt())
                .dose(medicamentoDTO.getDose())
                .forma(medicamentoDTO.getForma())
                .via(medicamentoDTO.getVia())
                .priA(medicamentoDTO.getPriA())
                .classeT(medicamentoDTO.getClasseT())
                .cid(createFakeCidFrom(CidDTO.getCod()))
                .build();
    }

    public static String asJsonString(MedicamentoDTO medicamentoDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(medicamentoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
    }
}

}