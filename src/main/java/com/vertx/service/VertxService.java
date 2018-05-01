package com.vertx.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vertx.dto.ShapeDTO;
import com.vertx.entity.ShapeEntity;
import com.vertx.util.*;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

@Component
public class VertxService {
	//https://github.com/lbovet/vertx-rest-storage/blob/master/src/main/java/org/swisspush/reststorage/util/StatusCode.java
//	  OK(200, "OK"),
//    FOUND(302, "Found"),
//    NOT_MODIFIED(304, "Not Modified"),
//    BAD_REQUEST(400, "Bad Request"),
//    NOT_FOUND(404, "Not Found"),
//    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
//    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
//	  CONFLICT(409, "Conflict");
	
	@Autowired
	DbService dbService;

	public void saveOne(RoutingContext routingContext) {	
		HttpServerResponse res = routingContext.response();
		ShapeDTO shapeDTO = Json.decodeValue(routingContext.getBodyAsString(), ShapeDTO.class);
		if (shapeDTO!=null) {
			//res.setStatusCode(200).putHeader("content-type", "application/json").end();
			//create a Shape Entity for saving into db
			ShapeEntity shapeEntity = new ShapeEntity();
			//copy the dto to the entity 
			BeanUtils.copyProperties(shapeDTO, shapeEntity);
			//throw into database
			dbService.save(shapeEntity, res);
		}
		else if (shapeDTO==null)
		{
			res.headers().add("content-type", "application/json");
			res.setStatusCode(StatusCode.NOT_FOUND.getStatusCode()).setStatusMessage("Shape DTO came back null").end();
			//res.setStatusCode(404).putHeader("content-type", "application/json").end();
		}
		
	}
}
