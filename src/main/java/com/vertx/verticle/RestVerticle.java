package com.vertx.verticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vertx.AppConfiguration;
import com.vertx.service.VertxService;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

@Component
public class RestVerticle extends AbstractVerticle {

  @Autowired
  AppConfiguration configuration;
  
  @Autowired
  VertxService vertxService;
  
  Integer port = 8011;
  
  private HttpServer httpServer;
  
  @Override
  public void start(Future <Void> future) throws Exception {
	   
	  httpServer = vertx.createHttpServer();
	  
	  
	  // Create a router object.
	  Router router = Router.router(vertx);
	  
	  httpServer.requestHandler(router::accept);
	  
	  httpServer.listen(
	          config().getInteger("http.port", port),
	          result -> {
	            if (result.succeeded()) {
	            	future.complete();
	            } else {
	            	future.fail(result.cause());
	            	System.out.println(result.cause());
	            }
	          });
	  // Create a body handler to process routing context
	  router.route().handler(BodyHandler.create());
	  //quick example for utilizing the setMergeFormAttributes in order to capture the values coming in from the routing context
	  //if i do so want to use it in the future
	  //router.post("/saveOne").handler(BodyHandler.create().setMergeFormAttributes(true));
	  router.post("/saveOne").handler(this::saveOne);
	  
	  // Create the Vertx HTTP server and pass the "accept" method to the request handler.
	  //HttpServer vertx = createHttpServer();
			  
	  //vertx
	    //.createHttpServer()
	      //.requestHandler(router::accept)
	      //.listen(
//	          config().getInteger("http.port", port),
//	          result -> {
//	            if (result.succeeded()) {
//	            	future.complete();
//	            } else {
//	            	future.fail(result.cause());
//	            }
//	          }
	      //);
  }
  
  public void saveOne(RoutingContext routingContext) {
	  vertxService.saveOne(routingContext);
  }
}