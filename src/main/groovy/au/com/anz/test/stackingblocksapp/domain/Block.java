package au.com.anz.test.stackingblocksapp.domain;

import java.util.Comparator;

public class Block extends AbstractThreeDimensionShape implements Comparable<Block> {

  private Block(Integer width, Integer length, Integer height) {

    super(length, width, height);
  }

  public static Block of(Integer width, Integer length, Integer height) {
    assert (width >= 0 && width <= 100) && length >= 0 && length <= 100
      && height >= 0 && height <= 100 : "Constraint: 1 <= width, length, height <= 100";
    return new Block(length, width, height);
  }

  public boolean canBePlacedOnTopOfBlock(Block comparedBlock) {
    return width >= comparedBlock.width && length >= comparedBlock.length && height >= comparedBlock.height;
  }

  @Override
  public int compareTo(Block comparingBlock) {
    return Comparator.comparing(Block::getHeight)
      .thenComparing(Block::getLength)
      .thenComparing(Block::getWidth)
      .compare(this, comparingBlock);
  }
}
