package au.com.anz.test.stackingblocksapp.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.com.anz.test.stackingblocksapp.domain.Block;

public class BlockCommandUtil {
  public static final String BLOCK_DIMENSION_REGEX = "\\d{1,3},\\d{1,3},\\d{1,3}";
  static Function<String, List<Block>> createBlocks = (inputData) -> {
    Matcher matcher = Pattern.compile(BLOCK_DIMENSION_REGEX).matcher(inputData);
    List<Block> blocks = new ArrayList<>();
    while (matcher.find()) {
      String[] dimensions = matcher.group(0).split(",");
      blocks.add(Block.of(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]), Integer.parseInt(dimensions[2])));
    }
    return blocks;
  };
}
