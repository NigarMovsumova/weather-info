package com.example.weatherinfo.repository;

import com.example.weatherinfo.repository.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {

    // named query
    List<WeatherEntity> findAllByCity(String city);
}
