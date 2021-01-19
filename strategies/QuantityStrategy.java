package strategies;

import entities.Producer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuantityStrategy implements Strategy {
    private List<Producer> quantitySorted = new ArrayList<>();
    private int ret;
    private int constant = 1;
    private int negativeConstant = -1;

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
                if (p1.getEnergyPerDistributor() > p2.getEnergyPerDistributor()) {
                    ret = negativeConstant;
                } else if (p1.getEnergyPerDistributor() < p2.getEnergyPerDistributor()) {
                    ret = constant;
                } else { //daca au aceeasi cantitate, sorteaza dupa id
                    if (p1.getId() < p2.getId()) {
                        ret = negativeConstant;
                    } else if (p1.getId() > p2.getId()) {
                        ret = constant;
                    }
                }
                return ret;
            }
        });

        return quantitySorted;
    }

}
