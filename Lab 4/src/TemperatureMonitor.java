
/**
 * an interface to help monitor a bunch of temperatures.
 */
public interface TemperatureMonitor {

  /**
   * Adds thermostat to the list.
   * @param t - Thermostat that is being added.
   */
  public void add(Thermostat t);

  /**
   * Removes a given thermostat.
   * @param t - Thermostat that is being removed.
   */
  public void remove(Thermostat t);

  /**
   * Finds the number of thermostats in the list.
   * @return - Int number of thermostats
   */
  public int getNumberOfThermostats();


  /**
   * Checks if there is too much heating.
   * @return - Boolean if theres too much heating.
   */
  public boolean tooMuchHeating();
}
