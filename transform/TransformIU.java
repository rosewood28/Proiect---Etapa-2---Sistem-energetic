package transform;

import entities.Consumer;
import entities.Distributor;
import entities.EnergyType;
import entities.Producer;
import input.ConsumerIn;
import input.DistributorIn;
import input.ProducerIn;

import java.util.ArrayList;
import java.util.List;

public class TransformIU {
    /**
     * @param consumersIN consumatori de tip input
     * @return consumers
     */
    public List<Consumer>
    transformConsumers(final List<ConsumerIn> consumersIN) {
        List<Consumer> consumers = new ArrayList<>();

        for (ConsumerIn in : consumersIN) {
            Consumer consumer = new Consumer();
            consumer.setId(in.getId());
            consumer.setBudget(in.getInitialBudget());
            consumer.setMonthlyIncome(in.getMonthlyIncome());
            consumer.setIsBankrupt(false);
            consumer.setContract(null);
            consumers.add(consumer);
        }

        return consumers;
    }

    /**
     * @param distributorsIN distribuitori de tip distributors
     * @return distributors
     */
    public List<Distributor>
    transformDistributors(final List<DistributorIn> distributorsIN) {
        List<Distributor> distributors = new ArrayList<>();

        for (DistributorIn in : distributorsIN) {
            Distributor distributor = new Distributor(); //entities
            distributor.setId(in.getId());
            distributor.setContractLength(in.getContractLength());
            distributor.setBudget(in.getInitialBudget());
            distributor.setInfrastructureCost(in.getInitialInfrastructureCost());
            distributor.setEnergyNeededKW(in.getEnergyNeededKW());
            distributor.setProducerStrategy(in.getProducerStrategy());

            distributor.setIsBankrupt(false);
            distributors.add(distributor);
        }

        return distributors;
    }

    /**
     * @param producersIN din pachetul input
     * @return producers din pachetul entities
     */
    public List<Producer> transformProducers(final List<ProducerIn> producersIN) {
        List<Producer> producers = new ArrayList<>();

        for (ProducerIn in : producersIN) {
            Producer producer = new Producer(); //entities
            producer.setId(in.getId());

            switch (in.getEnergyType()) {
                case "WIND" -> producer.setEnergyType(EnergyType.WIND);
                case "SOLAR" -> producer.setEnergyType(EnergyType.SOLAR);
                case "HYDRO" -> producer.setEnergyType(EnergyType.HYDRO);
                case "COAL" -> producer.setEnergyType(EnergyType.COAL);
                case "NUCLEAR" -> producer.setEnergyType(EnergyType.NUCLEAR);
                default -> producer.setEnergyType(null);
            }

            producer.setMaxDistributors(in.getMaxDistributors());
            producer.setPriceKW(in.getPriceKW());
            producer.setEnergyPerDistributor(in.getEnergyPerDistributor());
            producers.add(producer);
        }

        return producers;
    }
}
