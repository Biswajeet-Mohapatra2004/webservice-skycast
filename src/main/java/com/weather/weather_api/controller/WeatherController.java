package com.weather.weather_api.controller;



import com.weather.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
@CrossOrigin(origins = "https://skycast-theta.vercel.app")
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @CrossOrigin(origins = "https://skycast-theta.vercel.app")
    @GetMapping("/weather")
    public Mono<String> getWeather(@RequestParam String location, @RequestParam(required = false) String forecast,@RequestParam(required = false) String aqi){
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