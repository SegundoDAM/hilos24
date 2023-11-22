package control;

import java.util.ArrayList;
import java.util.List;

import model.customer.BiasCustomer;
import model.park.Park;
import modelAtractions.FairGround;

public class WorkingDay {

	private Park park;
	private ArrayList<BiasCustomer> customers=new ArrayList<>();
	private int happyCustomers;
	private int totalCustomers;
	
	public List<FairGround> getFairGrounds() {
		return park.getFairGrounds();
	}
	
	
}
