package au.com.anz.test.stackingblocksapp.biz


import au.com.anz.test.stackingblocksapp.domain.Block
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import static au.com.anz.test.stackingblocksapp.TestData.DATA_SET_1

@SpringBootTest
class BlockCalculatorSpec extends Specification {
  @Autowired
  BlockCalculator defaultBlockCalculator

  def "Given list of block,when max height of stacked blocks is called,then correct value is returned"() {
    given:
    List<Block> blocks = DATA_SET_1
    when:
    OptionalInt maxHeight = defaultBlockCalculator.getMaxStackedHeight(blocks)
    then:
    maxHeight.asInt == 190
  }


}
