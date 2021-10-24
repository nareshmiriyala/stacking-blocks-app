package au.com.anz.test.stackingblocksapp.biz;

import java.util.List;

import au.com.anz.test.stackingblocksapp.domain.Block;

public interface BlockCalculatorHelper {
  List<Block> getBlocksSortedDescendingByDimension(List<Block> blocks);
}
