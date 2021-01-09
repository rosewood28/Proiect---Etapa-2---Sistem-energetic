package input;

public class NewConsumers {
    private long id;
    private long initialBudget;
    private long monthlyIncome;

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
    public void setInitialBudget(final long budget) {
        this.initialBudget = budget;
    }

    /**
     * monthlyIncome of consumer
     * @param monthlyIncome is set
     */
    public void setMonthlyIncome(final long monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
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
    public long getInitialBudget() {
        return initialBudget;
    }

    /**
     * @return the monthlyIncome of consumer
     */
    public long getMonthlyIncome() {
        return monthlyIncome;
    }

}
