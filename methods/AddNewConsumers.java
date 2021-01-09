package methods;

import java.util.List;

import input.NewConsumers;
import entities.Consumer;

public class AddNewConsumers {

    public AddNewConsumers() {
    }

    /**
     * Adauga un nou consumator in lista
     * @param consumers lista de consumatori in care voi adauga
     * @param newConsumers lista de noi consumatori
     * @param number numarul de noi consumatori ce vor fi adaugati
     * @return lista de consumatori dupa adaugare
     */
    public List<Consumer> addNewConsumer(final List<Consumer> consumers,
                                         final List<NewConsumers> newConsumers, final long number) {
        if (newConsumers.isEmpty()) {
            return consumers;
        }

        for (int i = 0; i < (int) number; i++) {
            Consumer auxconsumer = new Consumer();
            NewConsumers newConsumer = newConsumers.get(i);
            auxconsumer.setId(newConsumer.getId());
            auxconsumer.setBudget(newConsumer.getInitialBudget());
            auxconsumer.setMonthlyIncome(newConsumer.getMonthlyIncome());
            auxconsumer.setContract(null);
            auxconsumer.setIsBankrupt(false);
            consumers.add(auxconsumer);
        }

        return consumers;
    }
}
