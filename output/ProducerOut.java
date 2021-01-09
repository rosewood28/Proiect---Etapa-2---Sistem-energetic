package output;

import entities.MonthlyStat;

import java.util.List;

public class ProducerOut {
    private long id;
    private long maxDistributors;
    private float priceKW;
    private String energyType;
    private long energyPerDistributor;
    private List<MonthlyStat> monthlyStats;

    /**
     * @param id of producer
     */
    public void setId(final long id) {
        this.id = id;
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
     * @param energyType of producer
     */
    public void setEnergyType(final String energyType) {
        this.energyType = energyType;
    }

    /**
     * @param energyPerDistributor of producer
     */
    public void setEnergyPerDistributor(final long energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
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
     * @return energyType
     */
    public String getEnergyType() {
        return energyType;
    }

    /**
     * @return energyPerDistributor
     */
    public long getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /**
     * @return monthlyStats
     */
    public List<MonthlyStat> getMonthlyStats() {
        return monthlyStats;
    }
}
