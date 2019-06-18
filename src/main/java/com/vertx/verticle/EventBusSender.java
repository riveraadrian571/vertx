package com.vertx.verticle;

import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.zookeeper.ZookeeperClusterManager;

@Component
public class EventBusSender extends AbstractVerticle {
	
	public void start(Future<Void> startFuture) throws Exception {
		super.start(startFuture);
		ClusterManager mgr = new ZookeeperClusterManager();
		VertxOptions options = new VertxOptions().setClusterManager(mgr);
		
		Vertx.clusteredVertx(options, res -> {
			if (res.succeeded()) {
				//Vertx vertx = res.result();
				System.out.println("zookeeper success");
				//launchEventBusVerticle(res.result());
				
				res.result().eventBus().send("VertxSampleEB.anotherMessage", "Event Bus sender1234: Hello World from a different MS !");
			} else {
				// failed!
				System.out.println("zookeeper failure\n"+res.failed());
			}
		});
	}
	
}
