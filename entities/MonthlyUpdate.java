package entities;

import input.DistributorChanges;
import input.NewConsumers;

import java.util.ArrayList;
import java.util.List;

public class MonthlyUpdate {
    private List<NewConsumers> newConsumers = new ArrayList<>();
    private List<DistributorChanges> costsChanges = new ArrayList<>();

    /**
     * @param newConsumers is set
     */
    public void setNewConsumers(final List<NewConsumers> newConsumers) {
        this.newConsumers = newConsumers;
    }

    /**
     * @param costsChanges is set
     */
    public void setCostsChanges(final List<DistributorChanges> costsChanges) {
        this.costsChanges = costsChanges;
    }

    /**
     * @return newConsumers
     */
    public List<NewConsumers> getNewConsumers() {
        return newConsumers;
    }

    /**
     * @return costChanges
     */
    public List<DistributorChanges> getCostsChanges() {
        return costsChanges;
    }
}
