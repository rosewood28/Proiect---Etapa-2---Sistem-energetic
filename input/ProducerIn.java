package input;

public class ProducerIn {
    private long id;
    private String energyType;
    private long maxDistributors;
    private float priceKW;
    private long energyPerDistributor;

    /**
     * @param id of producer
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @param energyType of producer
     */
    public void setEnergyType(final String energyType) {
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
     * @return id of producer
     */
    public long getId() {
        return id;
    }

    /**
     * @return energyType of producer
     */
    public String getEnergyType() {
        return energyType;
    }

    /**
     * @return maxDistributors of producer
     */
    public long getMaxDistributors() {
        return maxDistributors;
    }

    /**
     * @return priceKW of producer
     */
    public float getPriceKW() {
        return priceKW;
    }

    /**
     * @return energyPerDistributor of producer
     */
    public long getEnergyPerDistributor() {
        return energyPerDistributor;
    }
}
