package model.customer;

import java.util.List;
import java.util.Random;

import control.WorkingDay;
import model.park.Fraction;
import model.park.Statistics;
import modelAtractions.FairGround;

public class BiasCustomer  {
	// las ganas que tiene de montarse en otra atraccion depende de lo bien
	// que se lo este pasando, aunque todo tiene un limite de X veces
	private int maxRides;
	private int actualRides = 0;
	private float maxRate = 10;
	private float minimumEnjoyment = 5f;
	private Fraction currentEnjoyment = new Fraction();
	private long breakTime=1000;

	public BiasCustomer(int maxRides, List<FairGround> fairGrounds) {
		super();
		this.maxRides = maxRides;
		// Al principio tiene muchas ganas
		currentEnjoyment.incrementOneValoration(10);
	}

	public CustomerCard takeRide() {
		return null;
	}

	public float getCurrentValue() {
		return currentEnjoyment.getCurrentValue();
	}

	public boolean isStillExcited() {
		return this.currentEnjoyment.getCurrentValue() >= minimumEnjoyment;
	}

}
