package input;

import java.util.ArrayList;
import java.util.List;

public class InitialData {
    private List<ConsumerIn> consumers = new ArrayList<>();
    private List<DistributorIn> distributors = new ArrayList<>();
    private List<ProducerIn> producers = new ArrayList<>();

    /**
     * @param consumers is set
     */
    public void setConsumers(final List<ConsumerIn> consumers) {
        this.consumers = consumers;
    }

    /**
     * @param distributors is set
     */
    public void setDistributors(final List<DistributorIn> distributors) {
        this.distributors = distributors;
    }

    /**
     * @param producers is set
     */
    public void setProducers(List<ProducerIn> producers) {
        this.producers = producers;
    }

    /**
     * @return the consumers
     */
    public List<ConsumerIn> getConsumers() {
        return consumers;
    }

    /**
     * @return the distributors
     */
    public List<DistributorIn> getDistributors() {
        return distributors;
    }

    /**
     * @return the producers
     */
    public List<ProducerIn> getProducers() {
        return producers;
    }
}
