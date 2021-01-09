package methods;

import entities.Consumer;
import entities.Contract;
import entities.Distributor;
import java.util.List;

public class DeleteContracts {
    /**
     * sterge contractele a caror consumator este bankrupt
     * @param contracts lista
     */
    public void deleteContracts(final List<Contract> contracts) {
        for (int i = 0; i < contracts.size(); i++) { //parcurg lista de contracte si o actualizez
            Contract contract = contracts.get(i); //contractul curent
            Distributor distributor = contract.getDistributor(); //distribuitorul aferent
            Consumer consumer = contract.getConsumer(); //consumatorul aferent
            DeleteContract auxDeleteContract = new DeleteContract();
            if (consumer.getIsBankrupt()) {
                auxDeleteContract.deleteContract(distributor, consumer, contract);
                contracts.remove(contract);
                distributor.setBudget(distributor.getBudget() - distributor.getProductionCost());
                i--; //decrementez i pentru a accesa urmatorul element deoarece cel curent a fost
                //sters si lista nu ar mai avea de unde sa continue accesarea
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
            }
        }
    }
}
