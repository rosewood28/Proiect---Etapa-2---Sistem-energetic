package newmethods;

import entities.Distributor;
import entities.Producer;
import input.ProducerChanges;
import strategies.DistributorReapply;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObserverNotify {

    /**
     * Notifica observatorii si reaplica strategia distribuitorilor daca este cazul.
     * @param producers lista tuturor producatorilor
     * @param producerChanges lista de schimbari ale producatorilor date de sistemul de simulare
     * @param observable obiectul observabil
     */
    public void observerNotify(final List<Producer> producers, final List<ProducerChanges>
                    producerChanges, final ProducerChanges observable) {
        ArrayList<Distributor> distributorsReaply = new ArrayList<>();
        if (producerChanges.size() != 0) {
            for (Producer producer : producers) {
                for (ProducerChanges producerChange : producerChanges) {
                    if (producer.getId() == producerChange.getId()) {
                        observable.setChanges(producerChange);
                        distributorsReaply.addAll(producer.getDistributors());
                    }
                }
            }
        }

        for (Distributor distributor : distributorsReaply) {
            Iterator<Producer> it = distributor.getProducers().iterator();
            while (it.hasNext()) {
                Producer distrProducer = it.next();
                for (ProducerChanges changeProducer : producerChanges) {
                    if (distrProducer.getId() == changeProducer.getId()) {
                        //sterg distribuitorul de la toti ceilalti producatori
                        distrProducer.getDistributors().remove(distributor);
                    }
                }
            }

            //reaplicare strategie pentru distribuitor
            DistributorReapply distributorReaply = new DistributorReapply();
            distributorReaply.reapplyStrategy(distributor, producers);
        }

    }
}
