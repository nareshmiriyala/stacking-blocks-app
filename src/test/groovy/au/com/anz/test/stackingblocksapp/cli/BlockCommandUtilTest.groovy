package au.com.anz.test.stackingblocksapp.cli

import au.com.anz.test.stackingblocksapp.TestData
import au.com.anz.test.stackingblocksapp.domain.Block
import spock.lang.Specification
import spock.lang.Unroll

class BlockCommandUtilTest extends Specification {
//  @Unroll
//  def "test isStackingBlocksMaxHeightCommandInput"() {
//    when:
//    boolean output = BlockCommandUtil.isStackingBlocksMaxHeightCommandInput.test(input)
//    then:
//    output == expected
//    where:
//    input                                                            | expected
//    "[[7,11,111],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]" | true
//    "[[7,11,111],[7,17,11]]"                                         | true
//    "[[7,11,111],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7"   | false
//    "[[7,11,111],[7"                                                 | false
//  }

  def "test create blocks from input data"() {
    when:
    List<Block> blocks = BlockCommandUtil.createBlocks.apply(input)
    then:
    blocks == expected
    where:
    input                                                           | expected
    "[[50,45,200]]"                            | TestData.DATA_SET_1
//    "[[38,25,45],[76,35,3]]"                                        | TestData.DATA_SET_2
//    "[[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]" | TestData.DATA_SET_3
  }
}
