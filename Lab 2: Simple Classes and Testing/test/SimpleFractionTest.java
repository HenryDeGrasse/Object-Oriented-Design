import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit Test class for the IFraction interface.
 */
public class SimpleFractionTest {
  private Fraction half;
  private Fraction quarter;
  private Fraction threeQuarter;
  private Fraction one;
  private Fraction oneThird;
  private Fraction sixteenSixteen;

  @Before
  public void setUp() {

    half = new SimpleFraction(2,4);
    quarter = new SimpleFraction(1, 4);
    threeQuarter = new SimpleFraction(3, 4);
    Fraction sixEigths = new SimpleFraction(6, 8);
    one = new SimpleFraction(8, 8);
    sixteenSixteen = new SimpleFraction(16, 16);
    oneThird = new SimpleFraction(1, 3);
  }


  @Test
  public void testToString() {
    assertEquals("3/4", this.threeQuarter.toString());
    assertEquals("8/8", this.one.toString());
    assertEquals("1/3", this.oneThird.toString());
    assertEquals("16/16", this.sixteenSixteen.toString());
    assertEquals("100/1234", new SimpleFraction(100,1234).toString());
  }

  @Test
  public void testAdd() {
    assertEquals(new SimpleFraction(12, 16).toString(), this.half.add(1,4).toString());
    assertEquals(this.sixteenSixteen.toString(), this.half.add(2,4).toString());
    assertEquals(this.sixteenSixteen.toString(), this.quarter.add(threeQuarter).toString());
  }

  // Need to test for decimal place rounding and thrown exceptions.
}