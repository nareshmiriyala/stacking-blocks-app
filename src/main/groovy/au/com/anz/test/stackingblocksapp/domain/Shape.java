package au.com.anz.test.stackingblocksapp.domain;

import java.util.List;

/**
 * Represents any dimension shapes.
 * 1D - line
 * 2D - Triangle,Square etc
 * 3D - Cone,Cube,Sphere etc
 */
public interface Shape {
  List<Integer> getDimensions();
}
