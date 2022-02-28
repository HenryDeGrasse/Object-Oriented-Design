/**
 * Class for simple fractions.
 */
public class SimpleFraction implements Fraction {

  int numerator;
  int denominator;

  SimpleFraction(int numerator, int denominator) {
    if (numerator < 0 && denominator < 0) {
      this.numerator = numerator * -1;
      this.denominator = denominator * -1;
    } else if (numerator >= 0 && denominator > 0) {
      this.numerator = numerator;
      this.denominator = denominator;
    } else {
      throw new IllegalArgumentException("Please only non-negative fractions.");
    }
  }

  public String toString() {
    return this.numerator + "/" + this.denominator;
  }

  //adds two fractions together
  public Fraction add(Fraction other) {
    return other.add(this.numerator, this.denominator);
  }


  /**
   * method to add a fraction with a fraction.
   */
  public Fraction add(int numerator, int denominator) {
    if ((numerator > 0 && denominator > 0) || numerator < 0 && denominator < 0) {
      int newN = this.numerator * denominator;
      int newD = this.denominator * denominator;
      int otherN = numerator * this.denominator;
      return new SimpleFraction(newN + otherN, newD);
    }
    else {
      throw new IllegalArgumentException("Please only non-negative fractions.");
    }
  }

  // gets the decimal value of a fraction
  public double getDecimalValue(int places) {
    double d = (double) this.numerator / this.denominator;
    return  Math.round(d * Math.pow(10, places)) / (double) Math.pow(10, places);
  }
}
