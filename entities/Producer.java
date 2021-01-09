package entities;

import java.util.ArrayList;
import java.util.List;

public class Producer {
    private long id;
    private EnergyType energyType;
    private long maxDistributors;
    private float priceKW;
    private long energyPerDistributor;
    private List<Distributor> distributors = new ArrayList<>();
    private List<MonthlyStat> monthlyStats = new ArrayList<>();

    /**
     * @param id of producer
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @param energyType of producer
     */
    public void setEnergyType(final EnergyType energyType) {
        this.energyType = energyType;
    }

    /**
     * @param maxDistributors of producer
     */
    public void setMaxDistributors(final long maxDistributors) {
        this.maxDistributors = maxDistributors;
    }

    /**
     * @param priceKW of producer
     */
    public void setPriceKW(final float priceKW) {
        this.priceKW = priceKW;
    }

    /**
     * @param energyPerDistributor of producer
     */
    public void setEnergyPerDistributor(final long energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    /**
     * @param distributors of producer
     */
    public void setDistributors(List<Distributor> distributors) {
        this.distributors = distributors;
    }

    /**
     * @param monthlyStats of producer
     */
    public void setMonthlyStats(final List<MonthlyStat> monthlyStats) {
        this.monthlyStats = monthlyStats;
    }

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @return energyType
     */
    public EnergyType getEnergyType() {
        return energyType;
    }

    /**
     * @return maxDistributors
     */
    public long getMaxDistributors() {
        return maxDistributors;
    }

    /**
     * @return priceKW
     */
    public float getPriceKW() {
        return priceKW;
    }

    /**
     * @return energyPerDistributor
     */
    public long getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /**
     * @return distributors
     */
    public List<Distributor> getDistributors() {
        return distributors;
    }

    /**
     * @return monthlyStats
     */
    public List<MonthlyStat> getMonthlyStats() {
        return monthlyStats;
    }
}