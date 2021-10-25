package au.com.anz.test.stackingblocksapp.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import au.com.anz.test.stackingblocksapp.domain.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultBlockCalculator implements BlockCalculator {
  @Autowired
  BlockCalculatorHelper defaultBlockCalculatorHelper;

  @Override
  public OptionalInt getMaxStackedHeight(List<Block> blocks) {
    List<Block> blocksDescendingByDimension = defaultBlockCalculatorHelper.getBlocksSortedDescendingByDimension(blocks);
    return getStackedBlocksChoices.andThen(maxHeightOfStackedBlocks).apply(blocksDescendingByDimension);
  }

  static final Function<List<Block>, List<List<Block>>> getStackedBlocksChoices = (blocks) -> IntStream.range(0, blocks.size()).mapToObj(index -> {
    Block indexBlock = blocks.get(index);
    List<Block> stackedBlocks = new ArrayList<>();
    stackedBlocks.add(indexBlock);
    stackedBlocks.addAll(getBlocksPlacedUnderGivenBlock(blocks, indexBlock, index));
    return stackedBlocks;
  }).collect(Collectors.toList());

  private static List<Block> getBlocksPlacedUnderGivenBlock(List<Block> blocks, Block givenBlock, int limitIndex) {
    return blocks.stream().limit(limitIndex)
      .filter((Block innerLoopBlock) -> innerLoopBlock.canBePlacedOnTopOfBlock(givenBlock))
      .collect(Collectors.toList());
  }

  static final Function<List<List<Block>>, OptionalInt> maxHeightOfStackedBlocks = (stackedBlocksChoices) -> {
    Function<List<Block>, Integer> sum = (List<Block> bl) -> (bl.stream().map(Block::getHeight).mapToInt(Integer::intValue).sum());
    return stackedBlocksChoices.stream().map(sum).mapToInt(Integer::intValue).max();
  };


}
