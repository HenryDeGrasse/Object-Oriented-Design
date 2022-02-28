import java.util.Objects;

/**
 * Class for a simple thermostat.
 */
public class SimpleThermostat implements Thermostat {
  String id;
  double temp;

  /**
   * Constructor for a simple thermostat.
   * @param id - String - the ID for the thermostat.
   * @param temp - double - the temperature for the thermostat.
   */
  public SimpleThermostat(String id, double temp) {
    temp = temp + 273.15;
    if (id == null || id.equals("") || temp > 50 + 273.15) {
      throw new IllegalArgumentException("Invalid thermostat.");
    } else {
      this.id = id;
      this.temp = temp;
    }
  }

  @Override
  public String getID() {
    return this.id;
  }

  @Override
  public double getSetTemperature() {
    return this.temp;
  }

  //Can not increase the set temperature past 50
  @Override
  public void increaseSetTemperature() {
    if (this.temp <= 49.9 + 273.15) {
      this.temp += 0.1;
    }
  }

  @Override
  public void decreaseSetTemperature() {
    this.temp -= 0.1;
  }

  /**
   * Checks if the given object is equal to this thermostat.
   * @param o - And object o
   * @return - boolean if its equal
   */
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    else if (!(o instanceof Thermostat)) {
      return false;
    }
    Thermostat other = (Thermostat) o;

    return (this.getID().equals(other.getID())) &&
            (Math.round(this.getSetTemperature() * 100) / 100)
                    == (Math.round(other.getSetTemperature() * 100) / 100);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }


  /*@Override
  public boolean equals(Object o){
    if(this==o){
      return true;
    }

    else if (!(o instanceof Thermostat)){
      return false;
    }
    Thermostat other = (Thermostat) o;

    return (this.getID().equals(other.getID())) &&
            (Math.abs(this.getSetTemperature() - other.getSetTemperature()) < 0.01);
  }

  @Override
  public int hashCode(){
    return Objects.hash(this.ID);
  } */


}
