package model.mosaic;

import java.util.ArrayList;
import java.util.Random;

import model.Image;
import model.ImageImpl;
import model.Pixel;
import model.PixelImpl;
import model.Position;


/**
 * This class represents the simple implementation of mosaic operations on a certain image, the
 * image would be masaiced by the given seed in the applyMosaic method.
 */
public class MosaicImpl implements Mosaic {

  @Override
  public Image applyMosaic(Image image, int seed)
          throws IllegalArgumentException {
    if (image == null || seed < 0 ||
            seed > (image.getPixels().size() * image.getPixels().get(0).size())) {
      throw new IllegalArgumentException("The given arguments are invalid.");
    }

    int height = image.getHeight();
    int width = image.getWidth();

    // create a array for all the random seeds to mosaic the given image
    RandomSeed[] randomSeeds = new RandomSeed[seed];
    Random rand = new Random();

    // adds random seed locations to the random seed's array to initialize all the random sees
    for (int i = 0; i < seed; i++) {
      randomSeeds[i] = new RandomSeed(rand.nextInt(width), rand.nextInt(height));
    }

    // create a n * 3 array(n is the number of seeds the user gives) to record the sum for each
    // seed's red,green,blue channels,
    // in each seed's 3-element array :
    // the first value is the sum of the randomSeed's red values for a list pixel clusters
    // it corresponded to
    // the second value is the sum of the randomSeed's green values for a list pixel clusters
    // it corresponded to
    // the third value is the sum of the randomSeed's blue values for a list pixel clusters
    // it corresponded to
    int[][] seedColors = new int[seed][3];

    // Pairs each pixel in the given image to the closest seed and update the closest seeds's sum
    // green/red/blue value
    int[] numPixelsPerSeed = new int[seed];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int currentSeedIndex = this.closestSeedIndex(j, i, randomSeeds);
        Pixel currentPixel = image.getPixels().get(i).get(j);
        // update the current closest seed's sum of red colors for its corresponding pixel cluster
        seedColors[currentSeedIndex][0] += currentPixel.getRed();
        // update the current closest seed's sum of red colors for its corresponding pixel cluster
        seedColors[currentSeedIndex][1] += currentPixel.getGreen();
        // update the current closest seed's sum of red colors for its corresponding pixel cluster
        seedColors[currentSeedIndex][2] += currentPixel.getBlue();
        // update number of pixels for the current closest seed is corresponding to
        numPixelsPerSeed[currentSeedIndex]++;
      }
    }

    // average the color for each seed's red,green,green value
    this.averageSeedsColor(seedColors, numPixelsPerSeed);

    // create the mosaicImage of the current image;
    return this.createMosaicImage(image, seedColors, randomSeeds);
  }

  /**
   * Returns the index of the closest seed to the given coordinates.
   *
   * @param x     the x-coordinate of the point
   * @param y     the y-coordinate of the point
   * @param seeds the array of random seeds for masticating the image
   * @return the index of the closest seed to the given coordinates.
   */
  private int closestSeedIndex(int x, int y, RandomSeed... seeds) {
    double minDistance = Integer.MAX_VALUE;
    int closestSeedIndex = 0;
    for (int i = 0; i < seeds.length; i++) {
      RandomSeed currentSeed = seeds[i];
      double distance = distance(currentSeed.getX(), currentSeed.getY(), x, y);
      if (distance < minDistance) {
        minDistance = distance;
        closestSeedIndex = i;
      }
    }
    return closestSeedIndex;
  }

  /**
   * Determines the distance between two given points.
   *
   * @param x1 the x coordinate of the first point
   * @param y1 the y coordinate of the first point
   * @param x2 the x coordinate of the second point
   * @param y2 the y coordinate of the second point
   * @return the distance between two points
   */
  private double distance(int x1, int y1, int x2, int y2) {
    double x = Math.pow(x2 - x1, 2);
    double y = Math.pow(y2 - y1, 2);
    return Math.sqrt(x + y);
  }

  /**
   * compute the average green,blue,red color for a seed's pixel clusters.
   *
   * @param seedColors       the array for sum of green/blue/red of all the seeds.
   * @param numPixelsPerSeed the number of pixels each seeds includes in a array.
   */
  private void averageSeedsColor(int[][] seedColors, int[] numPixelsPerSeed) {
    for (int i = 0; i < numPixelsPerSeed.length; i++) {
      for (int j = 0; j < 3; j++) {
        try {
          seedColors[i][j] /= numPixelsPerSeed[i];
        } catch (ArithmeticException ignored) {
        }
      }
    }
  }

  /**
   * Create a Mosaic Image for the current given image.
   *
   * @param image      the image waiting for mosaic.
   * @param seedColors array of average red/green/blue color for pixel clusters.
   * @param seeds      all the seeds to mosaic the current image.
   * @return a Mosaic Image for the current given image.
   */
  private Image createMosaicImage(Image image, int[][] seedColors, RandomSeed[] seeds) {
    // We have to define the image content as a ArrayList of pixels rather than
    // List<List<Pixel>> because our code provider defined the grid field in the ImageImpl class
    // as a ArrayList<ArrayList<Pixel>>, if we define it as the List<List<Pixel>> there,
    // the return statement of this method would give a compile error.Due to the close to
    // modification and open to extension principle, we decided to maintain as it is.
    // We mentioned this in the code review.
    ArrayList<ArrayList<Pixel>> contents = new ArrayList<>();
    int height = image.getHeight();
    int width = image.getWidth();
    for (int i = 0; i < height; i++) {
      ArrayList<Pixel> row = new ArrayList<>();
      for (int j = 0; j < width; j++) {
        //get the closest seeds' color for the current pixel
        int[] seedColor = seedColors[this.closestSeedIndex(j, i, seeds)];
        //clamp all the color values
        int currentRed = clamp(seedColor[0]);
        int currentGreen = clamp(seedColor[1]);
        int currentBlue = clamp(seedColor[2]);
        Pixel newPixel = new PixelImpl(currentRed, currentGreen, currentBlue, new Position(j, i));
        row.add(newPixel);
      }
      contents.add(row);
    }
    return new ImageImpl(contents);
  }

  /**
   * Represents a private helper class that has a position where the random seed is located.
   */
  private static class RandomSeed {

    private final int x;
    private final int y;


    /**
     * Constructs an RandomSeed object which represents a random seed to be used in a mosaic
     * object.
     *
     * @param x the x coordinate of the random seed
     * @param y the y coordinate of the random seed
     * @throws IllegalArgumentException if the given x and/or y values are negative
     */
    private RandomSeed(int x, int y) throws IllegalArgumentException {
      if (x < 0 || y < 0) {
        throw new IllegalArgumentException("Random seed is out of bounds!");
      }

      this.x = x;
      this.y = y;
    }

    /**
     * Gets the x coordinate of this random seed.
     *
     * @return the x coordinate of this random seed
     */
    private int getX() {
      return this.x;
    }

    /**
     * Gets the y coordinate of this random seed.
     *
     * @return the y coordinate of this random seed.
     */
    private int getY() {
      return this.y;
    }

  }

  /**
   * Clamps the given value to be 255.
   *
   * @param colorValue the color value to be clamped
   * @return the clamped integer value
   */
  private int clamp(int colorValue) {
    if (colorValue > 255) {
      return 255;
    } else {
      return Math.max(colorValue, 0);
    }
  }
}
