import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A class for testing the naive temperature monitor class.
 */
public class NaiveTemperatureMonitorTest {



  @Test
  public void tooMuchHeating() {
    NaiveTemperatureMonitor ex = new NaiveTemperatureMonitor();
    SimpleThermostat ex1 = new SimpleThermostat("ABC", 23.5);
    SimpleThermostat ex2 = new SimpleThermostat("DEF", 23.75);
    SimpleThermostat ex3 = new SimpleThermostat("GHI", 61);
    SimpleThermostat ex4 = new SimpleThermostat("GHI", 56);
    ex.add(ex1);
    ex.add(ex2);
    assertEquals(false, ex.tooMuchHeating());
    ex.remove(ex2);
    ex.add(ex3);
    ex.add(ex4);
    assertEquals(true, ex.tooMuchHeating());
  }
}