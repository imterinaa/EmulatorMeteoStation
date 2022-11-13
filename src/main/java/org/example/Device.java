package org.example;
import java.awt.*;
import java.beans.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Device {
    private DeviceData data;

    private final PropertyChangeSupport support =
            new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public DeviceData getData() {
        return data;
    }

    public void setData(DeviceData data) {
        this.data = data;
    }

    public void onNewData(DeviceData newData) {
        support.firePropertyChange("Device", this.data, newData);
        this.data = newData;
    }
}
