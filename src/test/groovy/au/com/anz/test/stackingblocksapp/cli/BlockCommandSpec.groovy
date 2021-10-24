package au.com.anz.test.stackingblocksapp.cli

import au.com.anz.test.stackingblocksapp.TestData
import au.com.anz.test.stackingblocksapp.domain.Block
import spock.lang.Specification

class BlockCommandSpec extends Specification {

  def "test create blocks from input data"() {
    when:
    List<Block> blocks = BlockCommand.createBlocksFromCliInput.apply(input)
    then:
    blocks == expected
    where:
    input                                                           | expected
    "[[50,45,20],[95,37,53],[45,23,12]]"                            | TestData.DATA_SET_1
    "[[38,25,45],[76,35,3]]"                                        | TestData.DATA_SET_2
    "[[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]" | TestData.DATA_SET_3
  }
}
