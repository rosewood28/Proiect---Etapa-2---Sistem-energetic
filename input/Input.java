package input;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private long numberOfTurns;
    private InitialData initialData = new InitialData();
    private List<MonthlyUpdates> monthlyUpdates = new ArrayList<>();

    /**
     * @param numberOfTurns is set
     */
    public void setNumberOfTurns(final long numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    /**
     * @param initialData is set
     */
    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    /**
     * @param monthlyUpdates is set
     */
    public void setMonthlyUpdates(final List<MonthlyUpdates> monthlyUpdates) {
        this.monthlyUpdates = monthlyUpdates;
    }

    /**
     * @return numberOfTurns
     */
    public long getNumberOfTurns() {
        return numberOfTurns;
    }

    /**
     * @return initialData
     */
    public InitialData getInitialData() {
        return initialData;
    }

    /**
     * @return monthlyUpdates
     */
    public List<MonthlyUpdates> getMonthlyUpdates() {
        return monthlyUpdates;
    }
}
