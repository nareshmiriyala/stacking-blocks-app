package au.com.anz.test.stackingblocksapp.domain;

public class Square extends AbstractTwoDimensionShape {

  private Square(Integer length, Integer width) {
    super(length, width);
  }

  public static Square of(Integer length, Integer width) {
    return new Square(length, width);
  }
}
