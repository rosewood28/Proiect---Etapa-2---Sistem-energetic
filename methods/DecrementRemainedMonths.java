package methods;

import entities.Contract;

import java.util.List;

public class DecrementRemainedMonths {
    /**
     * Decrementeaza numarul de luni al fiecarui contract/
     * @param contracts lista de contracte
     */
    public void decrementRemainedMonths(final List<Contract> contracts) {
        for (Contract contract : contracts) {
            long aux = contract.getRemainedContractMonths() - 1;
            contract.setRemainedContractMonths(aux);
        }
    }

}
