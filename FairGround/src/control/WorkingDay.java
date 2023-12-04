package control;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.text.html.FormSubmitEvent;

import model.customer.BiasCustomer;
import model.park.Fraction;
import model.park.Park;
import modelAtractions.FairGround;

public class WorkingDay {

	private Park park;
	private ArrayList<BiasCustomer> customers = new ArrayList<>();
	private int happyCustomers;
	private int totalCustomers;
	private int minimumCurrentCustomers = 100;
	private int maximumRidesByCustomer = 10;
	private Long totalRides = 0l;
	private Long maximumRides = 100000l;
	private ExecutorService threadPool;

	public WorkingDay(Park park) {
		super();
		this.park = park;
		threadPool = Executors.newCachedThreadPool();
	}

	public List<FairGround> getFairGrounds() {
		return park.getFairGrounds();
	}

	public void working() throws Exception {
		openingDoors();
		beginRides(customers);
		do {
			ArrayList<BiasCustomer> newCostumers = addCustomers(calculateCustomers());
			customers.addAll(newCostumers);
			beginRides(newCostumers);
		} while (totalRides < maximumRides);
	}

	private ArrayList<BiasCustomer> addCustomers(int calculateCustomers) {
		// TODO Auto-generated method stub
		return null;
	}

	private int calculateCustomers() {
		return minimumCurrentCustomers - customers.size();
	}

	private void beginRides(ArrayList<BiasCustomer> localCustomers) throws Exception {
		try {
			localCustomers.forEach((local) -> {
				Future<Fraction> submit = threadPool.submit(local);
				totalRides += local.getActualRides();
				try {
					if (submit.get().getCurrentValue() > 5)
						happyCustomers++;
				} catch (InterruptedException e) {
				} catch (ExecutionException e) {
				}
				totalCustomers++;
				customers.remove(local);
			});
		} catch (Exception e) {
			throw new Exception();
		}
	}

	public void openingDoors() {
		for (int i = 0; i < minimumCurrentCustomers; i++) {
			customers.add(new BiasCustomer(maximumRidesByCustomer, park.getFairGrounds()));
		}
	}

}
