package methods;

import entities.Consumer;
import entities.Distributor;
import entities.Producer;
import entities.Contract;
import entities.MonthlyStat;
import output.ConsumerOut;
import output.Contracts;
import output.DistributorOut;
import output.ProducerOut;

import java.util.ArrayList;
import java.util.List;

public class TransformIO {
    /**
     * @param consumersIN consumatori din pachetul entities
     * @return consumatori de tip output
     */
    public List<ConsumerOut>
                        transformConsumers(final List<Consumer> consumersIN) {
        List<ConsumerOut> consumersOUT = new ArrayList<>();

        for (Consumer in : consumersIN) {
            ConsumerOut consumerOUT = new ConsumerOut();
            consumerOUT.setId(in.getId());
            consumerOUT.setBudget(in.getBudget());
            consumerOUT.setIsBankrupt(in.getIsBankrupt());
            consumersOUT.add(consumerOUT);
        }

        return consumersOUT;
    }

    /**
     * @param distributorsIN distribuitori din pachetul entities
     * @return distribuitori de tip output
     */
    public List<DistributorOut>
                        transformDistributors(final List<Distributor> distributorsIN) {
        List<DistributorOut> distributorsOUT = new ArrayList<>();

        for (Distributor in : distributorsIN) {
            DistributorOut distributorOUT = new DistributorOut();
            distributorOUT.setId(in.getId());
            distributorOUT.setEnergyNeededKW(in.getEnergyNeededKW());
            distributorOUT.setContractCost(in.getContractCost());
            distributorOUT.setBudget(in.getBudget());
            distributorOUT.setProducerStrategy(in.getProducerStrategy());
            distributorOUT.setIsBankrupt(in.getIsBankrupt());


            List<Contracts> contractsOUT = new ArrayList<>();
            for (Contract contractIN : in.getContracts()) {
                Contracts contractOUT = new Contracts();
                contractOUT.setConsumerId(contractIN.getConsumer().getId());
                contractOUT.setPrice(contractIN.getPrice());
                contractOUT.setRemainedContractMonths(contractIN.getRemainedContractMonths());
                contractsOUT.add(contractOUT);
            }

            distributorOUT.setContracts(contractsOUT);
            distributorsOUT.add(distributorOUT);
        }

        return distributorsOUT;
    }

    /**
     * @param producers lista de producatori de tranfsormat in tipul de output
     * @return lista de producatori de tip out
     */
    public List<ProducerOut> transformProducers(final List<Producer> producers) {
        List<ProducerOut> producersOut = new ArrayList<>();

        for (Producer in : producers) {
            ProducerOut producerOut = new ProducerOut();
            producerOut.setId(in.getId());
            producerOut.setMaxDistributors(in.getMaxDistributors());
            producerOut.setPriceKW(in.getPriceKW());
            producerOut.setEnergyType(in.getEnergyType().getLabel());
            producerOut.setEnergyPerDistributor(in.getEnergyPerDistributor());

            List<MonthlyStat> monthlyStatsOut = new ArrayList<>();
            for (MonthlyStat monthlyStatIn : in.getMonthlyStats()) {
                MonthlyStat monthlyStatOut = new MonthlyStat();
                monthlyStatOut.setMonth(monthlyStatIn.getMonth());
                monthlyStatOut.setDistributorsIds(monthlyStatIn.getDistributorsIds());

                monthlyStatsOut.add(monthlyStatOut);
            }

            producerOut.setMonthlyStats(monthlyStatsOut);
            producersOut.add(producerOut);
        }

        return producersOut;

    }

}
