package methods;

import entities.Consumer;
import entities.Contract;
import entities.Distributor;
import java.util.List;

public class ConsumersPay {
    /**
     * Consumatorii platesc pretul contractului curent si distribuitorii primesc acest pret.
     * @param contracts lista de contracte
     */
    public void consumersPay(final List<Contract> contracts) {
        for (Contract contract : contracts) {
            Consumer consumer = contract.getConsumer();
            if (consumer.getContract() != null) {
                long price = consumer.getContract().getPrice();
                long budget = consumer.getBudget();
                if (!consumer.getIsBankrupt()) {
                    if (consumer.getPenalty() == 0) { //daca nu are penalty
                        if (budget >= price) { //are bani, plateste
                            consumer.setBudget(budget - price);
                        } else { //nu are bani, primeste amanare si penalty
                            final double constant = 1.2;
                            consumer.setPenalty((int) (constant * price));
                            consumer.setDelay(1);
                        }
                    } else { //are penalty
                        if (contract.getRemainedContractMonths() != 0) {
                            if (budget > (price + consumer.getPenalty())) {
                                //are bani, plateste tot si scapa de amanare
                                consumer.setBudget(budget - price - consumer.getPenalty());
                                consumer.setDelay(0);
                            } else { //nu are bani, da faliment
                                consumer.setIsBankrupt(true);
                            }
                        } else if (contract.getRemainedContractMonths() == 0) {
                            if (contract.getDistributor().getId()
                                    == consumer.getOldContract().getDistributor().getId()) {
                                //noul contract este la acelasi distribuitor
                                if (budget > (price + consumer.getPenalty()
                                        + consumer.getOldContract().getPrice())) {
                                    consumer.setBudget(budget - price - consumer.getPenalty()
                                            - consumer.getOldContract().getPrice());
                                } else {
                                    consumer.setIsBankrupt(true);
                                }
                            } else {
                                //noul contract este la alt distribuitor
                                if (budget > (price + consumer.getPenalty()
                                        + consumer.getOldContract().getPrice())) {
                                    consumer.setBudget(budget - price - consumer.getPenalty()
                                            - consumer.getOldContract().getPrice());
                                    consumer.setDelay(0);
                                } else if (budget > (consumer.getOldContract().getPrice()
                                                    + consumer.getPenalty())) {
                                    consumer.setBudget(budget - consumer.getOldContract().getPrice()
                                            - consumer.getPenalty());
                                    final double constant = 1.2;
                                    consumer.setPenalty((int) (constant * price));
                                } else {
                                    consumer.setIsBankrupt(true);
                                }
                            }
                        }
                    }
                }
            }

            Distributor distributor = contract.getDistributor();
            if (distributor.getContracts().size() != 0) {
                long budget = distributor.getBudget(); //bugetul pe care distribuitorul il are
                if (!consumer.getIsBankrupt()) { //consumatorul nu a dat faliment
                    if (consumer.getPenalty() == 0) { //verific daca are penalty
                        //daca nu are penalty, verific daca are intarziere
                        if (consumer.getDelay() == 0) {
                            //consumatorul nu are intarziere, distribuitorul primeste pretul
                            //contractului
                            distributor.setBudget(budget + contract.getPrice());
                        } else { //are intarziere
                            distributor.setBudget(budget);
                        }
                    } else {
                        //are penalty
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
