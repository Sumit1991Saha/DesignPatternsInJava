package observer.headfirst.weatherobservableUsingNotificationCenter.display;

import observer.headfirst.weatherobservableUsingNotificationCenter.WeatherData;
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.Notification;
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.NotificationCenter;
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.NotificationID;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements DisplayElement {
	private float currentPressure = 29.92f;  
	private float lastPressure;

	Observer measurementChanged;

	public ForecastDisplay() {

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
		lastPressure = currentPressure;
		currentPressure = weatherData.getPressure();
		display();
	}

	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}
}
