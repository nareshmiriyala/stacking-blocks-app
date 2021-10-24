package au.com.anz.test.stackingblocksapp.biz;

import java.util.List;
import java.util.function.Predicate;

import au.com.anz.test.stackingblocksapp.domain.Block;
import au.com.anz.test.stackingblocksapp.domain.Shape;
import au.com.anz.test.stackingblocksapp.exception.InvalidBlockException;
import org.springframework.stereotype.Component;

@Component
public class BlockCalculator implements ShapeCalculator {
  @Override
  public Integer getMaxStackedHeight(List<Shape> blocks) {
    verifyIfAllBlocks(blocks);
    return null;
  }

  private void verifyIfAllBlocks(List<Shape> blocks) {
    Predicate<Shape> isNotAInstanceOfBlock = (block) -> (block instanceof Block);
    if (blocks.stream().anyMatch(isNotAInstanceOfBlock)) {
      throw new InvalidBlockException("Input shape is not a block");
    }
  }
}
