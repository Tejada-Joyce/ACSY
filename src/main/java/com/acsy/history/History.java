package com.acsy.history;
import javax.persistence.*;

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
	private String text;
	
	@Column(name="rate")
	private int rate;
/*	
	@ManyToOne
	@JoinColumn(name = "id")
	private Group group;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Consultant consultant;
*/	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
/*
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}
*/		
}
