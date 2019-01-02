package observer.headfirst.weatherobservableUsingNotificationCenter;

import observer.headfirst.weatherobservableUsingNotificationCenter.display.CurrentConditionsDisplay;
import observer.headfirst.weatherobservableUsingNotificationCenter.display.ForecastDisplay;
import observer.headfirst.weatherobservableUsingNotificationCenter.display.HeatIndexDisplay;
import observer.headfirst.weatherobservableUsingNotificationCenter.display.StatisticsDisplay;

public class WeatherStationHeatIndex {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay();
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
		ForecastDisplay forecastDisplay = new ForecastDisplay();
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay();

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
