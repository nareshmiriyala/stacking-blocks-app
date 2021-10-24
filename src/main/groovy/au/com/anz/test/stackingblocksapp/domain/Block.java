package au.com.anz.test.stackingblocksapp.domain;

public class Block extends AbstractThreeDimensionShape {

  private Block(Integer width, Integer length, Integer height) {

    super(length, width, height);
  }

  public static Block of(Integer width, Integer length, Integer height) {

    return new Block(length, width, height);
  }

  boolean canBePlacedOnTopOfBlock(Block comparedBlock) {
    return width >= comparedBlock.width && length >= comparedBlock.length && height >= comparedBlock.height;
  }


}
