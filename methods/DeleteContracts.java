package methods;

import entities.Consumer;
import entities.Contract;
import entities.Distributor;
import java.util.List;

public class DeleteContracts {
    /**
     * Sterge contractele a caror consumator/distribuitor este bankrupt sau contractele care
     * au expirat.
     * @param contracts lista
     */
    public void deleteContracts(final List<Contract> contracts) {
        for (int i = 0; i < contracts.size(); i++) {
            Contract contract = contracts.get(i);
            Distributor distributor = contract.getDistributor();
            Consumer consumer = contract.getConsumer();
            DeleteContract auxDeleteContract = new DeleteContract();
            if (consumer.getIsBankrupt()) {
                auxDeleteContract.deleteContract(distributor, consumer, contract);
                contracts.remove(contract);
                distributor.setBudget(distributor.getBudget() - distributor.getProductionCost());
                i--;
                distributor.setNumberOfConsumers(distributor.getNumberOfConsumers() - 1);
            } else if (distributor.getIsBankrupt()) {
                auxDeleteContract.deleteContract(distributor, consumer, contract);
                contracts.remove(contract);
                i--;
            } else if (contract.getRemainedContractMonths() == 0) {
                auxDeleteContract.deleteContract(distributor, consumer, contract);
                contracts.remove(contract);
                i--;
                distributor.setNumberOfConsumers(distributor.getNumberOfConsumers() - 1);
                consumer.setOldContract(contract);
            }
        }
    }
}
