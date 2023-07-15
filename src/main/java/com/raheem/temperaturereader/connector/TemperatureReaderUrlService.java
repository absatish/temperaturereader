package com.raheem.temperaturereader.connector;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class TemperatureReaderUrlService {

    private final String temperatureSourceUrl;

    @Autowired
    public TemperatureReaderUrlService(@Value("${temperature.source.url}") final String temperatureSourceUrl) {
        this.temperatureSourceUrl = temperatureSourceUrl;
    }

}
