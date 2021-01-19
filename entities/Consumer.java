package entities;

public class Consumer {
    private long id;
    private long budget;
    private long monthlyIncome;
    private boolean isBankrupt = false; //initializat la false
    private int penalty = 0; //initializat la 0
    private int delay = 0; //initializat la 0
    private Contract contract = null; //initializat la null
    private Contract oldContract = null; //initializat la null

    /**
     * @param id of consumer
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @param budget of consumer
     */
    public void setBudget(final long budget) {
        this.budget = budget;
    }

    /**
     * @param monthlyIncome of consumer
     */
    public void setMonthlyIncome(final long monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    /**
     * @param isBankrupt of consumer
     */
    public void setIsBankrupt(final boolean isBankrupt) {
        this.isBankrupt = isBankrupt;
    }

    /**
     * @param penalty of consumer
     */
    public void setPenalty(final int penalty) {
        this.penalty = penalty;
    }

    /**
     * @param delay of consumer
     */
    public void setDelay(final int delay) {
        this.delay = delay;
    }

    /**
     * @param contract of consumer
     */
    public void setContract(final Contract contract) {
        this.contract = contract;
    }

    /**
     * @param oldContract of consumer
     */
    public void setOldContract(final Contract oldContract) {
        this.oldContract = oldContract;
    }

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @return initialBudget
     */
    public long getBudget() {
        return budget;
    }

    /**
     * @return monthlyIncome
     */
    public long getMonthlyIncome() {
        return monthlyIncome;
    }

    /**
     * @return isBankrupt
     */
    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    /**
     * @return penalty
     */
    public int getPenalty() {
        return penalty;
    }

    /**
     * @return delay
     */
    public int getDelay() {
        return delay;
    }

    /**
     * @return contract
     */
    public Contract getContract() {
        return contract;
    }

    /**
     * @return oldContract
     */
    public Contract getOldContract() {
        return oldContract;
    }
}
