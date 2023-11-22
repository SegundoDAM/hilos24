package model.park;

import java.util.LinkedList;
import java.util.List;

import modelAtractions.AbstractProductor;
import modelAtractions.FairGround;

public class Park {
	private List<FairGround> fairGrounds;
	private Statistics statistics;
	

	private int maxConcurrentVisitors=100;
	
	public int getMaxConcurrentVisitors() {
		return maxConcurrentVisitors;
	}

	public Park() {
		super();
		fairGrounds = new LinkedList<FairGround>();
		statistics=new Statistics(fairGrounds);
	}

	public void addFairGround(AbstractProductor type) throws Exception {
		fairGrounds.add(type.createFairGround());
	}
	
	public void changeRideRate(FairGround fairGround,float rate) {
		statistics.changeRate(fairGround,rate);
	}

	public List<FairGround> getFairGrounds() {
		return fairGrounds;
	}

	public float getCurrentAverageRate() {
		return statistics.getCurrentAverageRate();
	}
}
