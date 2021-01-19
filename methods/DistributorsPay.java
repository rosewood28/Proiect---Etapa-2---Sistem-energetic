package methods;

import entities.Distributor;
import java.util.List;

public class DistributorsPay {
    /**
     * Calculare cost pentru fiecare distribuitor. Distribuitorii platesc costul calculat sau intra
     * in faliment.
     * @param distributorsList lista de distribuitori
     * @return lista de distribuitori cu bugetele actualizate
     */
    public List<Distributor> distributorsPay(final List<Distributor> distributorsList) {
        for (Distributor distributor : distributorsList) {
            long infrastructureCost = distributor.getInfrastructureCost();
            long numberConsumers = distributor.getNumberOfConsumers();
            long productionCost = distributor.getProductionCost();
            long cost = infrastructureCost + productionCost * numberConsumers;
            long initialBudget = distributor.getBudget();
            if (!distributor.getIsBankrupt()) {
                if (initialBudget >= cost) { //daca are bani, plateste
                    distributor.setBudget(initialBudget - cost);
                } else { //daca nu, da faliment
                    distributor.setBudget(initialBudget - cost);
                    distributor.setIsBankrupt(true);
                }
            }
        }
        return distributorsList;
    }
}
