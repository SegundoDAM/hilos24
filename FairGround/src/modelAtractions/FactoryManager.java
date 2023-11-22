package modelAtractions;

import java.util.Random;
import java.util.function.Supplier;

public enum FactoryManager {
	Show(()->{return new ShowProductor().createFairGround();}),
	Performance(()->{return new PerformanceProductor().createFairGround();}),
	RollerCoaster(()->{return new RollerCoasterProduct().createFairGround();});
	
	private Supplier<FairGround> getFairground;
	
	private FactoryManager(Supplier<FairGround> getFairground) {
		this.getFairground = getFairground;
	}

	public FairGround getRandomFairGround(){
		return FactoryManager.values()
				[new Random()
				 .nextInt(FactoryManager.values()
						 .length)].getFairground.get();
	}
}
