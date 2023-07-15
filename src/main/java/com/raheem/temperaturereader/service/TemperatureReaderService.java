package com.raheem.temperaturereader.service;

import com.raheem.temperaturereader.UIPage;
import com.raheem.temperaturereader.connector.TemperatureReaderConnector;
import com.raheem.temperaturereader.service.S3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TemperatureReaderService {

    private final TemperatureReaderConnector temperatureReaderConnector;

    private final S3Service s3Service;

    @Autowired
    public TemperatureReaderService(final TemperatureReaderConnector temperatureReaderConnector,
                                    final S3Service s3Service) {
        this.temperatureReaderConnector = temperatureReaderConnector;
        this.s3Service = s3Service;
    }

    public Double getTemperature() {
        return temperatureReaderConnector.readTemperature();
    }

    @Scheduled(cron = "* */3 * * * *")
    public void uploadTemperature() {
        Double temperature = Math.round(getTemperature()*100)/100.0;
        log.info("schedule run, temp: " + temperature);
        s3Service.upload("raheemtemp.com", "temperature.txt", temperature.toString());
    }
}
