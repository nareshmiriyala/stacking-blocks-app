package au.com.anz.test.stackingblocksapp.biz

import au.com.anz.test.stackingblocksapp.domain.Block
import au.com.anz.test.stackingblocksapp.domain.Shape
import au.com.anz.test.stackingblocksapp.domain.Square
import au.com.anz.test.stackingblocksapp.exception.InvalidBlockException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class BlockCalculatorSpec extends Specification {
  @Autowired
  ShapeCalculator threeDimensionShapeCalculator

  def "Given list of block,when max height of stacked blocks is called,then correct value is returned"() {
    given:
    List<Shape> blocks = Arrays.asList(Block.of(50, 45, 20),
      Block.of(95, 37, 5),
      Block.of(45, 23, 120))
    when:
    Integer maxHeight = threeDimensionShapeCalculator.getMaxStackedHeight(blocks)
    then:
    maxHeight == 190
  }

  def "Given invalid list of block,when max height of stacked blocks is called,then InvalidBlockException exception should be returned"() {
    given:
    List<Shape> blocks = Arrays.asList(Block.of(50, 45, 20),
      Block.of(95, 37, 5),
      Square.of(95, 37),
      Block.of(45, 23, 120))
    when:
    threeDimensionShapeCalculator.getMaxStackedHeight(blocks)
    then:
    thrown(InvalidBlockException)
  }
}
