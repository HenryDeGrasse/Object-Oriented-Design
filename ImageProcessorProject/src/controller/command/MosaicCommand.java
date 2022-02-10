package controller.command;

import model.ImageModel;

/**
 * This class represents a mosaic command.
 */
public class MosaicCommand implements ImageCommand {
  private final int seed;

  /**
   * Constructs the mosaic operation given an seed to mosaicd by on a certain image.
   */
  public MosaicCommand(int seed) {
    this.seed = seed;
  }

  @Override
  public void execute(ImageModel im, String id, String dest) {
    im.mosaic(id, dest, seed);
  }
}
