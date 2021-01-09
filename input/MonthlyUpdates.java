package input;

import java.util.ArrayList;
import java.util.List;

public class MonthlyUpdates {
    private List<NewConsumers> newConsumers = new ArrayList<>();
    private List<DistributorChanges> distributorChanges = new ArrayList<>();
    private List<ProducerChanges> producerChanges = new ArrayList<>();

    /**
     * @param newConsumers is set
     */
    public void setNewConsumers(final List<NewConsumers> newConsumers) {
        this.newConsumers = newConsumers;
    }

    /**
     * @param distributorChanges is set
     */
    public void setDistributorChanges(final List<DistributorChanges> distributorChanges) {
        this.distributorChanges = distributorChanges;
    }

    /**
     * @param producerChanges is set
     */
    public void setProducerChanges(final List<ProducerChanges> producerChanges) {
        this.producerChanges = producerChanges;
    }

    /**
     * @return newConsumers
     */
    public List<NewConsumers> getNewConsumers() {
        return newConsumers;
    }

    /**
     * @return distributorChanges
     */
    public List<DistributorChanges> getDistributorChanges() {
        return distributorChanges;
    }

    /**
     * @return producerChanges
     */
    public List<ProducerChanges> getProducerChanges() {
        return producerChanges;
    }
}
