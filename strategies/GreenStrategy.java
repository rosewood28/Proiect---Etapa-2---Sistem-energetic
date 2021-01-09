package strategies;

import entities.Producer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GreenStrategy implements Strategy {
    private int ret;

    /**
     * Sorteaza lista de producatori mai intai in functie de tipul de energie, apoi dupa pret,
     * apoi dupa cantitate, apoi dupa id
     * @param producers lista initiala
     * @return lista sortata
     */
    public List<Producer> apply(final List<Producer> producers) {
        List<Producer> greenSorted = new ArrayList<>();
        greenSorted.addAll(producers);
        Collections.sort(greenSorted, new Comparator<>() {
            @Override
            public int compare(Producer p1, Producer p2) {
                if (p1.getEnergyType().isRenewable() && !p2.getEnergyType().isRenewable()) {
                    ret = 1;
                } else if (!p1.getEnergyType().isRenewable() && p2.getEnergyType().isRenewable()) {
                    ret = -1;
                } else { //daca au acelasi tip de energie, soarteaza dupa pret
                    if (p1.getPriceKW() < p2.getPriceKW()) {
                        ret = 1;
                    } else if (p1.getPriceKW() > p2.getPriceKW()) {
                        ret = -1;
                    } else { //daca au acelasi pret, sorteaza dupa energie
                        if (p1.getEnergyPerDistributor() != p2.getEnergyPerDistributor()) {
                            ret = (int)
                                    (p2.getEnergyPerDistributor() - p1.getEnergyPerDistributor());
                        } else { //daca au aceeasi cantitate, sorteaza dupa id
                            ret = (int) (p1.getId() - p2.getId());
                        }
                    }
                }
                return ret;
            }
        });

        return greenSorted;
    }

}
