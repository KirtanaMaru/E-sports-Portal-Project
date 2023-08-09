package app.com.pojos;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "event_applications")
public class EventApplications extends BaseEntity {

	@ManyToOne
	private User user;
	@ManyToOne
	private EventManager manager;
	@ManyToOne
	private Event event;
	
	private String status;

	public EventApplications() {
		super();
	}

	public EventApplications(User user, EventManager manager, Event event, String status) {
		super();
		this.user = user;
		this.manager = manager;
		this.event = event;
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EventManager getManager() {
		return manager;
	}

	public void setManager(EventManager manager) {
		this.manager = manager;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EventApplications [user=" + user + ", manager=" + manager + ", event=" + event + ", status=" + status
				+ "]";
	}
	
	
}
