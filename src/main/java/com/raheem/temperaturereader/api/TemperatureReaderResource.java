package com.raheem.temperaturereader.api;

import com.raheem.temperaturereader.service.TemperatureReaderService;
import com.raheem.temperaturereader.ValueType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/v1/temperature")
public class TemperatureReaderResource {

    private final TemperatureReaderService temperatureReaderService;

    @Autowired
    public TemperatureReaderResource(final TemperatureReaderService temperatureReaderService) {
        this.temperatureReaderService = temperatureReaderService;
    }

    @GetMapping
    public Double getTemperature(@RequestParam("readingType") String readingType) {
        if (ValueType.isTemperature(readingType)) {
            return temperatureReaderService.getTemperature();
        } else {
            return 0D;
        }
    }

    @GetMapping("/upload")
    public void uploadTemperature() {
        temperatureReaderService.uploadTemperature();
    }
}
