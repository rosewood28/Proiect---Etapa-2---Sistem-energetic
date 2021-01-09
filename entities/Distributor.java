package entities;

import java.util.ArrayList;
import java.util.List;

public class Distributor {

    private long id;
    private long contractLength;
    private long budget;
    private long infrastructureCost;
    private long productionCost;
    private boolean isBankrupt;
    private ArrayList<Contract> contracts = new ArrayList<>();
    private long contractCost;
    private long energyNeededKW;
    private String producerStrategy;
    private long numberOfConsumers = 0; //initializez cu 0
    private List<Producer> producers = new ArrayList<>(); //producatorii alesi

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
     * @param budget of distributor is set
     */
    public void setBudget(final long budget) {
        this.budget = budget;
    }

    /**
     * @param infrastructureCost of distributor is set
     */
    public void setInfrastructureCost(final long infrastructureCost) {
        this.infrastructureCost  = infrastructureCost;
    }

    /**
     * @param productionCost  of distributor is set
     */
    public void setProductionCost(final long productionCost) {
        this.productionCost  = productionCost;
    }

    /**
     * @param isBankrupt of distributor
     */
    public void setIsBankrupt(final boolean isBankrupt) {
        this.isBankrupt = isBankrupt;
    }

    /**
     * @param contracts of the distributor
     */
    public void setContracts(final ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * @param contractCost of the distributor
     */
    public void setContractCost(final long contractCost) {
        this.contractCost = contractCost;
    }

    /**
     * @param energyNeededKW of the distributor
     */
    public void setEnergyNeededKW(final long energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    /**
     * @param producerStrategy of the distributor
     */
    public void setProducerStrategy(String producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    /**
     * @param numberOfConsumers that the distributor has conttract with
     */
    public void setNumberOfConsumers(final long numberOfConsumers) {
        this.numberOfConsumers = numberOfConsumers;
    }

    /**
     * @param producers of the distributor
     */
    public void setProducers(final ArrayList<Producer> producers) {
        this.producers = producers;
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
     * @return budget of distributor
     */
    public long getBudget() {
        return budget;
    }

    /**
     * @return infrastructureCost  of distributor
     */
    public long getInfrastructureCost() {
        return infrastructureCost;
    }

    /**
     * @return productionCost  of distributor
     */
    public long getProductionCost() {
        return productionCost;
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
    public List<Contract> getContracts() {
        return contracts;
    }

    /**
     * @return contractCost
     */
    public long getContractCost() {
        return contractCost;
    }

    /**
     * @return energyNeededKW
     */
    public long getEnergyNeededKW() {
        return energyNeededKW;
    }

    /**
     * @return producerStrategy
     */
    public String getProducerStrategy() {
        return producerStrategy;
    }

    /**
     * @return numberOfConsumers
     */
    public long getNumberOfConsumers() {
        return numberOfConsumers;
    }

    /**
     * @return choosed producers
     */
    public List<Producer> getProducers() {
        return producers;
    }
}
