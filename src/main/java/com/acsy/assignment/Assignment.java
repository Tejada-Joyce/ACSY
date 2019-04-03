package com.acsy.assignment;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.acsy.client.Client;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.history.History;

@Entity
@Table(name = "assignments")
public class Assignment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int id;

  @Column(name="completed")
  private boolean completed;

  @Column(name="histories_counter")
  private int histories_counter;

  @Column(name="total_histories")
  private int total_histories;

  @ManyToOne
  private Group group;

  @ManyToOne
  private Consultant consultant;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignment")
  private List<History> histories = new ArrayList<>();

  public Assignment() { }	

  public Assignment(Group group, Consultant consultant) {
    super();
    this.group = group;
    this.consultant = consultant;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public int getHistoriesCounter() {
    return histories_counter;
  }

  public void setHistoriesCounter(int histories_counter) {
    this.histories_counter = histories_counter;
  }

  public int getTotalHistories() {
    return total_histories;
  }

  public void setTotalHistories(int total_histories) {
    this.total_histories = total_histories;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public Consultant getConsultant() {
    return consultant;
  }

  public void setConsultant(Consultant consultant) {
    this.consultant = consultant;
  }

  public List<History> getHistories() {
    return histories;
  }

  public void setHistories(List<History> histories) {
    this.histories = histories;
  }

  @PrePersist
  public void createHistories() {
    List<Client> clients = this.group.getClients();
    this.total_histories = clients.size();
    List<History> histories = new ArrayList<>();
    for ( Client client : clients ) {
      histories.add(new History(client, this));
    }
    this.setHistories(histories);

    this.consultant.setStatus(false);
    ConsultantDAO.getInstance().update(this.consultant);

    this.group.setStatus(false);
    GroupDAO.getInstance().update(this.group);
  }

}