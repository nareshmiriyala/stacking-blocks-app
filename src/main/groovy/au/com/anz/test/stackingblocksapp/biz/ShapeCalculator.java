package au.com.anz.test.stackingblocksapp.biz;

import java.util.List;

import au.com.anz.test.stackingblocksapp.domain.Shape;

public interface ShapeCalculator {
  Integer getMaxStackedHeight(List<Shape> shapes);
}
