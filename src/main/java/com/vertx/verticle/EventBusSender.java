package com.vertx.verticle;

import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

@Component
public class EventBusSender extends AbstractVerticle{
	public void start(Future<Void> startFuture) throws Exception {
		super.start(startFuture);
		//to send a message via the event bus
		vertx.eventBus().send("VertxSampleEB.VERTEX__GET_HELLO_MSG", "Event Bus sender: Hello World !");
	}
}
