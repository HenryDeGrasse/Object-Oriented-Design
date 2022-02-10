package model.mosaic;

import model.Image;

/**
 * This interface represents a  mosaicking operation on a given image.
 */
public interface Mosaic {
  /**
   * Applies mosaicking onto an given image with the given number of random seeds,
   * and gets the mosaicked image's component.
   *
   * @param image the input image to be mosaicked
   * @param seed  number of random seeds to create the new image component
   * @return a new Image after mosaicking.
   * @throws IllegalArgumentException if the given image is null and the given seed is negative
   */
  Image applyMosaic(Image image, int seed) throws IllegalArgumentException;
}
