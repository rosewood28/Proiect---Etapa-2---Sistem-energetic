package strategies;

import entities.Distributor;
import entities.Producer;
import newmethods.AddDistributor;
import newmethods.SortByStrategy;

import java.util.ArrayList;
import java.util.List;

public class DistributorReapply {
    private List<Producer> choosedProducers = new ArrayList<>();

    /**
     * Aceasta metoda se apeleaza doar in cazul in care cel putin unul dintre producatorii pe care
     * ii avea a primit un update de la sistemul de simulare.
     * Distribuitorul isi alege producatori pana cand atinge cantitatea de energie necesara.
     * @param distributor distribuitorul care isi reaplica strategia
     * @param producers lista de producatori
     */
    public void reapplyStrategy(final Distributor distributor, final List<Producer> producers) {
        distributor.getProducers().clear();
        for (Producer producer : producers) {
            if (producer.getChanges().getId() != producer.getId()) {
                producer.getDistributors().remove(distributor);
            }
        }

        SortByStrategy sorted = new SortByStrategy();
        List<Producer> sortedProducers = sorted.getSortedProducers(producers, distributor);

        //adaug primul producator din lista sortata in lista distribuitorului doar daca nu a
        //atins deja numarul maxim de distribuitori
        int i = 0;
        Producer currentProducer = sortedProducers.get(i);

        if (currentProducer.getDistributors().size() >= currentProducer.getMaxDistributors()) {
            i++;
            currentProducer = sortedProducers.get(i);
        }

        choosedProducers.add(currentProducer);
        AddDistributor aux = new AddDistributor();
        aux.addDistributor(distributor, currentProducer);

        //verific daca acest producator ii poate oferi intrega energie si daca nu, mai adaug
        //producatori
        long neededEnergy = distributor.getEnergyNeededKW();
        long offeredEnergy = sortedProducers.get(i).getEnergyPerDistributor();
        while (offeredEnergy < neededEnergy) {
            i++;
            currentProducer = sortedProducers.get(i);

            if (currentProducer.getDistributors().size() >= currentProducer.getMaxDistributors()) {
                i++;
                currentProducer = sortedProducers.get(i);
            }

            choosedProducers.add(currentProducer);
            aux.addDistributor(distributor, currentProducer);

            offeredEnergy += currentProducer.getEnergyPerDistributor();

        }

        distributor.getProducers().addAll(choosedProducers);
    }

}
