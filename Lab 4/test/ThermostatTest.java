import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing the thermostat interface.
 */
public class ThermostatTest {

  private Thermostat hot;
  private Thermostat alsoHot;
  private Thermostat alsoHotYes;
  private Thermostat cold;
  private Thermostat alsoCold;

  @Before
  public void setUp() {
    hot = new SimpleThermostat("hot", 30.30);
    alsoHot = new SimpleThermostat("hot", 29.995);
    alsoHotYes = new SimpleThermostat("hot", 30.305);
    cold = new SimpleThermostat("cold", 15.15);
    alsoCold = new SimpleThermostat("cold", 15.1505);
  }

  @Test
  public void getID() {
    assertEquals("hot", this.hot.getID());
    assertEquals("hot", this.alsoHot.getID());
    assertEquals("hot", this.alsoHotYes.getID());
    assertEquals("cold", this.alsoCold.getID());
    assertEquals("cold", this.cold.getID());
  }

  @Test
  public void getSetTemperature() {
    assertEquals(30.30 + 273.15, this.hot.getSetTemperature(),0.000001);
    assertEquals(29.995 + 273.15, this.alsoHot.getSetTemperature(),0.000001);
    assertEquals(30.305 + 273.15, this.alsoHotYes.getSetTemperature(),0.000001);
    assertEquals(15.1505 + 273.15, this.alsoCold.getSetTemperature(),0.000001);
    assertEquals(15.15 + 273.15, this.cold.getSetTemperature(),0.000001);
  }

  @Test
  public void increaseSetTemperature() {
    this.hot.increaseSetTemperature();
    this.alsoHot.increaseSetTemperature();
    this.cold.increaseSetTemperature();
    this.alsoCold.increaseSetTemperature();
    assertEquals(30.40 + 273.15, this.hot.getSetTemperature(),0.000001);
    this.hot.increaseSetTemperature();
    assertEquals(30.50 + 273.15, this.hot.getSetTemperature(),0.000001);
    assertEquals(30.095 + 273.15, this.alsoHot.getSetTemperature(),0.000001);
    assertEquals(15.2505 + 273.15, this.alsoCold.getSetTemperature(),0.000001);
    assertEquals(15.25 + 273.15, this.cold.getSetTemperature(),0.000001);
  }

  @Test
  public void decreaseSetTemperature() {
    this.hot.decreaseSetTemperature();
    this.alsoHot.decreaseSetTemperature();
    this.cold.decreaseSetTemperature();
    this.alsoCold.decreaseSetTemperature();
    assertEquals(30.20 + 273.15, this.hot.getSetTemperature(),0.000001);
    this.hot.decreaseSetTemperature();
    assertEquals(30.10 + 273.15, this.hot.getSetTemperature(),0.000001);
    assertEquals(29.895 + 273.15, this.alsoHot.getSetTemperature(),0.000001);
    assertEquals(15.0505 + 273.15, this.alsoCold.getSetTemperature(),0.000001);
    assertEquals(15.05 + 273.15, this.cold.getSetTemperature(),0.000001);
  }

  @Test
  public void testEquals() {
    assertEquals(true, alsoCold.equals(cold));
    assertEquals(false, alsoHot.equals(cold));
    assertEquals(true, alsoHotYes.equals(hot));

  }


}