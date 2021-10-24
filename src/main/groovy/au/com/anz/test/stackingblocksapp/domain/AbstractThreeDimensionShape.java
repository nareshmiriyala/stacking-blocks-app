package au.com.anz.test.stackingblocksapp.domain;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractThreeDimensionShape implements ThreeDimensionShape {
  private final Integer length;
  private final Integer width;
  private final Integer height;

  public AbstractThreeDimensionShape(Integer length, Integer width, Integer height) {
    this.length = length;
    this.width = width;
    this.height = height;
  }

  @Override
  public List<Integer> getDimensions() {
    return Arrays.asList(length, width, height);
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
}
