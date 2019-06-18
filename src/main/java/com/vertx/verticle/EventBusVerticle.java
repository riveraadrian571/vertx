package com.vertx.verticle;

import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

@Component
public class EventBusVerticle extends AbstractVerticle{

	public void start(Future<Void> startFuture) throws Exception {
		super.start(startFuture);
		//event listener for incoming messages
		vertx.eventBus().<JsonObject>consumer("VertxSampleEB.VERTEX__GET_HELLO_MSG").handler(this::consumeMsg);
	}
	
	public void consumeMsg(Message<JsonObject> message) {
		System.out.println("Event Bus Receiver, message received => "+message.body());
	}
	
}
