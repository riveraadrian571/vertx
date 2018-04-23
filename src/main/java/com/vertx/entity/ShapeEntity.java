package com.vertx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.vertx.core.json.Json;

@Entity
@Table(name="sample")
public class ShapeEntity {

	@Id 
	@SequenceGenerator(name="pk_sequence",sequenceName="sample_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")	
	@Column(name="shape_id", nullable=false)
	private Integer shapeId;

	@Column(name="shape_name")
	private String shapeName;
	
	@Column(name="number_sides")
	private Integer numberSides;
	
	@Column(name="shape_color")
	private String shapeColor;

	public ShapeEntity(){}
	
	public ShapeEntity(Integer shapeId, String shapeName, Integer numberSides, String shapeColor) {
		this.shapeId = shapeId;
		this.shapeName = shapeName;
		this.numberSides = numberSides;
		this.shapeColor = shapeColor;
	}
	
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
