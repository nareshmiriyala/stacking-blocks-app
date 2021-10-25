package au.com.anz.test.stackingblocksapp.validation

import au.com.anz.test.stackingblocksapp.cli.BlockCommandHelper
import au.com.anz.test.stackingblocksapp.domain.Block
import au.com.anz.test.stackingblocksapp.exception.ValidationException
import spock.lang.Specification

import static au.com.anz.test.stackingblocksapp.TestData.DATA_SET_3
import static au.com.anz.test.stackingblocksapp.TestData.INPUT_DATA_3
import static au.com.anz.test.stackingblocksapp.TestData.INVALID_NUMBER_OF_BLOCKS

class BlockValidatorSpec extends Specification {
  def "ValidationException when number of input blocks n not matching constraint 1 <= n <= 100 "() {
    given:
    String input = INVALID_NUMBER_OF_BLOCKS
    when:
    BlockCommandHelper.createBlocksFromCliInput.andThen(BlockValidator.validateInputBlockCount).apply(input)
    then:
    thrown(ValidationException.class)
  }

  def "No ValidationException when number of input blocks n matching constraint 1 <= n <= 100 "() {
    given:
    String input = INPUT_DATA_3
    when:
    List<Block> blocks = BlockCommandHelper.createBlocksFromCliInput.andThen(BlockValidator.validateInputBlockCount).apply(input)
    then:
    blocks.size() == 6
    blocks == DATA_SET_3
  }
}
