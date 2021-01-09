package methods;

import entities.Consumer;
import java.util.List;

public class VerifyConsumers {
    /**
     * verifica daca consumatorii care au intarziere au bani sa plateasca si daca nu au intra in
     * faliment
     * @param consumers lista de consumatori
     */
    public void verifyConsumers(final List<Consumer> consumers) {
        for (entities.Consumer consumer : consumers) {
            if (consumer.getDelay() == 1 && !consumer.getIsBankrupt()) { //daca are
                if (consumer.getBudget() < consumer.getPenalty()) {
                    consumer.setIsBankrupt(true);
                    consumer.setBudget(consumer.getBudget() + consumer.getMonthlyIncome());
                }
            }
        }
    }
}
