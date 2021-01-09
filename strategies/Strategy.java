package strategies;

import entities.Producer;
import java.util.List;

public interface Strategy {
    /**
     * Interfata specifica strategiilor
     * @param producers lista de producatori ce trebuie sortata
     * @return lista de producatori sortata in functie de tipul de strategie al distribuitorului
     */
    List<Producer> apply(List<Producer> producers);
}
