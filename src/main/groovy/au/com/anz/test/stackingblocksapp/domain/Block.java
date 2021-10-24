package au.com.anz.test.stackingblocksapp.domain;

import java.util.Comparator;

import au.com.anz.test.stackingblocksapp.exception.ValidationException;

public class Block extends AbstractThreeDimensionShape implements Comparable<Block> {

  public static final int MAX_DIMENSION = 100;
  public static final int MIN_DIMENSION = 0;

  private Block(Integer width, Integer length, Integer height) {

    super(length, width, height);
  }

  public static Block of(Integer width, Integer length, Integer height) {
    if (!((width >= MIN_DIMENSION && width <= MAX_DIMENSION) && (length >= MIN_DIMENSION && length <= MAX_DIMENSION)
      && (height >= MIN_DIMENSION && height <= MAX_DIMENSION)))
      throw new ValidationException("Constraint: 1 <= width, length, height <= 100");

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
