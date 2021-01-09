package strategies;

import entities.Producer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuantityStrategy implements Strategy {
    private List<Producer> quantitySorted = new ArrayList<>();
    private int ret;

    /**
     * Sorteaza lista de producatori descrescator dupa cantitate si apoi dupa id
     * @param producers lista initiala
     * @return lista sortata
     */
    public List<Producer> apply(final List<Producer> producers) {
        quantitySorted.addAll(producers);
        Collections.sort(quantitySorted, new Comparator<>() {
            @Override
            public int compare(Producer p1, Producer p2) {
                if (p1.getEnergyPerDistributor() != p2.getEnergyPerDistributor()) {
                    ret = (int) (p2.getEnergyPerDistributor() - p1.getEnergyPerDistributor());
                } else { //daca au aceeasi cantitate, sorteaza crescator dupa id
                    ret = (int) (p1.getId() - p2.getId());
                }
                return ret;
            }
        });

        return quantitySorted;
    }


}
