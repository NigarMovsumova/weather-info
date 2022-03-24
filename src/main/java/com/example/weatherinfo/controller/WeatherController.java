package com.example.weatherinfo.controller;

import com.example.weatherinfo.repository.entity.WeatherEntity;
import com.example.weatherinfo.service.WeatherService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/weather/by")
@Api("Weather Controller")
public class WeatherController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
    private final WeatherService weatherService;


    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{date}")
    public List<WeatherEntity> getWeatherByDate(@PathVariable(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        logger.debug("Get weather of date {} start", date);
        return weatherService.getWeatherByDate(date);
    }

//    @GetMapping("/{date}/in/{city}")
//    public WeatherEntity getWeatherByDateAndCity(
//            @PathVariable(name = "date")
//            @DateTimeFormat(pattern = "yyyy-MM-dd")
//                    LocalDate date,
//            @PathVariable(name = "city") String city) {
//        logger.debug("Get weather of date {} in city {} start", date, city);
//        return weatherService.getWeatherByDateAndCity(date, city);
//    }

    @GetMapping("/city/{city}")
    public List<WeatherEntity> getWeatherByCity(
            @PathVariable(name = "city") String city) {
        logger.debug("Get weather in city {} start", city);
        return weatherService.getWeatherByCity(city);
    }
}

