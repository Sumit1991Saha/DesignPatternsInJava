package observer.headfirst.weatherobservableUsingNotificationCenter.notification;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

//A local notification center which acts as a central place to listen for and publish local app specific events.
public class NotificationCenter {

    private static NotificationCenter defaultCenter = null;
    Map<String, ObservableWrapper> observables = null;

    protected NotificationCenter() {
        this.observables = new HashMap();
    }

    public static NotificationCenter getInstance() {
        if (defaultCenter == null) {
            synchronized (NotificationCenter.class) {
                if (defaultCenter == null) {
                    defaultCenter = new NotificationCenter();
                }
            }
        }
        return defaultCenter;
    }

    public synchronized void addObserver(String notificationID, Observer observer) {
        ObservableWrapper observable = this.observables.get(notificationID);
        if (observable == null) {
            observable = new ObservableWrapper();
            this.observables.put(notificationID, observable);
        }

        observable.addObserver(observer);
    }

    public synchronized void removeObserver(String notificationID, Observer observer) {
        ObservableWrapper observable = this.observables.get(notificationID);
        if (observable != null) {
            observable.deleteObserver(observer);
        }

    }

    public synchronized void postNotification(Notification notification) {
        ObservableWrapper observable = this.observables.get(notification.getID());
        if (observable != null) {
            observable.markChanged();
            observable.notifyObservers(notification);
        }

    }

    private class ObservableWrapper extends Observable {
        private ObservableWrapper() {
        }

        public void markChanged() {
            this.setChanged();
        }
    }

}
