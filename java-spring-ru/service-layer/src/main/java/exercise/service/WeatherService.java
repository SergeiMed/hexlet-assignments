package exercise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import exercise.HttpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import exercise.CityNotFoundException;
import exercise.repository.CityRepository;
import exercise.model.City;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class WeatherService {

    @Autowired
    CityRepository cityRepository;

    // Клиент
    HttpClient client;

    // При создании класса сервиса клиент передаётся снаружи
    // В теории это позволит заменить клиент без изменения самого сервиса
    WeatherService(HttpClient client) {
        this.client = client;
    }

    // BEGIN
    public Map<String, String> getWeather(Long id) {
        ObjectMapper om = new ObjectMapper();
        City city = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException("City not found"));
        String cityName = city.getName();
        String weather = client.get(String.format("http://weather/api/v2/cities/%s", cityName));
        try {
            Map<String, String> weatherToMap = om.readValue(weather, Map.class);
            return weatherToMap;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Map<String, String>> getCitiesWithTemperature(Iterable<City> listCity) {
        List<Map<String, String>> result = new ArrayList<>();
        listCity.forEach(
                city -> {
                    String nameCity = city.getName();
                    String temperature = getWeather(city.getId()).get("temperature");
                    result.add(Map.of("name", city.getName(), "temperature", getWeather(city.getId()).get("temperature")));
                });
        return result;
    }
    // END
}
