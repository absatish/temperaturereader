package com.raheem.temperaturereader;

public enum ValueType {

    RUNNING_HOURS,
    TEMPERATURE;

    public static boolean isTemperature(String valueType) {
        return valueType.equalsIgnoreCase(ValueType.TEMPERATURE.name());
    }
}
