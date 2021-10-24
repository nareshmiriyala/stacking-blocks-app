package au.com.anz.test.stackingblocksapp.cli;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultInputHandler implements InputHandler {
  @Autowired
  CommandService blockCommandService;

  @Override
  public void dispatch(String inputData) {
    String data = removeWhiteSpaces.apply(inputData);
    if (isStackingBlocksMaxHeightCommandInput.test(data, InputDataPattern.STACKED_BLOCK_MAX_HEIGHT_CMD_INPUT)) {
      blockCommandService.execute(data);
    }
  }

  static BiPredicate<String, InputDataPattern> isStackingBlocksMaxHeightCommandInput = (inputData, inputPattern) -> {
    Pattern pattern = Pattern.compile(inputPattern.getRegex());
    return pattern.matcher(inputData).find();
  };
  static Function<String, String> removeWhiteSpaces = (inputData) -> inputData.replaceAll(" ", "");
}
