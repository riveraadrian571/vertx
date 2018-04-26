package com.vertx.verticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

@Component
public class EventBusVerticle extends AbstractVerticle{

//	@Autowired
//	Vertx vertx;
	
	public void start(Future<Void> startFuture) throws Exception {
		super.start(startFuture);
		EventBus eventBus = vertx.eventBus();
		eventBus.<JsonObject>consumer("VertxSampleEB.VERTEX__GET_HELLO_MSG").handler(this::getHelloMsg);
	}
	
	public void getHelloMsg(Message<JsonObject> message) {
		message.reply("hello from sample vertx event bus");
	}
	
}
