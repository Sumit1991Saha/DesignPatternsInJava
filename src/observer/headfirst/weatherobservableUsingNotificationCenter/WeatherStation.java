package observer.headfirst.weatherobservableUsingNotificationCenter;

import observer.headfirst.weatherobservableUsingNotificationCenter.display.CurrentConditionsDisplay;
import observer.headfirst.weatherobservableUsingNotificationCenter.display.ForecastDisplay;
import observer.headfirst.weatherobservableUsingNotificationCenter.display.StatisticsDisplay;

public class WeatherStation {
	//Using Notification Center Observers don't have any knowledge of Observable who throws notification for the Observers.
	//Here technically Weather Data doesnt extend from the Observable but pass on its state in the notification for the observers to act on it.

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay();
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
		ForecastDisplay forecastDisplay = new ForecastDisplay();

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
