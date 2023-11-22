package modelAtractions;

import java.util.Random;
import java.util.function.Supplier;

public enum FactoryManager {
	Show(()->{return new ShowProductor();}),
	Performance(()->{return new PerformanceProductor();}),
	RollerCoaster(()->{return new RollerCoasterProduct();});
	
	private Supplier<AbstractProductor> productorSupplier;
	
	private FactoryManager(Supplier<AbstractProductor> productorSupplier) {
		this.productorSupplier = productorSupplier;
	}

	public static AbstractProductor getRandomFairGround(){
		return FactoryManager.values()
				[new Random()
				 .nextInt(FactoryManager.values()
						 .length)].productorSupplier.get();
	}
}
