package output;

public class Contracts {
    private long consumerId;
    private long price;
    private long remainedContractMonths;

    /**
     * @param consumerId of contract
     */
    public void setConsumerId(final long consumerId) {
        this.consumerId = consumerId;
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
     * @return consumerId
     */
    public long getConsumerId() {
        return consumerId;
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
