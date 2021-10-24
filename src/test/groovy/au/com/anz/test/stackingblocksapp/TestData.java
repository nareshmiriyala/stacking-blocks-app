package au.com.anz.test.stackingblocksapp;

import java.util.List;

import au.com.anz.test.stackingblocksapp.domain.Block;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public class TestData {
  public static final List<Block> DATA_SET_1 = unmodifiableList(asList(Block.of(50, 45, 20), Block.of(95, 37, 53),
    Block.of(45, 23, 12)));
  public static final List<Block> DATA_SET_2 = unmodifiableList(asList(Block.of(38, 25, 45), Block.of(76, 35, 3)));
  public static final List<Block> DATA_SET_3 = unmodifiableList(asList(Block.of(7, 11, 17),
    Block.of(7, 17, 11),
    Block.of(11, 7, 17),
    Block.of(11, 17, 7),
    Block.of(17, 7, 11),
    Block.of(17, 11, 7)));
}
