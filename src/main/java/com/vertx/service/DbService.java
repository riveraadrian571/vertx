package com.vertx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vertx.entity.ShapeEntity;
import com.vertx.repository.ShapeRepository;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;


@Component
public class DbService {
	@Autowired
	ShapeRepository shapeRepository;
	
	Vertx vertx = Vertx.vertx();
	
//	public <T> void executeBlocking(Handler<Future<T>> blockingCodeHandler,
//            boolean ordered,
//            Handler<AsyncResult<T>> resultHandler)
//	{
	/*
	 * Now I need to figure out how to handle this.	
	 */
	public <T> void save (ShapeEntity shapeEntity, HttpServerResponse res) 
	{
		vertx.executeBlocking( future -> {
			shapeRepository.save(shapeEntity);
		  // Call some blocking API that takes a significant amount of time to return
		  future.complete(shapeRepository.save(shapeEntity));
		},
		resultHandler -> {
			if (resultHandler.succeeded()) {
				res.setStatusCode(200).setStatusMessage("db insert successful").putHeader("content-type", "application/json").end();
				System.out.println("success");
				System.out.println("The result is: " + resultHandler);
			}
			else if (resultHandler.failed()) 	{
				System.out.println("FAILED " + resultHandler.cause());
			}
		});
	}
}
