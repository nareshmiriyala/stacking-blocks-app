package au.com.anz.test.stackingblocksapp.domain;

/**
 * Represents all 3D shapes like Cone,Cylinder,Block(Cuboid) etc
 */
public interface ThreeDimensionShape extends Shape {
  Integer getLength();

  Integer getWidth();

  Integer getHeight();
}
