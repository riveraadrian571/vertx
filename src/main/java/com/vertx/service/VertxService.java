package com.vertx.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vertx.dto.ShapeDTO;
import com.vertx.entity.ShapeEntity;
import com.vertx.repository.ShapeRepository;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

@Component
public class VertxService {
	@Autowired
	ShapeRepository shapeRepository;
	
	@Autowired
	Vertx vertx;
	
	
	
	//save a shapeS
	public void saveOne(RoutingContext routingContext){
		
		System.out.println("SAVEONE METHOD: SERVICE CLASS");	
		ShapeDTO shapeDTO = Json.decodeValue(routingContext.getBodyAsString(), ShapeDTO.class);
		System.out.println("*******here is the shapeDTO **** \n" + shapeDTO.toString());
		//create a Shape Entity for saving into db
		ShapeEntity shapeEntity = new ShapeEntity();
		//copy the dto to the entity 
		BeanUtils.copyProperties(shapeDTO, shapeEntity);
		System.out.println("*******here is the shapeEntity before saving to the db **** \n" + shapeEntity.toString());
		//eventually will throw the entity into dbexecutor class
		//throw into database
		
		//doSave(shapeEntity);
		
//		vertx.executeBlocking(future -> {
			shapeRepository.save(shapeEntity);
//		}, res -> {
//			if (res.succeeded()) {
//				
//			}
//		}arg1);
		//shapeRepository.save(shapeEntity);
	}
	
	public void doSave(ShapeEntity shapeEntity, Handler<ShapeEntity> handler)
	{
		
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
