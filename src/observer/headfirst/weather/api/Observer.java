package observer.headfirst.weather.api;

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
