package com.weather.weather_api.controller;



import com.weather.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
@CrossOrigin("https://skycast-theta.vercel.app/")
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public Mono<String> getWeather(@RequestParam String location, @RequestParam String forecast,@RequestParam String aqi){
        if (!location.isEmpty()) {
            if (!forecast.isEmpty()) {
                return weatherService.forecastData(location);
            } else if (!aqi.isEmpty()) {
                return weatherService.getAqi(location);
            } else {
                return weatherService.getWeatherData(location);
            }
        }
        else{
            return null;
        }

    }

}