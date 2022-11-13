package org.example;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureDisplay implements PropertyChangeListener {
    private int flag = 0;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (flag == 0) {
            System.out.println(String.format(
                    "Температура воздуха - %2.0f градусов по Цельсию",
                    ((DeviceData) evt.getNewValue()).getTemperature()));
            flag = 1;
        } else if (Math.abs(((DeviceData) evt.getNewValue()).getTemperature()
                - ((DeviceData) evt.getOldValue()).getTemperature())
                > 1) {
            System.out.println(String.format(
                    "Температура воздуха - %2.0f градусов по Цельсию",
                    ((DeviceData) evt.getNewValue()).getTemperature()));
        }
    }
}
