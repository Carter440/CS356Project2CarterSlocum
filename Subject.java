import java.util.LinkedList;
import java.util.List;

public abstract class Subject {

	private List<Observer> observers = new LinkedList<Observer>();
	private long lastUpdateTime = System.currentTimeMillis();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		this.setUpdateTime(System.currentTimeMillis());
		for(Observer ob : observers) {
			ob.setUpdateTime(System.currentTimeMillis());
			ob.update(this);
		}
	}
	
	public void setUpdateTime(long currentTimeMillis){
		lastUpdateTime = currentTimeMillis;
	}
	
	public long getUpdateTime(){
		return lastUpdateTime;
	}
}