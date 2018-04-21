package com.vertx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vertx.dto.ShapeDTO;
import com.vertx.entity.ShapeEntity;
import com.vertx.repository.ShapeRepository;

import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

@Component
public class VertxService {
//	@Autowired
//	ShapeRepository shapeRepository;
	
	//create
	public void saveOne(RoutingContext routingContext){
		System.out.println("SAVEONE METHOD: SERVICE CLASS");	
//		routingContext.response()
//	      .putHeader("content-type", "application/json; charset=utf-8")
//	      .end(Json.encodePrettily(products.values()));
		//decode into dto
		//System.out.println("before decode: " + Json.decodeValue(routingContext.getBodyAsString(),));
		ShapeEntity shapeEntity = Json.decodeValue(routingContext.getBodyAsString(), ShapeEntity.class);
		System.out.println("*******here is the shapeDTO \n" + shapeEntity.toString());
		//shapeRepository.save(shapeEntity);
		//throw into database
		//dbexecutor
	}
	
	//read
	public void getOne(RoutingContext routingContext) {
		System.out.println("GETONE METHOD: SERVICE CLASS");
		//decode into dto
		
		//give to front end in json format
	}
	
	//update one
	public void updateOne(RoutingContext routingContext) {
		System.out.println("UPDATEONE METHOD: SERVICE CLASS");
	}
	
	//delete
	public void deleteOne(RoutingContext routingContext) {
		System.out.println("DELETEONE METHOD: SERVICE CLASS");
	}

}
