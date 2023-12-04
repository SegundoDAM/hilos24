package model.customer;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.Callable;

import control.WorkingDay;
import model.park.Fraction;
import model.park.Statistics;
import modelAtractions.FairGround;

public class BiasCustomer implements Callable<Fraction> {
	// las ganas que tiene de montarse en otra atraccion depende de lo bien
	// que se lo este pasando, aunque todo tiene un limite de X veces
	private int maxRides;
	private int actualRides = 0;

	public int getActualRides() {
		return actualRides;
	}

	private float maxRate = 10;
	private float minimumEnjoyment = 5f;
	private Fraction currentEnjoyment = new Fraction();
	private long breakTime = 10;
	private List<FairGround> fairGrounds;
	private Optional<Float> noRandomRate=Optional.ofNullable(null);

	public BiasCustomer(int maxRides, List<FairGround> fairGrounds) {
		super();
		this.maxRides = maxRides;
		// Al principio tiene muchas ganas
		currentEnjoyment.incrementOneValoration(10);
		this.fairGrounds = fairGrounds;
	}

	public BiasCustomer(int maxRides, List<FairGround> fairGrounds, Float noRandomRate) {
		this(maxRides, fairGrounds);
		this.noRandomRate = Optional.of(noRandomRate);
	}

	@Override
	public Fraction call() throws Exception {
		while (actualRides++ < maxRides && isStillExcited()) {
			CustomerCard customerCard = takeRide();
			this.currentEnjoyment.incrementOneValoration(customerCard.getRate());
			try {
				Thread.sleep(breakTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return this.currentEnjoyment;
	}

	public CustomerCard takeRide() {
		FairGround fairGround = fairGrounds.get(new Random().nextInt(fairGrounds.size()));
		float rate=getRateAssign();
		CustomerCard customerCard = new CustomerCard(fairGround, rate);
		return customerCard;
	}

	private Float getRateAssign() {
		if(noRandomRate.isPresent()) {
			return noRandomRate.get();
		}
		return new Random().nextFloat() * maxRate;
	}

	public float getCurrentValue() {
		return currentEnjoyment.getCurrentValue();
	}

	public boolean isStillExcited() {
		return this.currentEnjoyment.getCurrentValue() >= minimumEnjoyment;
	}

}
