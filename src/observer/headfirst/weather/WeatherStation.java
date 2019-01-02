package observer.headfirst.weather;

import observer.headfirst.weather.display.CurrentConditionsDisplay;
import observer.headfirst.weather.display.ForecastDisplay;
import observer.headfirst.weather.display.StatisticsDisplay;

//Example of Push style of observer pattern (ie Observer get the required data directly)
public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
	
		CurrentConditionsDisplay currentDisplay =
			new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
