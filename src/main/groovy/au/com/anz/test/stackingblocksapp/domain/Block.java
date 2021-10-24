package au.com.anz.test.stackingblocksapp.domain;

import java.util.Comparator;

public class Block extends AbstractThreeDimensionShape implements Comparable<Block> {

  private Block(Integer width, Integer length, Integer height) {

    super(length, width, height);
  }

  public static Block of(Integer width, Integer length, Integer height) {

    return new Block(length, width, height);
  }

  boolean canBePlacedOnTopOfBlock(Block comparedBlock) {
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
