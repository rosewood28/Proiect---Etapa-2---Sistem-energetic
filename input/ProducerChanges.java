package input;

public class ProducerChanges {
    private long id;
    private long energyPerDistributor;

    /**
     * @param id of producer is set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param energyPerDistributor of producer is set
     */
    public void setEnergyPerDistributor(long energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    /**
     * @return id of producer
     */
    public long getId() {
        return id;
    }

    /**
     * @return energyPerDistributor of producer
     */
    public long getEnergyPerDistributor() {
        return energyPerDistributor;
    }
}
