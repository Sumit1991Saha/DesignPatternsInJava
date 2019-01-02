package observer.headfirst.weatherobservableUsingNotificationCenter;
	
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.Notification;
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.NotificationCenter;
import observer.headfirst.weatherobservableUsingNotificationCenter.notification.NotificationID;

public class WeatherData {
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() { }
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;

		NotificationCenter.getInstance().postNotification(new Notification(NotificationID.MeasurementsChanged, this));
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
