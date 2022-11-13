package org.example;

public class DeviceData {
    private final double temperature; // температура
    private final double pressure; // давление
    private final double humidity; // влажность

    public DeviceData(double temperature, double pressure, double humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }
}
