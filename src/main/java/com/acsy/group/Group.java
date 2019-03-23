package com.acsy.group;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.acsy.client.Client;

@Entity
@Table(name="groups")

public class Group {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "groups")
	private List<Client> clients = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "groups")
	private List<History> histories = new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<History> getHistories() {
		return histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}
	
}
