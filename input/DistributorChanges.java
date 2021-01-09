package input;

public class DistributorChanges {
    private long id;
    private long infrastructureCost;

    /**
     * @param id of distributor is set
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @param infrastructureCost of distributor is set
     */
    public void setInfrastructureCost(final long infrastructureCost) {
        this.infrastructureCost  = infrastructureCost;
    }

    /**
     * @return id of distributor
     */
    public long getId() {
        return id;
    }

    /**
     * @return infrastructureCost  of distributor
     */
    public long getInfrastructureCost() {
        return infrastructureCost;
    }

}
