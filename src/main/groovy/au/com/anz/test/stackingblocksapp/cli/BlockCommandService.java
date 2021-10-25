package au.com.anz.test.stackingblocksapp.cli;

import java.util.OptionalInt;

import au.com.anz.test.stackingblocksapp.biz.BlockCalculator;
import au.com.anz.test.stackingblocksapp.exception.BlockStackingAppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static au.com.anz.test.stackingblocksapp.validation.BlockValidator.validateInputBlockCount;

@Service
public class BlockCommandService implements CommandService {

  private static final Logger log = LoggerFactory.getLogger(BlockCommandService.class);
  @Autowired
  BlockCalculator defaultBlockCalculator;

  @Override
  public void execute(String inputData) {

    OptionalInt maxStackedHeight = BlockCommand.createBlocksFromCliInput
      .andThen(validateInputBlockCount).andThen(defaultBlockCalculator::getMaxStackedHeight).apply(inputData);
    if (maxStackedHeight.isPresent()) {
      log.info("Total height is: " + maxStackedHeight.getAsInt());
    }
    else {
      throw new BlockStackingAppException("Exception getting height of stacked blocks");
    }
  }

}
