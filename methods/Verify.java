package methods;

import entities.Consumer;
import entities.Distributor;
import java.util.List;

public class Verify {
    /**
     * Verifica daca toti consumatorii au dat faliment si seteaza valoarea lui ret la 1 in caz
     * afirmativ.
     * @param distributors lista de distribuitori
     * @return 1 - daca toti distribuitorii au dat faliment, 0 in caz contrar
     */
    public long verifyDistributors(final List<Distributor> distributors) {
        long numberOfDistributors = distributors.size();
        long numberOfBankruptDistributors = 0;
        long ret = 0;

        for (Distributor distributor : distributors) {
            if (distributor.getIsBankrupt()) {
                numberOfBankruptDistributors++;
            }
        }

        if (numberOfDistributors == numberOfBankruptDistributors) {
            ret = 1;
        }
        return ret;
    }

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
