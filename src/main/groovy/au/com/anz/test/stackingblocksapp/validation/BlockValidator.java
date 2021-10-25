package au.com.anz.test.stackingblocksapp.validation;

import java.util.List;
import java.util.function.Function;

import au.com.anz.test.stackingblocksapp.domain.Block;
import au.com.anz.test.stackingblocksapp.exception.ValidationException;

public class BlockValidator {
  public static final Function<List<Block>, List<Block>> validateInputBlockCount = (blocks) -> {
    Integer blockCount = blocks.size();
    if (blockCount > 100 || blockCount < 1) {
      throw new ValidationException("Constraint : Number of input blocks should be between 1 and 100");
    }
    return blocks;
  };
}
