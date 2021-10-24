package au.com.anz.test.stackingblocksapp.domain;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractTwoDimensionShape implements TwoDimensionShape {
  protected final Integer width;
  protected final Integer length;

  public AbstractTwoDimensionShape(Integer width, Integer length) {
    this.width = width;
    this.length = length;

  }

  @Override
  public List<Integer> getDimensions() {
    return Arrays.asList(width, length);
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
  public String toString() {
    return "width=" + width +
      ", length=" + length
      ;
  }
}
