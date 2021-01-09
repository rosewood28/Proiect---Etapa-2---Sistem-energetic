package methods;

import entities.Contract;

import java.util.List;

public class DecrementRemainedMonths {
    /**
     * decrementeaza numarul de luni al fiecarui contract
     * @param contracts lista
     */
    public void decrementRemainedMonths(final List<Contract> contracts) {
        for (Contract contract : contracts) {
            long aux = contract.getRemainedContractMonths() - 1;
            contract.setRemainedContractMonths(aux);
        }
    }

}
