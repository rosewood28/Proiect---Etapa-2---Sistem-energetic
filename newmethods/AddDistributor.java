package newmethods;

import entities.Distributor;
import entities.Producer;

public class AddDistributor {
    /**
     * Metoda ajutatoare pentru ChooseProducer si DistributorReapply.
     * Adauga un distribuitor in lista de ditribuitori a producatorului doar daca acesta nu se afla
     * deja in lista.
     * @param distributor distribuitorul ce trebuie adaugat
     * @param currentProducer producatorul
     */
    public void addDistributor(Distributor distributor, Producer currentProducer) {
        int alreadyExists = 0;
        for (Distributor distributor1 : currentProducer.getDistributors()) {
            if (distributor1.getId() == distributor.getId()) {
                alreadyExists = 1;
                break;
            }
        }
        if (alreadyExists != 1) {
            currentProducer.getDistributors().add(distributor);
        }
    }
}
