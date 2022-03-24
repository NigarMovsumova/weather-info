package com.example.weatherinfo.scheduler;

import az.pashabank.ls.msweatherinfo.model.WeatherDto;
import az.pashabank.ls.msweatherinfo.service.WeatherService;
import az.pashabank.ls.msweatherinfo.utils.RandomWeatherInfoUtil;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Profile("!integration")
public class WeatherScheduler {

    private final WeatherService weatherService;

    public WeatherScheduler(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void createRandomWeatherInformation() {
        WeatherDto weatherDto = RandomWeatherInfoUtil.buildRandomWeatherInformation();
        weatherService.saveWeatherInfo(weatherDto);
    }
}
