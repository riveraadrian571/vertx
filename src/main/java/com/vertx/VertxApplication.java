package com.vertx;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.vertx.core.Vertx;

@SpringBootApplication
public class VertxApplication {

	@Autowired
	StaticServer staticServer;

	// @Autowired
	// Vertx vertx;

	// deploys verticle before launching spring boot
	@PostConstruct
	public void deployVerticle() {
		// Vertx.vertx().deployVerticle(staticServer);
		Vertx.vertx().deployVerticle(staticServer, res -> {
			if (res.succeeded()) {
				System.out.println("Deployment id is: " + res.result());
			} else {
				System.out.println("Deployment failed!");
			}
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(VertxApplication.class, args);
	}
}
