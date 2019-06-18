package com.vertx;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vertx.verticle.EventBusSender;
import com.vertx.verticle.EventBusVerticle;
import com.vertx.verticle.RestVerticle;

import io.vertx.core.Vertx;

@SpringBootApplication
public class VertxApplication  {
	//service discovery: https://piotrminkowski.wordpress.com/2017/08/24/asynchronous-microservices-with-vert-x/
	
	//both objects are autowired due to the @Component annotations in both classes
	
	@Autowired
	RestVerticle restVerticle;

	@Autowired
	EventBusVerticle eventBusVerticle;
	
	@Autowired
	EventBusSender eventBusSender;

	// deploys verticle before launching spring boot due to the function of the PostConstruct
	@PostConstruct
	public void deployVerticle() {
		Vertx vertx = Vertx.vertx();
		
//		vertx.deployVerticle(restVerticle, res -> {
//			if (res.succeeded()) {
//				System.out.println("*** Deployment REST is successful and Deployment id is: " + res.result() + " ***");
//				
//			} 
//			else {
//				System.out.println("Deployment REST Verticle failed!");
//				
//			}
//		});
		vertx.deployVerticle(eventBusVerticle, res -> {
			if (res.succeeded()) {
				System.out.println("*** Deployment eventBus is successful and Deployment id is: " + res.result() + " ***");
				
			} else {
				System.out.println("Deployment Event Bus failed!");
				
			}
		});
		
		vertx.deployVerticle(eventBusSender, res -> {
			if (res.succeeded()) {
				System.out.println("*** Deployment eventBusSender is successful and Deployment id is: " + res.result() + " ***");
				
			} else {
				System.out.println("Deployment Event Bus failed for sender	!");
				
			}
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(VertxApplication.class, args);
	}
}
