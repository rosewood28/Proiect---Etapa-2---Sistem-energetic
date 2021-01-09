package methods;

import input.DistributorChanges;
import entities.Distributor;

import java.util.List;

public class ChangeCosts {
    /**
     * schimba costurile distribuitorilor din lista
     * @param distributors lista de distribuitori
     * @param costsChanges lista de schimbari de pret
     * @return lista de distribuitori actualizata
     */
    public List<Distributor> changeCosts(final List<Distributor> distributors,
                                         final List<DistributorChanges> costsChanges) {
        for (Distributor distributor : distributors) {
            for (DistributorChanges costsChange : costsChanges) {
                if (distributor.getId() == costsChange.getId()) {
                    distributor.setInfrastructureCost(costsChange.getInfrastructureCost());
                    //distributor.setProductionCost(costsChange.getProductionCost());
                }
            }
        }
        return distributors;
    }
}
