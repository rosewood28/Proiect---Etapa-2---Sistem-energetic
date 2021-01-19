package strategies;

import entities.Distributor;
import entities.Producer;
import newmethods.AddDistributor;
import newmethods.SortByStrategy;

import java.util.ArrayList;
import java.util.List;

public class ChooseProducer {
    private List<Producer> choosedProducers = new ArrayList<>();

    /**
     * Alege strategia in functie de distribuitor si o aplica listei de producatori.
     * Distribuitorul isi alege producatori pana cand atinge cantitatea de energie necesara.
     * @param distributors lista de distribuitori
     * @param producers lista de producatori
     */
    public void chooseProducers(final List<Distributor> distributors,
                                                                final List<Producer> producers) {
        for (Distributor distributor : distributors) {
            SortByStrategy sorted = new SortByStrategy();
            List<Producer> sortedProducers = sorted.getSortedProducers(producers, distributor);

            //adaug primul producator din lista sortata in lista distribuitorului doar daca nu a
            //atins deja numarul maxim de distribuitori
            int i = 0;
            Producer currentProducer = sortedProducers.get(i);

            while (currentProducer.getDistributors().size()
                                                    >= currentProducer.getMaxDistributors()) {
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

                while (currentProducer.getDistributors().size()
                                        >= currentProducer.getMaxDistributors()) {
                    i++;
                    currentProducer = sortedProducers.get(i);
                }

                choosedProducers.add(currentProducer);
                aux.addDistributor(distributor, currentProducer);

                offeredEnergy += currentProducer.getEnergyPerDistributor();
            }

            distributor.getProducers().addAll(choosedProducers);
            choosedProducers.clear();
        }
    }
}
