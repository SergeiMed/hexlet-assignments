package exercise.controller;
import com.fasterxml.jackson.annotation.JsonFormat;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // BEGIN
    @GetMapping(path = "/search")
    public List<Map<String, String>> getCitiesFilterName(@RequestParam(value = "name", required = false) String name) {
            if (name != null) {
                Iterable<City> listCity = cityRepository.findByNameStartingWithIgnoreCase(name);
                return weatherService.getCitiesWithTemperature(listCity);
            }
        Iterable<City> listCity = cityRepository.findAllByOrderByNameAsc();
        return weatherService.getCitiesWithTemperature(listCity);
    }

    @GetMapping(path ="/cities/{id}")
    public Map<String, String> getWeather(@PathVariable long id) {
        return  weatherService.getWeather(id);
    }
    // END
}

