package au.com.anz.test.stackingblocksapp.cli;

public enum InputDataPattern {
  STACKED_BLOCK_MAX_HEIGHT_CMD_INPUT("^\\[(\\[\\d{1,3},\\d{1,3},\\d{1,3}\\],?)+\\]$");
  private final String regex;

  InputDataPattern(String regex) {
    this.regex = regex;
  }

  public String getRegex() {
    return regex;
  }

}
