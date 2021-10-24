package au.com.anz.test.stackingblocksapp.domain;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractThreeDimensionShape implements ThreeDimensionShape {
  protected final Integer length;
  protected final Integer width;
  protected final Integer height;

  public AbstractThreeDimensionShape(Integer length, Integer width, Integer height) {
    this.length = length;
    this.width = width;
    this.height = height;
  }

  @Override
  public List<Integer> getDimensions() {
    return Arrays.asList(width, length, height);
  }

  @Override
  public Integer getLength() {
    return length;
  }

  @Override
  public Integer getWidth() {
    return width;
  }

  @Override
  public Integer getHeight() {
    return height;
  }

  @Override
  public String toString() {
    return "length=" + length +
      ", width=" + width +
      ", height=" + height
      ;
  }
}
