/**
 * interface for fractions.
 */
public interface Fraction {

  // A method to add two fraction objects
  Fraction add(Fraction other);

  // A method to add a fraction with another in the form of num/deno
  Fraction add(int numerator, int denominator);

  // returns the decimal value of a fraction
  double getDecimalValue(int places);
}
