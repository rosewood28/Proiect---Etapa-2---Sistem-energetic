package methods;

import entities.Consumer;
import entities.Contract;
import entities.Distributor;

public class DeleteContract {
    /**
     * @param distributor of contract
     * @param consumer of contract
     * @param contract to remove
     */
    public void deleteContract(final Distributor distributor, final Consumer consumer,
                                                                        final Contract contract) {
        distributor.getContracts().remove(contract);
        consumer.setContract(null);
    }
}
