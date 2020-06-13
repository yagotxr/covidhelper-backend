package com.ferry.covidhelper.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Document(collection = "brasilStatus")
public class BrasilStatus {

    @Id
    private final String id;

    @Field("regiao")
    private final String region;

    @Field("estado")
    private final String state;

    @Field("municipio")
    private final String city;

    @Field("coduf")
    private final String stateId;

    @Field("codmun")
    private final String cityId;

    @Field("codRegiaoSaude")
    private final String healthRegionId;

    @Field("nomeRegiaoSaude")
    private final String healthRegionName;

    @Field("data")
    private final LocalDate date;

    @Field("semanaEpi")
    private final String week;

    @Field("populacaoTCU2019")
    private final String population;

    @Field("casosAcumulado")
    private final String totalCases;

    @Field("obitosAcumulado")
    private final String totalDeaths;

}
