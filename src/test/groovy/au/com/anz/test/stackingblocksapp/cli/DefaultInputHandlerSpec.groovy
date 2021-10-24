package au.com.anz.test.stackingblocksapp.cli


import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import spock.lang.Specification

import static au.com.anz.test.stackingblocksapp.TestData.INPUT_DATA_3
import static au.com.anz.test.stackingblocksapp.TestData.INVALID_INPUT_DATA

@SpringBootTest
class DefaultInputHandlerSpec extends Specification {
  @Autowired
  InputHandler inputHandler

  @MockBean
  CommandService mockCommandBean

  def "verify block command service is called when valid input"() {
    when:
    inputHandler.dispatch(INPUT_DATA_3)
    then:
    Mockito.verify(mockCommandBean, Mockito.times(1)).execute(INPUT_DATA_3)
  }

  def "verify block command service is not called when invalid input"() {
    when:
    inputHandler.dispatch(INVALID_INPUT_DATA)
    then:
    Mockito.verify(mockCommandBean, Mockito.times(0)).execute(INVALID_INPUT_DATA)
  }
}
