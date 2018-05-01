//package com.vertx.verticle;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.vertx.service.VertxService;
//
//import io.vertx.core.Future;
//import io.vertx.core.Vertx;
//import io.vertx.ext.web.Route;
//import io.vertx.ext.web.Router;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//public class RestVerticleTest {
//	
//	@Mock
//	Vertx vertx;
//	
//	@Mock
//	VertxService vertxService;
//	
//	@InjectMocks
//	RestVerticle restVerticle;
//	
//	@Before
//	public void setup() {
//		MockitoAnnotations.initMocks(RestVerticleTest.class);
//	}
//	
//	@Test
//	public void testSetRoutes() throws Exception {
//		//Router router = mock(Router.class);
//		Vertx router = mock(vertx.getClass());
//		Route route = mock(Route.class);
//		//sdoReturn(route).when(router).whencreateHttpServer().requestHandler();
//		//doReturn(route).when(router).post();
//		//doReturn(route).when(router).post(anyString());
//		
//	
//		
//		
//		//verify(router, times(2)).post("/saveOne");
//	}
//
//}
