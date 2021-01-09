package input;

public class DistributorIn {
    private long id;
    private long contractLength;
    private long initialBudget;
    private long initialInfrastructureCost;
    private long energyNeededKW;
    private String producerStrategy;

    /**
     * @param id of distributor is set
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @param contractLength of distributor is set
     */
    public void setContractLength(final long contractLength) {
        this.contractLength = contractLength;
    }

    /**
     * @param initialBudget of distributor is set
     */
    public void setInitialBudget(final long initialBudget) {
        this.initialBudget = initialBudget;
    }

    /**
     * @param initialInfrastructureCost of distributor is set
     */
    public void setInitialInfrastructureCost(final long initialInfrastructureCost) {
        this.initialInfrastructureCost  = initialInfrastructureCost;
    }

    /**
     * @param energyNeededKW of distributor is set
     */
    public void setEnergyNeededKW(final long energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    /**
     * @param producerStrategy of distributor is set
     */
    public void setProducerStrategy(final String producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    /**
     * @return id of distributor
     */
    public long getId() {
        return id;
    }

    /**
     * @return contractLength of distributor
     */
    public long getContractLength() {
        return contractLength;
    }

    /**
     * @return initialBudget of distributor
     */
    public long getInitialBudget() {
        return initialBudget;
    }

    /**
     * @return initialInfrastructureCost of distributor
     */
    public long getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    /**
     * @return energyNeededKW of distributor
     */
    public long getEnergyNeededKW() {
        return energyNeededKW;
    }

    /**
     * @return producerStrategy of distributor
     */
    public String getProducerStrategy() {
        return producerStrategy;
    }
}
