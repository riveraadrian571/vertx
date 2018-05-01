package com.vertx.dto;

import org.junit.Test;

public class ShapeDTOTest {
	
	@Test
	public void test() {
		ShapeDTO shapeTest = new ShapeDTO();
		shapeTest.setShapeId(1);
		shapeTest.setNumberSides(2);
		shapeTest.setShapeColor("red");
		shapeTest.setShapeName("fake shape");
		shapeTest.toString();
	}

}
