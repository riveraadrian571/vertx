package com.vertx.service;

import org.springframework.stereotype.Component;

import com.vertx.dto.ShapeDTO;

import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

@Component
public class VertxService {
	//create
	public void saveOne(RoutingContext routingContext){
		System.out.println("SAVEONE METHOD: SERVICE CLASS");	
		//decode into dto
		ShapeDTO shapeDTO = Json.decodeValue(routingContext.getBodyAsString(), ShapeDTO.class);
		System.out.println("here is the shape \n" + shapeDTO.toString());
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
