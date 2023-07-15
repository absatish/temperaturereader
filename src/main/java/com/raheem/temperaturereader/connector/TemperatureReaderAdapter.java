package com.raheem.temperaturereader.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class TemperatureReaderAdapter implements TemperatureReaderConnector {

    private final TemperatureReaderUrlService temperatureReaderUrlService;
    private final RestOperations restOperations;

    @Autowired
    public TemperatureReaderAdapter(final TemperatureReaderUrlService temperatureReaderUrlService,
                                    final RestOperations restOperations) {
        this.temperatureReaderUrlService = temperatureReaderUrlService;
        this.restOperations = restOperations;
    }

    @Override
    public Double readTemperature() {
        final String response = restOperations.exchange(
                temperatureReaderUrlService.getTemperatureSourceUrl(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        ).getBody();

        Double temperature = Double.valueOf(response.split("\n")[427].split("&nbsp;")[1]
                .replaceAll("</div></td>", ""));

        return temperature;
    }

}
