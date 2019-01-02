package observer.headfirst.weatherobservableUsingNotificationCenter.display;

import observer.headfirst.weatherobservableUsingNotificationCenter.WeatherData;
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.Notification;
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.NotificationCenter;
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.NotificationID;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements DisplayElement {
	private float temperature;
	private float humidity;

	Observer measurementChanged;
	
	public CurrentConditionsDisplay() {
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
		this.temperature = weatherData.getTemperature();
		this.humidity = weatherData.getHumidity();
		display();
	}

	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
	}
}
