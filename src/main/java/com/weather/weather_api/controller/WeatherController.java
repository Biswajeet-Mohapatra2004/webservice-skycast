package com.weather.weather_api.controller;



import com.weather.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
@CrossOrigin(origins = "https://skycast-theta.vercel.app/")
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

        @GetMapping("/weather")
        public Mono<String> getWeather(@RequestParam String location) {
             if(!location.isEmpty()){
                 return weatherService.getWeatherData(location);
             }
             else{
                 return null;
             }
        }
        @GetMapping("/aqi")
         public Mono<String> getAqi(@RequestParam String location) {
            if(!location.isEmpty()){
               return weatherService.getAqi(location);
            }
            else{
                  return null;
            }
        }
    @GetMapping("/forecast")
    public Mono<String> getForecast(@RequestParam String location) {
        if(!location.isEmpty()){
            return weatherService.forecastData(location);
        }
        else{
            return null;
        }
    }



}