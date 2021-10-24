package au.com.anz.test.stackingblocksapp.domain

import spock.lang.Specification
import spock.lang.Unroll

class BlockSpec extends Specification {
  def 'verify block object created successfully'() {
    when:
    ThreeDimensionShape block = Block.of(10, 20, 30)
    then:
    block.length == 10
    block.width == 20
    block.height == 30
    block.dimensions == [20, 10, 30]
  }

  @Unroll
  def "test block #b1 can be placed on block #b2"() {
    given:
    Block block = b1
    when:
    boolean actual = block.canBePlacedOnTopOfBlock(b2)
    then:
    actual == output
    where:
    b1                   | b2                   | output
    Block.of(10, 20, 30) | Block.of(1, 1, 1)    | true
    Block.of(10, 20, 30) | Block.of(50, 1, 1)   | false
    Block.of(10, 20, 30) | Block.of(10, 20, 30) | true
  }
}
