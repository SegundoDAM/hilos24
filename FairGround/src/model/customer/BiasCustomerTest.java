package model.customer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import control.WorkingDay;
import model.park.Fraction;
import modelAtractions.FairGround;
import modelAtractions.Performance;
import modelAtractions.RollerCoaster;
import modelAtractions.Show;
import utils.Comment;
import utils.ObjectMother;

class BiasCustomerTest {
	private ArrayList<FairGround> fairgrounds;
//	private WorkingDay workingDay;
	
	@BeforeEach
	void before() throws Exception {
		fairgrounds=new ArrayList<>();
		fairgrounds.add(new Performance());
		fairgrounds.add(new Show());
		fairgrounds.add(new RollerCoaster());
//		workingDay=new WorkingDay();
	}

	@Test
	void testTakeRide() {
		BiasCustomer customer=new BiasCustomer(20,this.fairgrounds);
		CustomerCard customerCard = customer.takeRide();
		assertNotNull(customerCard);
		Comment.talk(customerCard.getRate());
		assertNotNull(customerCard.getFairGround());
		if(customerCard.getRate()<ObjectMother.minimunEnjoyment) {
			Comment.talk(customer.getCurrentValue());
		}
	}

	@Test
	void customerCallableOneCallTest() throws InterruptedException, ExecutionException {
		BiasCustomer customer=new BiasCustomer(1,this.fairgrounds);
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		Future<Fraction> submit = newSingleThreadExecutor.submit(customer);
		newSingleThreadExecutor.shutdown();
		Fraction fraction = submit.get();
		assertNotNull(fraction);
		Comment.talk(fraction.getCurrentValue());
	}
	@Test
	void customerCallableManyCallTest() throws InterruptedException, ExecutionException {
		int maxRides = 8;
		BiasCustomer customer=new BiasCustomer(maxRides,this.fairgrounds,4f);
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		Future<Fraction> submit = newSingleThreadExecutor.submit(customer);
		newSingleThreadExecutor.shutdown();
		Fraction fraction = submit.get();
		assertNotNull(fraction);
		float currentValue = fraction.getCurrentValue();
		if(currentValue<5) {
			Comment.talk("current value "+currentValue);
			int actualRides = customer.getActualRides();
			Comment.talk("current rides "+actualRides);
			assertTrue(actualRides<maxRides);
		}else {
			fail("deberia dar fallo");
		}
	}

}
