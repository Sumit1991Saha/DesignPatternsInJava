package observer.headfirst.weather;

import observer.headfirst.weather.api.Observer;
import observer.headfirst.weather.api.Subject;

import java.util.*;

public class WeatherData implements Subject {
	private ArrayList<observer.headfirst.weather.api.Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<observer.headfirst.weather.api.Observer>();
	}
	
	public void registerObserver(observer.headfirst.weather.api.Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(observer.headfirst.weather.api.Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}

}
