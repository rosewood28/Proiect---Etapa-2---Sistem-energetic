package newmethods;

import entities.Distributor;
import entities.Producer;
import input.ProducerChanges;
import strategies.DistributorReaply;

import java.util.Iterator;
import java.util.List;

public class ObserverNotify {

    public void observerNotify(final List<Producer> producers, final List<ProducerChanges>
                    producerChanges, final ProducerChanges observable, final List<Distributor>
                               distributors) {
        if (producerChanges.size() != 0) {
            for (Producer producer : producers) {
                for (ProducerChanges producerChange : producerChanges) {
                    if (producer.getId() == producerChange.getId()) {
                        observable.setChanges(producerChange);
                    }
                }
            }
        }


        for (Distributor distributor : distributors) {
            Iterator<Producer> it = distributor.getProducers().iterator();
            while (it.hasNext()){
                Producer distrProducer = it.next();
                for (ProducerChanges changeProducer : producerChanges) {
                    if (distrProducer.getId() == changeProducer.getId()) {
                        //trebuie sa reaplic strategia pentru acest distribuitor
                        //dar mai intai trebuie sa il sterg de la toti ceilalti producatori
                        distrProducer.getDistributors().remove(distributor);
                    }
                }
            }
            DistributorReaply distributorReaply = new DistributorReaply();
            distributorReaply.reaplyStrategy(distributor, producers);
        }

    }
}
