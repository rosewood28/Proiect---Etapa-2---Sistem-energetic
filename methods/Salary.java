package methods;

import entities.Consumer;

import java.util.List;

public class Salary {
    /**
     * Adauga salariul aferent fiecarui consumator din lista.
     * @param pConsumers lista de consumatori
     * @return lista de consumatori cu salariul actualizat
     */
    public List<Consumer> getSalary(final List<Consumer> pConsumers) {
        for (Consumer consumer : pConsumers) {
            if (!consumer.getIsBankrupt()) {
                long currentBudget = consumer.getBudget();
                long monthlyIncome = consumer.getMonthlyIncome();
                consumer.setBudget(currentBudget + monthlyIncome);
            }
        }
        return pConsumers;
    }
}
