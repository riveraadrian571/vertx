package com.vertx.dto;

import org.junit.Test;

public class ShapeDTOTest {
	
	@Test
	public void testShapeDTO() {
		ShapeDTO dto = new ShapeDTO();
		dto.setShapeId(1);
		dto.setNumberSides(3);
		dto.setShapeColor("red");
		dto.setShapeName("triangle");
		dto.toString();
	}
}
