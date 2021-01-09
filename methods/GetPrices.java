package methods;
import entities.Distributor;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collections;

public class GetPrices {
    public static final long BIG_NUMBER = 1000;
    private final HashMap<Distributor, Long> prices = new HashMap<>();

    /**
     * @param distributors lista de distribuitori
     */
    public void getPricesMap(final List<Distributor> distributors) {
        for (Distributor distributor : distributors) {
            if (!distributor.getIsBankrupt()) {
                long infrastructureCost = distributor.getInfrastructureCost();
                long numberConsumers = distributor.getNumberOfConsumers(); //cons de luna trecuta
                long productionCost = distributor.getProductionCost();
                final double constant = 0.2;
                long profit = Math.round(Math.floor(constant * productionCost));
                long price;
                if (numberConsumers != 0) {
                    price = (int) Math.round(productionCost
                            + Math.floor((float) infrastructureCost / numberConsumers) + profit);
                } else {
                    price = infrastructureCost + productionCost + profit;
                }
                distributor.setContractCost(price);
                this.prices.put(distributor, price); //incarc mapul
            }
        }
    }

    /**
     * @return pretul minim din lista de preturi
     */
    public long getMinPrice() {
        return Collections.min(this.prices.values());
    }

    /**
     * @param minPrice pretul minim din lista de preturi
     * @return cel mai bun distribuitor
     */
    public Distributor getTheBestDistributor(final long minPrice) {
        Distributor ret = null;
        long minId = BIG_NUMBER;
        for (Map.Entry<Distributor, Long> mapElement : this.prices.entrySet()) {
            if (!mapElement.getKey().getIsBankrupt()) { //distr trebuie sa nu fie falimentat
                if (mapElement.getValue() == minPrice) {
                    long id = mapElement.getKey().getId();
                    if (id < minId) { //daca mai multi distribuitori au acelasi pret
                        minId = id;
                        ret = mapElement.getKey(); //aleg distribuitorul cu cel mai mic id
                    }
                }
            }
        }

        return ret;
    }


}