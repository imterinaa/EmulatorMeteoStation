package org.example;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PressureDisplay implements PropertyChangeListener {
    private int flag = 0;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (flag == 0) {
            System.out.println(String.format("Давление - %2.0f кПа",
                    ((DeviceData) evt.getNewValue()).getPressure()));
            flag = 1;
        } else if (Math.abs(((DeviceData) evt.getNewValue()).getPressure()
                - ((DeviceData) evt.getOldValue()).getPressure())
                > 2) {
            System.out.println(String.format("Давление - %2.0f кПа",
                    ((DeviceData) evt.getNewValue()).getPressure()));
        }
    }
}
