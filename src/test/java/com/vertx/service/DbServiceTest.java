package com.vertx.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.modules.junit4.PowerMockRunner;

import com.vertx.entity.ShapeEntity;
import com.vertx.repository.ShapeRepository;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.web.RoutingContext;

@RunWith(PowerMockRunner.class)
public class DbServiceTest  {
	@Rule
	public RunTestOnContext rule = new RunTestOnContext();
	
	@Mock
	ShapeRepository shapeRepository;

	@Mock
	Vertx vertx;
	
	@Mock
	Handler<RoutingContext> httpErrorHandler;
	
	@Mock
	RoutingContext rc;
	
	@InjectMocks
	DbService dbService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	
	private ShapeEntity getShape() {
		ShapeEntity shapeEntity = new ShapeEntity();
		shapeEntity.setShapeId(3);
		shapeEntity.setNumberSides(4);
		shapeEntity.setShapeColor("green");
		shapeEntity.setShapeName("rectangle");
		return shapeEntity;
	}
	
	@Test
	public void testSave() {
		//gets a new instance of shapeEntity
		ShapeEntity shapeEntity = getShape();
		
		AsyncResult<Object> ar = mock(AsyncResult.class);
		Throwable cause = new Throwable("Failure!");
		
		doReturn(cause).when(ar).cause();
		doReturn(false).when(ar).succeeded();
		
		mockExecuteBlocking(ar);
		
		//Handler<shape>
		
	}
	
	private void mockExecuteBlocking(AsyncResult<Object> ar) {
		doAnswer(new Answer() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				((Handler<Future>) invocation.getArguments()[0]).handle(Future.future());
				((Handler<AsyncResult>) invocation.getArguments()[1]).handle(ar);
				return null;
			}}).when(vertx).executeBlocking(any(Handler.class), any(Handler.class));
	}
	
}
