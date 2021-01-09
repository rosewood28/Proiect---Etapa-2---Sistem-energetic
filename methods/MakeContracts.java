package methods;

import entities.Consumer;
import entities.Contract;
import entities.Distributor;

import java.util.ArrayList;
import java.util.List;

public class MakeContracts {
    /**
     * @param consumers of contract
     * @param bestDistributor of contract
     * @param minPrice of distributor
     */
    public void makeContracts(final List<Consumer> consumers, final Distributor bestDistributor,
                              final long minPrice, final ArrayList<Contract> contracts) {
        for (Consumer consumer : consumers) {
            if (consumer.getContract() == null && !consumer.getIsBankrupt()) {
                //creare contract
                Contract newContract = new Contract(consumer, bestDistributor, minPrice,
                        bestDistributor.getContractLength());

                //atribui contractul consumatorului
                consumer.setContract(newContract);

                //adaug contractul in lista de contracte a distribuitorului
                bestDistributor.getContracts().add(newContract);

                //incrementez numarul de consumatori al distribuitorului
                bestDistributor.setNumberOfConsumers(bestDistributor.getNumberOfConsumers() + 1);

                //adaug contractul in lista cu toate contractele existente in acest moment
                contracts.add(newContract);
            }
        }
    }

}
