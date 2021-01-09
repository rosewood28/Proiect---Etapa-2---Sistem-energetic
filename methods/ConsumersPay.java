package methods;

import entities.Consumer;
import entities.Contract;
import entities.Distributor;
import java.util.List;

public class ConsumersPay {
    /**
     * @param contracts lista
     */
    public void consumersPay(final List<Contract> contracts) {
        for (Contract contract : contracts) {
            Consumer consumer = contract.getConsumer();
            if (consumer.getContract() != null) { //altfel exception
                long price = consumer.getContract().getPrice();
                long budget = consumer.getBudget();
                if (!consumer.getIsBankrupt()) {
                    if (consumer.getPenalty() == 0) { //daca nu are penalty
                        if (budget >= price) { //si are bani, plateste
                            consumer.setBudget(budget - price);
                        } else { //daca nu are bani, primeste amanare si penalty
                            final double constant = 1.2;
                            consumer.setPenalty((int) (constant * price));
                            consumer.setDelay(1);
                        }
                    } else { //daca are penalty
                        if (budget > (price + consumer.getPenalty())) {
                            //daca are bani, plateste tot si scapa de amanare
                            consumer.setBudget(budget - price - consumer.getPenalty());
                        } else { //daca nu are bani, da faliment
                            consumer.setIsBankrupt(true);
                        }
                    }
                }
            }

            Distributor distributor = contract.getDistributor();
            if (distributor.getContracts().size() != 0) {
                long budget = distributor.getBudget(); //bugetul pe care distribuitorul il are
                if (!consumer.getIsBankrupt()) { //daca consumatorul nu a dat faliment
                    if (consumer.getPenalty() == 0) { //verific daca are penalty
                        //daca nu are penalty, verific daca are intarziere
                        if (consumer.getDelay() == 0) {
                            //consumatorul nu are intarziere, distribuitorul primeste pretul
                            //contractului
                            distributor.setBudget(budget + contract.getPrice());
                        } else { //daca are intarziere
                            distributor.setBudget(budget);
                        }
                    } else {
                        //daca are penalty
                        long pricePenalty = contract.getPrice()
                                + consumer.getPenalty();
                        if (consumer.getBudget() > pricePenalty) {
                            distributor.setBudget(budget + contract.getPrice() + pricePenalty);
                        }
                    }
                }
            }

        }
    }
}
