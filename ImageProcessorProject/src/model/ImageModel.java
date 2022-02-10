package model;

/**
 * Represents the model for an Image Processing and Enhancement application.
 */
public interface ImageModel extends ImageModelState {
  // change for hw 7: add a new method mosaic in the model.

  /**
   * Gets an image based off its key.
   *
   * @param id the desired image's key
   * @return an Image given its id from map of Images
   */
  Image getImage(String id);

  /**
   * Creates an image with value-component formula applied.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   */
  void maxValue(String id, String dest);

  /**
   * Creates an image with intensity formula applied.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   */
  void intensity(String id, String dest);

  /**
   * Creates an image with luma formula applied.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   */
  void luma(String id, String dest);

  /**
   * Creates an image with all its pixels set to their red
   * component.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   */
  void redComponent(String id, String dest);

  /**
   * Creates an image with all its pixels set to their green
   * component.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   */
  void greenComponent(String id, String dest);

  /**
   * Creates an image with all its pixels set to their blue
   * component.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   */
  void blueComponent(String id, String dest);

  /**
   * Creates an image that is brightened by a given increment.
   *
   * @param id     the name of the desired image to be processed
   * @param dest   the name of the newly processed image
   * @param change the desired increment to brighten the image
   */
  void brighten(String id, String dest, int change);

  /**
   * Creates an image that flipped vertically.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   */
  void verticallyFlip(String id, String dest);

  /**
   * Creates an image that flipped horizontally.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   */
  void horizontallyFlip(String id, String dest);

  /**
   * Loads an image onto the model of the Image Processor.
   *
   * @param filePath the file-path of the new Image
   * @param id       the name of the newly loaded image
   */
  void loadPPM(String filePath, String id);

  /**
   * Saves an image from the model of the Image Processor
   * with a file-path.
   *
   * @param filePath the new file-path of the newly saved image
   * @param id       the key of the saved image
   */
  void savePPM(String filePath, String id);


  /**
   * Creates an image that is in sepia-style.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   */
  void sepia(String id, String dest);

  /**
   * Creates an image that is sharpened.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   */
  void sharpen(String id, String dest);

  /**
   * Creates an image that is blurred.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   */
  void blur(String id, String dest);

  /**
   * Mosaic an Image from the model of the Image Processor.
   *
   * @param id   the name of the desired image to be processed
   * @param dest the name of the newly processed image
   * @param seed the desired seed to Mosaic the image
   */
  void mosaic(String id, String dest, int seed);
}
