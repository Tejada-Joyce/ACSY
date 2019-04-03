  package com.acsy.history;
import javax.persistence.*;

import com.acsy.assignment.Assignment;
import com.acsy.assignment.AssignmentDAO;
import com.acsy.client.Client;
import com.acsy.consultant.Consultant;
import com.acsy.group.Group;

@Entity
@Table(name="histories")

public class History {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="rate")
	private int rate;
	
	@Column(name="done")
	private boolean done;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Assignment assignment;
	
	@Transient
	private boolean was_done;
	
	public History() { }

	public History(Client client, Assignment assignment) {
		super();
		this.client = client;
		this.assignment = assignment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String text) {
		this.description = text;
	}

	public int getRate() {
		return rate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	
	@PostLoad
	public void loadIsDone() {
	  this.was_done = this.done;
	}
	
	@PostUpdate
	public void checkAssignment() {
	  if(this.was_done || (this.was_done == this.done)) return;
	  Assignment assignment = this.assignment;
	  if(!this.was_done && this.done) {
	    int counter = assignment.getHistoriesCounter();
	    assignment.setHistoriesCounter(counter++);
	    if(assignment.getHistoriesCounter() == assignment.getTotalHistories()) {
	      assignment.setCompleted(true);
	    }
	    AssignmentDAO.getInstance().update(assignment);
	  }
	}
}
