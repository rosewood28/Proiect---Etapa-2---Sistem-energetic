package entities;

import java.util.ArrayList;
import java.util.List;

public class MonthlyStat {
    private long month;
    private List<Long> distributorsIds = new ArrayList<>();

    /**
     * @param month is set
     */
    public void setMonth(final long month) {
        this.month = month;
    }

    /**
     * @param distributorsIds is set
     */
    public void setDistributorsIds(final List<Long> distributorsIds) {
        this.distributorsIds = distributorsIds;
    }

    /**
     * @return month
     */
    public long getMonth() {
        return month;
    }

    /**
     * @return distributorsIds
     */
    public List<Long> getDistributorsIds() {
        return distributorsIds;
    }
}
