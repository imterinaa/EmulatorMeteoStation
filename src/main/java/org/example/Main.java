
package org.example;

import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Device device = new Device();
        Scanner scan = new Scanner(System.in);
        int x = 1;

        List td = new ArrayList();
        List pd = new ArrayList();
        List hd = new ArrayList<>();

        while (x == 1) {
            System.out.println("Добавить усв-во - 1");
            System.out.println("Удалить усв-во - 2");
            System.out.println("Добавить сразу 3 ус-ва - 3");
            System.out.println("Перейти к измерениям - 4");
            switch (scan.next()) {
                case "1": {
                    System.out.println("1.Ус-во измерения температуры");
                    System.out.println("2.Ус-во измерения давления");
                    System.out.println("3.Ус-во измерения влажности");
                    switch (scan.next()) {
                        case "1": {
                            TemperatureDisplay t = new TemperatureDisplay();
                            td.add(t);
                            device.addPropertyChangeListener(t);
                            break;
                        }
                        case "2": {
                            PressureDisplay p = new PressureDisplay();
                            pd.add(p);
                            device.addPropertyChangeListener(p);
                            break;
                        }
                        case "3": {
                            HumidityDisplay h = new HumidityDisplay();
                            hd.add(h);
                            device.addPropertyChangeListener(h);
                            break;
                        }
                    }

                    break;
                }
                case "2": {
                    System.out.println("1.Ус-во измерения температуры");
                    System.out.println("2.Ус-во измерения давления");
                    System.out.println("3.Ус-во измерения влажности");
                    switch (scan.next()) {
                        case "1": {
                            if (!td.isEmpty()) {
                                device.removePropertyChangeListener(
                                        (PropertyChangeListener) td.get(0));
                            } else {
                                System.out.println(
                                        "Устройств такого типа нет\n");
                            }

                            break;
                        }
                        case "2": {
                            if (!pd.isEmpty()) {
                                device.removePropertyChangeListener(
                                        (PropertyChangeListener) pd.get(0));
                            } else {
                                System.out.println(
                                        "Устройств такого типа нет\n");
                            }
                            break;
                        }
                        case "3": {
                            if (!hd.isEmpty()) {
                                device.removePropertyChangeListener(
                                        (PropertyChangeListener) hd.get(0));
                            } else {
                                System.out.println(
                                        "Устройств такого типа нет\n");
                            }
                            break;
                        }
                    }

                    break;
                }
                case "3": {
                    TemperatureDisplay temperatureDisplay = new TemperatureDisplay();
                    td.add(temperatureDisplay);

                    PressureDisplay pressureDisplay = new PressureDisplay();
                    pd.add(pressureDisplay);

                    HumidityDisplay humidityDisplay = new HumidityDisplay();
                    hd.add(humidityDisplay);

                    device.addPropertyChangeListener(temperatureDisplay);
                    device.addPropertyChangeListener(pressureDisplay);
                    device.addPropertyChangeListener(humidityDisplay);
                    break;
                }
                case "4":
                    x = 0;
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                // sending the actual Thread of execution to sleep X
                // milliseconds
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
            }
            int temp = ThreadLocalRandom.current().nextInt(-3, 5);
            int pres = ThreadLocalRandom.current().nextInt(740, 755);
            int humi = ThreadLocalRandom.current().nextInt(69, 85);

            device.onNewData(new DeviceData(temp, pres, humi));

            System.out.println("--------------");
        }
    }
}
