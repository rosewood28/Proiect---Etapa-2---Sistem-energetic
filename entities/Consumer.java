package entities;

public class Consumer {
    private long id;
    private long budget;
    private long monthlyIncome;
    private boolean isBankrupt = false; //initializat la false
    private int penalty = 0; //initializat la 0
    private int delay = 0; //initializat la 0
    private Contract contract = null; //initializat la null

    /**
     * id of consumer
     * @param id is set
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * initialBudget of consumer
     * @param budget is set
     */
    public void setBudget(final long budget) {
        this.budget = budget;
    }

    /**
     * monthlyIncome of consumer
     * @param monthlyIncome is set
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
     * @param delay setted
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
     * @return the id of consumer
     */
    public long getId() {
        return id;
    }

    /**
     * @return the initialBudget of consumer
     */
    public long getBudget() {
        return budget;
    }

    /**
     * @return the monthlyIncome of consumer
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

}