import java.util.LinkedList;
import java.util.List;

public abstract class Subject {

	private List<Observer> observers = new LinkedList<Observer>();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(Observer ob : observers) {
			ob.update(this);
		}
	}
}