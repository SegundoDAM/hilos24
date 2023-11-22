package modelAtractions;

import java.util.Random;
import java.util.function.Supplier;

public enum FactoryManager {
	Show(()->{return new ShowProductor();}),
	Performance(()->{return new PerformanceProductor();}),
	RollerCoaster(()->{return new RollerCoasterProduct();});
	
	private Supplier<AbstractProductor> getFairground;
	
	private FactoryManager(Supplier<AbstractProductor> getFairground) {
		this.getFairground = getFairground;
	}

	public static AbstractProductor getRandomFairGround(){
		return FactoryManager.values()
				[new Random()
				 .nextInt(FactoryManager.values()
						 .length)].getFairground.get();
	}
}
