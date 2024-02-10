package space.bum.junit.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AirportTest {

  @Nested
  @DisplayName("하나의 일반 항공편 시험")
  class EconomyTest {
    private Flight economyFlight;

    @BeforeEach
    void setup() {
      economyFlight = new EconomyFlight("1");
    }

    @Test
    void economy_일반승객탑승_시험() {
      Passenger bong = new Passenger("봉", false);
      
      assertEquals("1", economyFlight.getId());
      assertEquals(true, economyFlight.addPassenger(bong));
      assertEquals(1, economyFlight.getPassengers().size());
      assertEquals("봉", economyFlight.getPassengers().get(0).getName());

      assertEquals(true, economyFlight.removePassenger(bong));
      assertEquals(0, economyFlight.getPassengers().size());
    }
    
    @Test
    void economy_vip승객탑승_시험() {
      Passenger choi = new Passenger("최", true);
      
      assertEquals("1", economyFlight.getId());
      assertEquals(true, economyFlight.addPassenger(choi));
      assertEquals(1, economyFlight.getPassengers().size());
      assertEquals("최", economyFlight.getPassengers().get(0).getName());
      
      assertEquals(false, economyFlight.removePassenger(choi));
      assertEquals(1, economyFlight.getPassengers().size());
    }
  }

}
