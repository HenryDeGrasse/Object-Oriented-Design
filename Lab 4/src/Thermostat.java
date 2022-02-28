/**
 * An interface to represent a thermostat.
 */
public interface Thermostat {
  /**
   * A method to find the thermostats ID number.
   * @return String (a string ID)
   */
  String getID();

  /**
   * A method to return the current set temperature.
   * @return double (temperature)
   */
  double getSetTemperature();

  /**
   * A method to increase the current temperature.
   */
  void increaseSetTemperature();

  /**
   * A method to decrease the current temperature.
   */
  void decreaseSetTemperature();
}
