package methods;

import entities.Distributor;
import entities.Producer;

import java.util.List;

public class GetProductionCost {
    private static final long CONSTANT = 10;
    private float cost = 0;

    /**
     * Calculeaza costul de productie al distribuitorilor in functie de producatorii alesi.
     * @param distributors lista de distribuitori
     */
    public void getProductionCost(List<Distributor> distributors) {
        for (Distributor distributor : distributors) {
            cost = 0;
            for (Producer producer : distributor.getProducers()) {
                cost += (producer.getEnergyPerDistributor() * producer.getPriceKW());
            }
            long productionCost = Math.round(Math.floor(cost / CONSTANT));
            distributor.setProductionCost(productionCost);
        }
    }
}
