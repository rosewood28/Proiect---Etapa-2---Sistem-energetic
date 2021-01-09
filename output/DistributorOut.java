package output;

import java.util.List;

public class DistributorOut {
    private long id;
    private long energyNeededKW;
    private long contractCost;
    private long budget;
    private String producerStrategy;
    private boolean isBankrupt;
    private List<Contracts> contracts;

    /**
     * @param id of distributor
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @param energyNeededKW of distributor
     */
    public void setEnergyNeededKW(final long energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    /**
     * @param contractCost of distributor
     */
    public void setContractCost(final long contractCost) {
        this.contractCost = contractCost;
    }

    /**
     * @param budget of distributor
     */
    public void setBudget(final long budget) {
        this.budget = budget;
    }

    /**
     * @param producerStrategy of distributor
     */
    public void setProducerStrategy(final String producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    /**
     * @param isBankrupt of distributor
     */
    public void setIsBankrupt(final boolean isBankrupt) {
        this.isBankrupt = isBankrupt;
    }

    /**
     * @param contracts  of distributor
     */
    public void setContracts(final List<Contracts> contracts) {
        this.contracts = contracts;
    }

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @return energyNeededKW
     */
    public long getEnergyNeededKW() {
        return energyNeededKW;
    }

    /**
     * @return contractCost
     */
    public long getContractCost() {
        return contractCost;
    }

    /**
     * @return budget
     */
    public long getBudget() {
        return budget;
    }

    /**
     * @return producerStrategy
     */
    public String getProducerStrategy() {
        return producerStrategy;
    }

    /**
     * @return isBankrupt
     */
    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    /**
     * @return contracts
     */
    public List<Contracts> getContracts() {
        return contracts;
    }
}
