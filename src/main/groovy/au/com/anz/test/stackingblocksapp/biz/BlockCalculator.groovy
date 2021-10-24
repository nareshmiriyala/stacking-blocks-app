package au.com.anz.test.stackingblocksapp.biz

import au.com.anz.test.stackingblocksapp.domain.Block

interface BlockCalculator {
  OptionalInt getMaxStackedHeight(List<Block> blocks)
}