package au.com.anz.test.stackingblocksapp.domain

import spock.lang.Specification

class BlockSpec extends Specification {
  def 'verify block object created successfully'() {
    when:
    ThreeDimensionShape block = Block.of(10, 20, 30)
    then:
    block.length == 10
    block.width == 20
    block.height == 30
    block.dimensions == [10, 20, 30]
  }
}
