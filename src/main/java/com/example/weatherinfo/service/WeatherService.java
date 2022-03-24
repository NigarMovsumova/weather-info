package com.example.weatherinfo.service;

import com.example.weatherinfo.repository.WeatherRepository;
import com.example.weatherinfo.repository.entity.WeatherEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }


    public List<WeatherEntity> getWeatherByCity(String city) {
        logger.info("getWeatherByCity.start : city {}", city);
        List<WeatherEntity> weatherEntityList = weatherRepository.findAllByCity(city);
        logger.info("getWeatherByCity.start : city {}", city);
        return weatherEntityList;
    }

    public void saveWeatherInfo(WeatherEntity weatherEntity) {
        logger.info("saveWeatherInfo.start");
        weatherRepository.save(weatherEntity);
        logger.info("saveWeatherInfo.end");
    }
}
