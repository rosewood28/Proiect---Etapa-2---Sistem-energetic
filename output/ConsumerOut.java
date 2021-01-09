package output;

public class ConsumerOut {
    private long id;
    private boolean isBankrupt;
    private long budget;

    /**
     * @param id of consumer
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @param isBankrupt of consumer
     */
    public void setIsBankrupt(final boolean isBankrupt) {
        this.isBankrupt = isBankrupt;
    }

    /**
     * @param budget of consumer
     */
    public void setBudget(final long budget) {
        this.budget = budget;
    }

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @return isBankrupt
     */
    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    /**
     * @return budget
     */
    public long getBudget() {
        return budget;
    }
}
