package com.yernar.car.database.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ownerid;
    private String firstname, lastname;

    public Owner() {}

    public Owner(String firstname, String lastname) {
      super();
      this.firstname = firstname;
      this.lastname = lastname;
    }

    //start of setting the relation to car
    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
    @JsonIgnore
    private List<Car> cars;

    //Getter and setter
    public List<Car> getCars() {
      return cars;
    }

    public void setCars(List<Car> cars) {
      this.cars = cars;
    }
    //end

    public long getOwnerid() {
      return ownerid;
    }
    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }
      public String getFirstname() {
        return firstname;
      }
      public void setFirstname(String firstname) {
        this.firstname = firstname;
      }
      public String getLastname() {
        return lastname;
      }
      public void setLastname(String lastname) {
        this.lastname = lastname;
      }
}
