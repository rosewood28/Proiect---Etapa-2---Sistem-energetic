package methods;

import entities.Distributor;
import entities.Producer;

import java.util.List;

public class GetProductionCost {
    private static final long CONSTANT = 10;
    private long cost = 0;

    /**
     * Calculeaza costul de productie al distribuitorilor in functie de producatorii alesi de
     * fiecare
     * @param distributors list
     */
    public void getProductionCost(List<Distributor> distributors) {
        for (Distributor distributor : distributors) {
            for (Producer producer : distributor.getProducers()) {
                cost += producer.getEnergyPerDistributor() * producer.getPriceKW();
            }
            long productionCost = Math.round(Math.floor(cost / CONSTANT));
            distributor.setProductionCost(productionCost);
        }
    }
}
