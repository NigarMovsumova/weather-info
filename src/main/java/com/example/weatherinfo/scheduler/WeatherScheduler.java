package com.example.weatherinfo.scheduler;

import com.example.weatherinfo.repository.entity.WeatherEntity;
import com.example.weatherinfo.service.WeatherService;
import com.example.weatherinfo.utils.RandomWeatherInfoUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Configuration
@EnableScheduling
public class WeatherScheduler {

    private final WeatherService weatherService;

    public WeatherScheduler(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Scheduled(fixedDelay = 1000)
    public void createRandomWeatherInformation() {
        WeatherEntity weatherDto = RandomWeatherInfoUtil.buildRandomWeatherInformation();
        weatherService.saveWeatherInfo(weatherDto);
    }
}
