package com.vertx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vertx.service.VertxService;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

@Component
public class StaticServer extends AbstractVerticle {

  @Autowired
  AppConfiguration configuration;
  
  @Autowired
  VertxService vertxService;
  
  Integer port = 8023;

//  @Override
//  public void start(Future <Void> future) throws Exception {
//    vertx
//    	.createHttpServer()
//    	.requestHandler(request -> {
//    		request.response().end("<h1> I am Vertx and running at port " + port + "</h1>");
//    	})
//    	.listen(port, result -> {
//    		if (result.succeeded()) {
//    			useRouter();
//    			future.complete();
//    		}
//    		else{
//    			future.fail(result.cause());
//    		}
//    	});
//  }
  
  @Override
  public void start(Future <Void> future) throws Exception {
	  if (vertx==null)
	  {
		  System.out.println("*****VERTEX NULL -> Class: Static Server");
	  }
	  else
	  {
		  System.out.println("VERTEX NOT NULL -> Class: Static Server");
	  }
	  
	  
	// Create a router object.
	  Router router = Router.router(vertx);
	  router.route().handler(BodyHandler.create());
	  // Bind "/" to our hello message - so we are still compatible.
//	  router.route("/").handler(routingContext -> {
//	    HttpServerResponse response = routingContext.response();
//	    response
//	        .putHeader("content-type", "text/html")
//	        .end("<h1>Hello from my first Vert.x 3 application</h1>");
//	  });
	  
	  router.post("/saveOne").handler(this::saveOne);
	  router.get("/getOne").handler(this::getOne);
	  router.get("/api/whiskies").handler(this::getAll);
	  // Create the HTTP server and pass the "accept" method to the request handler.
	  vertx
	      .createHttpServer()
	      .requestHandler(router::accept)
	      .listen(
	          // Retrieve the port from the configuration,
	          // default to 8080.
	          config().getInteger("http.port", port),
	          result -> {
	            if (result.succeeded()) {
	            	future.complete();
	            	System.out.println("**** vertx is up and running ****");
	            } else {
	            	future.fail(result.cause());
	            }
	          }
	      );
  }
  
  public void saveOne(RoutingContext routingContext) {
	  vertxService.saveOne(routingContext);
  }
  
  public void getOne(RoutingContext routingContext) {
	  vertxService.getOne(routingContext);
  }
  
  public void getAll(RoutingContext routingContext) {
	  routingContext.response()
	  .putHeader("content-type", "application/json; charset=utf-8")
	  .end(Json.encodePrettily("blach "));
  }
  
}