package model;

import model.filter.Filter;
import model.filter.FilterImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * Represents and abstracts all variant implementations of an Image.
 */
public abstract class AbstractImage implements Image {

  protected final ArrayList<ArrayList<Pixel>> pixels;

  /**
   * Constructs and abstracts all variant class for an Image given a 2D array-list of pixels.
   *
   * @param pixels represents a matrix of pixels that make up an Image
   */
  public AbstractImage(ArrayList<ArrayList<Pixel>> pixels)
      throws IllegalArgumentException {
    if (pixels == null) {
      throw new IllegalArgumentException("Image cannot have null pixels");
    }
    this.pixels = pixels;
  }

  @Override
  public Image getValue() {
    return imageHelper(Pixel::getValue);
  }

  @Override
  public Image getIntensity() {
    return imageHelper(Pixel::getIntensity);
  }

  @Override
  public Image getLuma() {
    return imageHelper(Pixel::getLuma);
  }

  @Override
  public Image getRedComponent() {
    return imageHelper(Pixel::getRedComponent);
  }

  @Override
  public Image getGreenComponent() {
    return imageHelper(Pixel::getGreenComponent);
  }

  @Override
  public Image getBlueComponent() {
    return imageHelper(Pixel::getBlueComponent);
  }

  @Override
  public Image brighten(int change) {
    return imageHelper(pixel -> pixel.brighten(change));
  }


  @Override
  public Image sepia() {
    return imageHelper(Pixel::sepia);
  }

  @Override
  public Image savePPM(String filePath) throws IllegalArgumentException {
    File file;
    FileOutputStream stream;

    try {
      file = new File(filePath);
      if (!file.createNewFile()) {
        throw new IllegalArgumentException("The file already exists.");
      }
    } catch (IOException e) {
      throw new IllegalArgumentException("Cannot create file.");
    }

    try {
      stream = new FileOutputStream(file);
      stream.write(this.getPPMString().getBytes(StandardCharsets.UTF_8));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File not found.");
    } catch (IOException e) {
      throw new IllegalArgumentException("Unable to write to file.");
    }
    return createImage(pixels);
  }

  protected String getPPMString() {
    //any risk of aliasing here?
    StringBuilder result = new StringBuilder();
    result.append("P3\n").append(pixels.get(0).size())
        .append(" ").append(pixels.size())
        .append("\n")
        .append("255\n");

    for (ArrayList<Pixel> pixel : pixels) {
      for (Pixel p : pixel) {
        result.append(p.getRed()).append(" ")
            .append(p.getGreen()).append(" ")
            .append(p.getBlue()).append("\n");
      }
    }
    return result.toString();
  }

  @Override
  public Image flipVertical() {
    ArrayList<ArrayList<Pixel>> newPixels = new ArrayList<ArrayList<Pixel>>();

    for (int row = 0; row < pixels.size(); row++) {
      ArrayList<Pixel> pRow = new ArrayList<Pixel>();
      for (int col = 0; col < pixels.get(0).size(); col++) {
        pRow.add(pixels.get(pixels.size() - 1 - row).get(col));
      }
      newPixels.add(pRow);
    }

    return createImage(newPixels);

  }

  @Override
  public Image flipHorizontal() {
    ArrayList<ArrayList<Pixel>> newPixels = new ArrayList<ArrayList<Pixel>>();

    for (ArrayList<Pixel> pixel : pixels) {
      ArrayList<Pixel> pRow = new ArrayList<Pixel>();
      for (int col = 0; col < pixels.get(0).size(); col++) {
        pRow.add(pixel.get(pixels.get(0).size() - 1 - col));
      }
      newPixels.add(pRow);
    }

    return createImage(newPixels);
  }


  protected Image imageHelper(Function<Pixel, Pixel> action) {
    ArrayList<ArrayList<Pixel>> newPixels = new ArrayList<ArrayList<Pixel>>();
    for (ArrayList<Pixel> pixelRow : pixels) {
      ArrayList<Pixel> pRow = new ArrayList<Pixel>();
      for (Pixel p : pixelRow) {
        pRow.add(action.apply(p));
      }
      newPixels.add(pRow);
    }
    return createImage(newPixels);
  }

  protected abstract Image createImage(ArrayList<ArrayList<Pixel>> pixels);

  public Image duplicateImage() {
    return imageHelper(pixel -> pixel);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    for (ArrayList<Pixel> pixelRow : pixels) {
      for (Pixel pixel : pixelRow) {
        builder.append("(")
                .append(pixel.getRed())
                .append(", ")
                .append(pixel.getGreen())
                .append(", ")
                .append(pixel.getBlue())
                .append(")");
      }
      builder.append("\n");
    }

    return builder.toString();
  }


  @Override
  public ArrayList<ArrayList<Pixel>> getPixels() {
    ArrayList<ArrayList<Pixel>> newPixels = new ArrayList<ArrayList<Pixel>>();
    for (ArrayList<Pixel> pixelRow : pixels) {
      ArrayList<Pixel> pRow = new ArrayList<Pixel>(pixelRow);
      newPixels.add(pRow);
    }

    return newPixels;

  }


  @Override
  public Image sharpen() {

    Filter filter = new FilterImpl();
    double[][] sharpen = new double[][]{{-0.125, -0.125, -0.125, -0.125, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, 0.25, 1, 0.25, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, -0.125, -0.125, -0.125, -0.125}};

    return createImage(filter.applyFilter(this, sharpen));
  }


  @Override
  public Image blur() {

    Filter filter = new FilterImpl();
    double[][] blur = new double[][]{{0.0625, 0.125, 0.0625},
        {0.125, 0, 25, 0.125},
        {0.0625, 0, 125, 0.0625}};

    return createImage(filter.applyFilter(this, blur));
  }

}
