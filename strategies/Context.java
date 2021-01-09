package strategies;

import entities.Producer;

import java.util.List;

public class Context {
    private Strategy strategy;

    /**
     * @param strategy strategia
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * @param producers lista de sortat
     * @return lista sortata in functie de tipul de strtegie al strategy
     */
    public List<Producer> executeStrategy(List<Producer> producers) {
        return strategy.apply(producers);
    }
}
