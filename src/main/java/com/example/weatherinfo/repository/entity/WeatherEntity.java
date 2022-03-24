package com.example.weatherinfo.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "weather")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name")
    private String city;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "scale")
    private String scale;
}
