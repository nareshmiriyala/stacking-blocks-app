package au.com.anz.test.stackingblocksapp.biz;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import au.com.anz.test.stackingblocksapp.domain.Block;
import au.com.anz.test.stackingblocksapp.domain.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultBlockCalculator implements BlockCalculator {
  @Autowired
  BlockCalculatorHelper defaultBlockCalculatorHelper;
  @Override
  public OptionalInt getMaxStackedHeight(List<Block> blocks) {
    List<Block> descendingByDimension = defaultBlockCalculatorHelper.getBlocksSortedDescendingByDimension(blocks);
    return OptionalInt.empty();
  }

}
