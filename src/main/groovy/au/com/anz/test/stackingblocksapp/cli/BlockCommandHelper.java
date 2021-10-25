package au.com.anz.test.stackingblocksapp.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.com.anz.test.stackingblocksapp.domain.Block;

public class BlockCommandHelper {
  public static final String BLOCK_DIMENSION_REGEX = "\\d{1,3},\\d{1,3},\\d{1,3}";
  public static final Function<String, List<Block>> createBlocksFromCliInput = (inputData) -> {
    Matcher matcher = Pattern.compile(BLOCK_DIMENSION_REGEX).matcher(inputData);
    List<Block> blocks = new ArrayList<>();
    while (matcher.find()) {
      blocks.add(createNewBlock(matcher.group(0).split(",")));
    }
    return blocks;
  };

  private static Block createNewBlock(String[] dimensions) {
    return Block.of(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]), Integer.parseInt(dimensions[2]));
  }
}
