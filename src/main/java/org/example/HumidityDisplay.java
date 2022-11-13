package org.example;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HumidityDisplay implements PropertyChangeListener {
    private int flag = 0;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (flag == 0) {
            System.out.println(String.format("Влажность - %2.0f процентов",
                    ((DeviceData) evt.getNewValue()).getPressure()));
            flag = 1;
        } else if (Math.abs(((DeviceData) evt.getNewValue()).getHumidity()
                - ((DeviceData) evt.getOldValue()).getHumidity())
                > 3) {
            System.out.println(String.format("Влажность - %2.0f процентов",
                    ((DeviceData) evt.getNewValue()).getHumidity()));
        }
    }
}
