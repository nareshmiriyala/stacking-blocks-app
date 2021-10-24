package au.com.anz.test.stackingblocksapp.cli;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

public class DefaultInputHandler implements InputHandler {
  public static final String STACKED_BLOCK_MAX_HEIGHT_CMD_INPUT = "^\\[(\\[\\d{1,3},\\d{1,3},\\d{1,3}\\],?)+\\]$";
  @Autowired
  CommandService blockCommandService;

  @Override
  public void dispatch(String inputData) {
    String data = removeWhiteSpaces.apply(inputData);
    if (isStackingBlocksMaxHeightCommandInput.test(data)) {
      blockCommandService.execute(data);
    }
  }

  static Predicate<String> isStackingBlocksMaxHeightCommandInput = (inputData) -> {
    Pattern pattern = Pattern.compile(STACKED_BLOCK_MAX_HEIGHT_CMD_INPUT);
    return pattern.matcher(inputData).find();
  };
  static Function<String, String> removeWhiteSpaces = (inputData) -> inputData.replaceAll(" ", "");
}
