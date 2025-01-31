package com.weather.weather_api.controller;



import com.weather.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
@CrossOrigin("https://skycast-theta.vercel.app")
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{location}")
    public Mono<String> getWeather(@PathVariable String location) {
        return weatherService.getWeatherData(location);
    }
    @GetMapping("/weather/forecast/{location}")
    public Mono<String> getWeatherForecast(@PathVariable String location) {
        return weatherService.forecastData(location);
    }
    @GetMapping("/weather/aqi/{location}")
    public Mono<String> aqiData(@PathVariable String location) {
        return weatherService.getAqi(location);
    }
}