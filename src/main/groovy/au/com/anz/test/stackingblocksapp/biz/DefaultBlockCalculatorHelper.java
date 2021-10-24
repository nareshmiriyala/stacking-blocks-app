package au.com.anz.test.stackingblocksapp.biz;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import au.com.anz.test.stackingblocksapp.domain.Block;
import au.com.anz.test.stackingblocksapp.domain.Shape;
import org.springframework.stereotype.Component;

@Component
public class DefaultBlockCalculatorHelper implements BlockCalculatorHelper {
  @Override
  public List<Block> getBlocksSortedDescendingByDimension(List<Block> blocks) {
    return blocks.stream().map(blocksDimensionOrderedByMaxHeight).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
  }

  static final Function<Shape, Block> blocksDimensionOrderedByMaxHeight = (shape) -> {
    Block block = (Block) shape;
    List<Integer> dimensions = Stream.of(block.getHeight(), block.getLength(), block.getWidth()).sorted().collect(Collectors.toList());
    return Block.of(dimensions.get(0), dimensions.get(1), dimensions.get(2));
  };
}
