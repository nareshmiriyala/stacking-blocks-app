package au.com.anz.test.stackingblocksapp.biz;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import au.com.anz.test.stackingblocksapp.domain.Block;
import org.springframework.stereotype.Component;

@Component
public class DefaultBlockCalculatorHelper implements BlockCalculatorHelper {
  @Override
  public List<Block> getBlocksSortedDescendingByDimension(List<Block> blocks) {
    return blocks.stream().map(rearrangeBlockDimensionByMaxHeight).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
  }

  static final Function<Block, Block> rearrangeBlockDimensionByMaxHeight = (block) -> {
    List<Integer> dimensions = block.getDimensions().stream().sorted().collect(Collectors.toList());
    return Block.of(dimensions.get(0), dimensions.get(1), dimensions.get(2));
  };
}
