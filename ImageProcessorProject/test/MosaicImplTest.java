import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import model.Image;
import model.ImageImpl;
import model.Pixel;
import model.PixelImpl;
import model.Position;
import model.mosaic.Mosaic;
import model.mosaic.MosaicImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * This is the test class for MosaicImpl class.
 */
public class MosaicImplTest {
  Image image;
  Mosaic mosaic;

  @Before
  public void setUp() {
    ArrayList<ArrayList<Pixel>> pixels = new ArrayList<>(Arrays.asList(new ArrayList<Pixel>(
                    Arrays.asList(
                            new PixelImpl(255, 0, 0, new Position(0, 0)),
                            new PixelImpl(0, 255, 0, new Position(0, 1)),
                            new PixelImpl(0, 0, 255, new Position(0, 2)))),
            new ArrayList<Pixel>(
                    Arrays.asList(
                            new PixelImpl(255, 255, 0, new Position(1, 0)),
                            new PixelImpl(255, 255, 255, new Position(1, 1)),
                            new PixelImpl(0, 0, 0, new Position(1, 2)))),
            new ArrayList<Pixel>(
                    Arrays.asList(
                            new PixelImpl(0, 255, 255, new Position(2, 0)),
                            new PixelImpl(75, 75, 75, new Position(2, 1)),
                            new PixelImpl(
                                    127, 127, 127, new Position(2, 2))))));
    Image image = new ImageImpl(pixels);
    this.image = image;
    this.mosaic = new MosaicImpl();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullImage() {
    new MosaicImpl().applyMosaic(null, 1000);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSeeds() {
    new MosaicImpl().applyMosaic(image, -1000);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMosaicNumSeedsTooMany() {
    new MosaicImpl().applyMosaic(image, 100);
  }

  @Test
  public void testMosaic5Seeds() {
    Image newImage = this.mosaic.applyMosaic(image, 5);
    assertEquals(newImage.getPixels().size(), this.image.getPixels().size());
    assertEquals(newImage.getPixels().get(0).size(), this.image.getPixels().get(0).size());
    assertNotEquals(newImage.getPixels(), this.image.getPixels());
  }


  @Test
  public void testMosaic1Seed() {
    ArrayList<ArrayList<Pixel>> pixels = new ArrayList<>(Arrays.asList(new ArrayList<Pixel>(
                    Arrays.asList(
                            new PixelImpl(
                                    107, 135, 107, new Position(0, 0)),
                            new PixelImpl(
                                    107, 135, 107, new Position(0, 1)),
                            new PixelImpl(
                                    107, 135, 107, new Position(0, 2)))),
            new ArrayList<Pixel>(
                    Arrays.asList(
                            new PixelImpl(107, 135, 107, new Position(1, 0)),
                            new PixelImpl(107, 135, 107, new Position(1, 1)),
                            new PixelImpl(
                                    107, 135, 107, new Position(1, 2)))),
            new ArrayList<Pixel>(
                    Arrays.asList(
                            new PixelImpl(107, 135, 107, new Position(2, 0)),
                            new PixelImpl(107, 135, 107, new Position(2, 1)),
                            new PixelImpl(
                                    107, 135, 107, new Position(2, 2))))));
    Image expect = new ImageImpl(pixels);
    Image actual = this.mosaic.applyMosaic(image, 1);
    assertTrue(equalImages(expect, actual));
  }

  @Test
  public void testMosaicTwice() {
    Image newImage1 = this.mosaic.applyMosaic(image, 5);
    Image newImage2 = this.mosaic.applyMosaic(newImage1, 5);
    assertEquals(newImage2.getPixels().size(), this.image.getPixels().size());
    assertEquals(newImage2.getPixels().get(0).size(), this.image.getPixels().get(0).size());
    assertNotEquals(newImage2.getPixels(), this.image.getPixels());
  }

  private boolean equalImages(Image expected, Image actual) {
    if (expected.getWidth() != actual.getWidth() || expected.getHeight() != actual.getHeight()) {
      return false;
    }
    for (int yy = 0; yy < expected.getHeight(); yy++) {
      for (int xx = 0; xx < expected.getWidth(); xx++) {
        if (expected.getPixels().get(yy).get(xx).getRed()
                != actual.getPixels().get(yy).get(xx).getRed()) {
          return false;
        } else if (expected.getPixels().get(yy).get(xx).getGreen()
                != actual.getPixels().get(yy).get(xx).getGreen()) {
          return false;
        } else if (expected.getPixels().get(yy).get(xx).getBlue()
                != actual.getPixels().get(yy).get(xx).getBlue()) {
          return false;
        }
      }
    }
    return true;
  }
}