import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a temperature monitor. It tracks several thermostats, and specifically
 * monitors how many of them have been set to too hot.
 */
public class NaiveTemperatureMonitor implements TemperatureMonitor {
  private final List<Thermostat> thermostatList;

  /**
   * Constructor for the thermostat monitor list.
   */
  public NaiveTemperatureMonitor() {
    this.thermostatList = new ArrayList<Thermostat>();
  }

  /**
   * Adds a thermostat to the list of thermostats.
   * @param t - Thermostat that is being added.
   */
  public void add(Thermostat t) {
    thermostatList.add(t);
  }

  /**
   * Removes a given thermostat.
   * @param t - Thermostat that is being removed.
   */
  public void remove(Thermostat t) {
    thermostatList.remove(t);
  }

  /**
   * Finds the number of thermostats in the list.
   * @return - Int number of thermostats
   */
  public int getNumberOfThermostats() {
    return thermostatList.size();
  }

  /**
   * Checks if there is too much heating.
   * @return - Boolean if there's too much heating.
   */
  public boolean tooMuchHeating() {
    int count = 0;
    for (Thermostat t: thermostatList) {
      if (t.getSetTemperature() > 50 + 273.15) {
        count += 1;
      }
    }
    return count > 1;
  }
}
