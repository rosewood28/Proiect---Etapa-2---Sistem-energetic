package entities;

public class Contract {
    private Consumer consumer;
    private Distributor distributor;
    private long price;
    private long remainedContractMonths;

    public Contract(final Consumer consumer, final Distributor distributor, final long price,
                    final long remainedContractMonths) {
        this.consumer = consumer;
        this.distributor = distributor;
        this.price = price;
        this.remainedContractMonths = remainedContractMonths;
    }

    /**
     * @param consumer that has the contract
     */
    public void setConsumer(final Consumer consumer) {
        this.consumer = consumer;
    }

    /**
     * @param distributor that offers the price of the contract
     */
    public void setDistributor(final Distributor distributor) {
        this.distributor = distributor;
    }

    /**
     * @param price of contract
     */
    public void setPrice(final long price) {
        this.price = price;
    }

    /**
     * @param remainedContractMonths of contract
     */
    public void setRemainedContractMonths(final long remainedContractMonths) {
        this.remainedContractMonths = remainedContractMonths;
    }

    /**
     * @return consumer
     */
    public Consumer getConsumer() {
        return consumer;
    }

    /**
     * @return distributor
     */
    public Distributor getDistributor() {
        return distributor;
    }

    /**
     * @return price
     */
    public long getPrice() {
        return price;
    }

    /**
     * @return remainedContractMonths
     */
    public long getRemainedContractMonths() {
        return remainedContractMonths;
    }

}
