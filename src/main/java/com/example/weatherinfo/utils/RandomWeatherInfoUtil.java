package com.example.weatherinfo.utils;

import com.example.weatherinfo.repository.entity.WeatherEntity;
import com.github.javafaker.Faker;

import java.time.LocalDate;

public class RandomWeatherInfoUtil {
    public static WeatherEntity buildRandomWeatherInformation() {
        Faker faker = new Faker();
        WeatherEntity weatherEntity = WeatherEntity.builder()
                .city(faker.address().cityName())
                .date(LocalDate.now())
                .temperature(faker.number().randomDouble(2, -50, 50))
                .scale("CELSIUS")
                .build();
        return weatherEntity;
    }
}
