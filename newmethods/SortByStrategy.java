package newmethods;

import entities.Distributor;
import entities.Producer;
import strategies.Context;
import strategies.GreenStrategy;
import strategies.PriceStrategy;
import strategies.QuantityStrategy;

import java.util.List;

public class SortByStrategy {
    private Context context;

    /**
     * Sorteaza lista de producatori in functie de strategia distribuitorului.
     * @param producers lista de producatori
     * @param distributor distribuitorul care alege strategia
     * @return lista de producatori sortata
     */
    public List<Producer> getSortedProducers(final List<Producer> producers,
                                             final Distributor distributor) {
        if (distributor.getProducerStrategy().equals("GREEN")) {
            context = new Context(new GreenStrategy());
        } else if (distributor.getProducerStrategy().equals("PRICE")) {
            context = new Context(new PriceStrategy());
        } else if (distributor.getProducerStrategy().equals("QUANTITY")) {
            context = new Context(new QuantityStrategy());
        }

        return context.executeStrategy(producers);
    }
}
