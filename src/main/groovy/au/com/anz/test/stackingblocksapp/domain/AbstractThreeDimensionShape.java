package au.com.anz.test.stackingblocksapp.domain;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractThreeDimensionShape implements ThreeDimensionShape {
  protected final Integer width;
  protected final Integer length;
  protected final Integer height;

  public AbstractThreeDimensionShape(Integer width, Integer length, Integer height) {
    this.width = width;
    this.length = length;
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
    return "width=" + width +
      ", length=" + length +
      ", height=" + height
      ;
  }
}
