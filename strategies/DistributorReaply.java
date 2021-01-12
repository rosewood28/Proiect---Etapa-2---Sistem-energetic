package strategies;

import entities.Distributor;
import entities.Producer;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterInputStream;

public class DistributorReaply {
    private Context context;
    private Strategy strategy;
    private List<Producer> choosedProducers = new ArrayList<>();

    /**
     * Alege strategia in functie de distribuotor si o aplica listei de producatori
     * Distribuitorul isi alege producatori pana cand atinge cantitatea de energie necesara
     * @param distributor lista
     * @param producers lista
     */
    public void reaplyStrategy(Distributor distributor,
                                final List<Producer> producers) {

        distributor.getProducers().clear();
        switch (distributor.getProducerStrategy()) {
            case "GREEN" -> context = new Context(new GreenStrategy());
            case "PRICE" -> context = new Context(new PriceStrategy());
            case "QUANTITY" -> context = new Context(new QuantityStrategy());
            default -> System.out.println("Cazul nu reprezinta o stategie");
        }

        //sortez lista de producatori in functie de strategia distribuitorului
        List<Producer> sortedProducers = context.executeStrategy(producers);

        //adaug primul producator din lista sortata in lista distribuitorului, doar daca nu a
        //atins deja numarul maxim de distribuitori
        int i = 0;
        Producer currentProducer = sortedProducers.get(i);

        if (currentProducer.getDistributors().size() < currentProducer.getMaxDistributors()) {

            choosedProducers.add(currentProducer);

            int alreadyExists = 0;
            for (Distributor distributor1 : currentProducer.getDistributors()) {
                if (distributor1.getId() == distributor.getId()) {
                    alreadyExists = 1;
                }
            }
            if (alreadyExists != 1) {
                currentProducer.getDistributors().add(distributor);
            }

            //verific daca acest producator ii poate oferi intrega energie si daca nu, mai adaug
            //producatori
            long neededEnergy = distributor.getEnergyNeededKW();
            long offeredEnergy = sortedProducers.get(i).getEnergyPerDistributor();
            while (offeredEnergy < neededEnergy) {
                i++;
                currentProducer = sortedProducers.get(i);
                choosedProducers.add(currentProducer);
                alreadyExists = 0;
                for (Distributor distributor1 : currentProducer.getDistributors()) {
                    if (distributor1.getId() == distributor.getId()) {
                        alreadyExists = 1;
                    }
                }
                if (alreadyExists != 1) {
                    currentProducer.getDistributors().add(distributor);
                }
                offeredEnergy += currentProducer.getEnergyPerDistributor();
            }
            distributor.getProducers().addAll(choosedProducers);
            choosedProducers.clear();
        }
    }

}
