package input;


import java.util.Observable;

public class ProducerChanges extends Observable {
    private long id;
    private long energyPerDistributor;

    public void setChanges(ProducerChanges producerChanges) {
        setChanged();
        notifyObservers(producerChanges);
    }


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
