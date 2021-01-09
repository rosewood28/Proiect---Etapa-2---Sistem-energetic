package newmethods;

import entities.Distributor;
import entities.MonthlyStat;
import entities.Producer;
import java.util.List;

public class MonthlyStats {
    /**
     * Adauga in lista de stari ale producatorului si starea din luna curenta
     * @param numberOfMonth numarul lunii curente
     * @param producers lista de producatori
     */
    public void saveMonthlyStat(final long numberOfMonth, final List<Producer> producers) {
        for (Producer producer : producers) {
            MonthlyStat monthlyStat = new MonthlyStat();

            monthlyStat.setMonth(numberOfMonth);
            for (Distributor distributor : producer.getDistributors()) {
                monthlyStat.getDistributorsIds().add(distributor.getId());
            }

            producer.getMonthlyStats().add(monthlyStat);
        }
    }
}