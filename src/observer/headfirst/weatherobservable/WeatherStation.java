package observer.headfirst.weatherobservable;

import observer.headfirst.weatherobservable.display.CurrentConditionsDisplay;
import observer.headfirst.weatherobservable.display.ForecastDisplay;
import observer.headfirst.weatherobservable.display.StatisticsDisplay;

//Example of Pull style of observer pattern (ie Observer get the data wrapped in an object and it needs to extract that)
public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
