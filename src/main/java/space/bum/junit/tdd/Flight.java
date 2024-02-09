package space.bum.junit.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public abstract class Flight {
  private String id;
  List<Passenger> passengers = new ArrayList<>();

  public Flight(String id) {
    super();
    this.id = id;
  }

  public List<Passenger> getPassengers() {
    return Collections.unmodifiableList(passengers);
  }

  public abstract boolean addPassengers(Passenger passenger);

  public abstract boolean remotePassengers(Passenger passenger);

}
