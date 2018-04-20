package com.vertx.dto;

import io.vertx.core.json.Json;

public class ShapeDTO {
	
	public Integer shapeId;
	
	public String shapeName;
	
	public Integer numberSides;
	
	public String shapeColor;

	public Integer getShapeId() {
		return shapeId;
	}

	public void setShapeId(Integer shapeId) {
		this.shapeId = shapeId;
	}

	public String getShapeName() {
		return shapeName;
	}

	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}

	public Integer getNumberSides() {
		return numberSides;
	}

	public void setNumberSides(Integer numberSides) {
		this.numberSides = numberSides;
	}

	public String getShapeColor() {
		return shapeColor;
	}

	public void setShapeColor(String shapeColor) {
		this.shapeColor = shapeColor;
	}

	@Override
	public String toString() {
		return Json.encodePrettily(this);
	}

}
