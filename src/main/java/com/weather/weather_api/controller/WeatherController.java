package com.weather.weather_api.controller;



import com.weather.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
@CrossOrigin
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

        @GetMapping("/weather")
        public Mono<String> getWeather(
                @RequestParam String location,
                @RequestParam(defaultValue = "") String forecast,
                @RequestParam(defaultValue = "") String aqi) {

            if (!location.isEmpty()) {
                if (forecast != null && !forecast.isEmpty()) {
                    return weatherService.forecastData(location);
                } else if (aqi != null && !aqi.isEmpty()) {
                    return weatherService.getAqi(location);
                } else {
                    return weatherService.getWeatherData(location);
                }
            } else {
                return Mono.just("Location parameter is required.");
            }
        }

}