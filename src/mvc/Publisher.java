package mvc;

import java.util.Set;
import java.util.HashSet;

public class Publisher {
	private Set<Subscriber> subscribers = new HashSet<Subscriber>();
	
	public Publisher() {}
	
	public void notifySubscribers() {
		for (Subscriber s : subscribers) {
			s.update();
		}
	}
	public void subscribe(Subscriber s) {
		subscribers.add(s);
	}
	public void unSubscribe(Subscriber s) {
		subscribers.remove(s);
	}
}
