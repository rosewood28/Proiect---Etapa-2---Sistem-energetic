package methods;

import entities.Distributor;
import java.util.List;

public class Verify {
    /**
     * Verifica daca toti consumatorii au dat faliment si seteaza valoarea lui ret la 1 in caz
     * afirmativ
     * @param distributors lista de distribuitori
     * @return 1 - daca toti distribuitorii au dat faliment, 0 in caz contrar
     */
    public long verifyDistributors(final List<Distributor> distributors) {
        long numberOfDistributors = distributors.size();
        long numberOfBankruptDistributors = 0;
        long ret = 0;

        for (Distributor distributor : distributors) {
            if (distributor.getIsBankrupt()) {
                numberOfBankruptDistributors++;
            }
        }

        if (numberOfDistributors == numberOfBankruptDistributors) {
            ret = 1;
        }
        return ret;
    }
}
