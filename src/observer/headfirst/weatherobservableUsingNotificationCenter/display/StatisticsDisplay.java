package observer.headfirst.weatherobservableUsingNotificationCenter.display;

import observer.headfirst.weatherobservableUsingNotificationCenter.WeatherData;
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.Notification;
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.NotificationCenter;
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.NotificationID;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;

	Observer measurementChanged;

	public StatisticsDisplay() {
		measurementChanged = (obs, arg) -> {
			if (arg != null) {
				Notification notification = (Notification)arg;
				if (notification.getData() instanceof WeatherData) {
					WeatherData weatherData = (WeatherData)(notification.getData());
					updateDataAndDisplay(weatherData);
				}
			}
		};

		NotificationCenter.getInstance().addObserver(NotificationID.MeasurementsChanged, measurementChanged);
	}

	private void updateDataAndDisplay(WeatherData weatherData) {
		float temp = weatherData.getTemperature();
		tempSum += temp;
		numReadings++;

		if (temp > maxTemp) {
			maxTemp = temp;
		}

		if (temp < minTemp) {
			minTemp = temp;
		}

		display();
	}

	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
}
