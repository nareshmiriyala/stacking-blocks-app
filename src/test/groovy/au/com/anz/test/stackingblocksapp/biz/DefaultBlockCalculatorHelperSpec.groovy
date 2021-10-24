package au.com.anz.test.stackingblocksapp.biz


import au.com.anz.test.stackingblocksapp.domain.Block
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

import static au.com.anz.test.stackingblocksapp.TestData.DATA_SET_1
import static au.com.anz.test.stackingblocksapp.TestData.DATA_SET_2
import static java.util.Arrays.asList

@SpringBootTest
class DefaultBlockCalculatorHelperSpec extends Specification {
  @Autowired
  BlockCalculatorHelper defaultBlockCalculatorHelper

  @Unroll
  def "Given blocks,when getBlocksSortedDescendingByDimension called,then verify if order is correct"() {
    given:
    List<Block> blocks = input
    when:
    List<Block> outputBlocks = defaultBlockCalculatorHelper.getBlocksSortedDescendingByDimension(blocks)
    then:
    outputBlocks == expected
    where:
    input      | expected
    DATA_SET_1 | asList(Block.of(37, 53, 95), Block.of(20, 45, 50), Block.of(12, 23, 45))
    DATA_SET_2 | asList(Block.of(3, 35, 76), Block.of(25, 38, 45))
  }
}
