package com.weather.weather_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WebClient.Builder webClientBuilder;

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<String> getWeatherData(String location) {
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=e76340af3b584d23b6a164722241302&q="+location;

        return webClientBuilder.baseUrl(apiUrl)
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> Mono.just("Error fetching data"));
    }
    public Mono<String> forecastData(String location) {
        String apiUrl = "http://api.weatherapi.com/v1/forecast.json?key=e76340af3b584d23b6a164722241302&q="+location+"&days=7&aqi=yes";

        return webClientBuilder.baseUrl(apiUrl)
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> Mono.just("Error fetching data"));
    }
    public Mono<String> getAqi(String location) {
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=e76340af3b584d23b6a164722241302&q="+location+"&aqi=yes";

        return webClientBuilder.baseUrl(apiUrl)
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> Mono.just("Error fetching data"));
    }
}