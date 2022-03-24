package com.example.weatherinfo.utils;

import az.pashabank.ls.msweatherinfo.model.WeatherDto;
import com.github.javafaker.Faker;

import java.time.LocalDate;

public class RandomWeatherInfoUtil {
    public static WeatherEntity buildRandomWeatherInformation() {
        Faker faker = new Faker();
        WeatherDto weatherDto = WeatherDto.builder()
                .city(faker.address().cityName())
                .date(LocalDate.now())
                .temperature(faker.number().randomDouble(2, -50, 50))
                .scale("CELSIUS")
                .build();
        return weatherDto;
    }
}
