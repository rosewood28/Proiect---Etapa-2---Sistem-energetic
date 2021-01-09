package output;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private List<ConsumerOut> consumers = new ArrayList<>();
    private List<DistributorOut> distributors = new ArrayList<>();
    private List<ProducerOut> energyProducers = new ArrayList<>();

    /**
     * @param consumers list
     */
    public void setConsumers(final List<ConsumerOut> consumers) {
        this.consumers = consumers;
    }

    /**
     * @param distributors list
     */
    public void setDistributors(final List<DistributorOut> distributors) {
        this.distributors = distributors;
    }

    /**
     * @param energyProducers list
     */
    public void setEnergyProducers(final List<ProducerOut> energyProducers) {
        this.energyProducers = energyProducers;
    }

    /**
     * @return consumers
     */
    public List<ConsumerOut> getConsumers() {
        return consumers;
    }

    /**
     * @return distributors
     */
    public List<DistributorOut> getDistributors() {
        return distributors;
    }

    /**
     * @return energyProducers
     */
    public List<ProducerOut> getEnergyProducers() {
        return energyProducers;
    }
}
