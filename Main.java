import entities.*;
import methods.*;
import input.*;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectWriter;
import methods.TransformIO;
import methods.TransformIU;

import newmethods.MonthlyStats;
import newmethods.ObserverNotify;
import output.ConsumerOut;
import output.DistributorOut;
import output.Output;
import output.ProducerOut;
import strategies.ChooseProducer;
import strategies.DistributorReaply;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Entry point to the simulation
 */
public final class Main {

    private Main() { }

    /**
     * Main function which reads the input file and starts simulation
     *
     * @param args input and output files
     * @throws Exception might error when reading/writing/opening files, parsing JSON
     */
    public static void main(final String[] args) throws Exception {
        String inputFilename = args[0];
        //inputFilename = "checker/resources/in/complex_2.json";
        String outputFilename = args[1];

        //Citesc datele de intrare
        ObjectMapper mapIn = new ObjectMapper();
        Input input = mapIn.readValue(new File(inputFilename), Input.class);

        //Incarc datele citite
        long numberOfTurns = input.getNumberOfTurns();
        List<MonthlyUpdates> monthlyUpdates = input.getMonthlyUpdates();
        List<ConsumerIn> consumers0 = input.getInitialData().getConsumers();
        List<DistributorIn> distributors0 = input.getInitialData().getDistributors();
        List<ProducerIn> producers0 = input.getInitialData().getProducers();

        TransformIU auxTransformIU = new TransformIU();
        List<entities.Consumer> consumers1 = auxTransformIU.transformConsumers(consumers0);
        List<entities.Distributor> distributors1 =
                auxTransformIU.transformDistributors(distributors0);
        List<entities.Producer> producers1 = auxTransformIU.transformProducers(producers0);

        //alegere producatori
        ChooseProducer auxChooseProducer = new ChooseProducer();
        auxChooseProducer.chooseProducers(distributors1, producers1);

        //calculare cost de productie
        GetProductionCost auxProductionCost = new GetProductionCost();
        auxProductionCost.getProductionCost(distributors1);

        //Incarc si calculez preturile
        GetPrices auxPrices = new GetPrices();
        auxPrices.getPricesMap(distributors1);

        //Calculare pret minim
        long minPrice = auxPrices.getMinPrice();
        //Gasirea celui mai bun distribuitor
        entities.Distributor bestDistributor = auxPrices.getTheBestDistributor(minPrice);

        //Consumatorii primesc salariu, verificat si merge bine
        Salary auxSalary = new Salary();
        consumers1 = auxSalary.getSalary(consumers1);

        //Crearea contractelor cu cel mai bun distribuitor
        ArrayList<Contract> contracts = new ArrayList<>(); //lista cu toate contractele
        MakeContracts auxContracts = new MakeContracts();
        auxContracts.makeContracts(consumers1, bestDistributor, minPrice, contracts);

        //Platesc consumatorii
        ConsumersPay auxConsumersPay1 = new ConsumersPay();
        auxConsumersPay1.consumersPay(contracts);

        //Platesc distribuitorii, verificat si merge bine
        DistributorsPay auxDistributorsPay = new DistributorsPay();
        distributors1 = auxDistributorsPay.distributorsPay(distributors1);

        //decrementez numarul de luni
        DecrementRemainedMonths decrementRemainedMonths = new DecrementRemainedMonths();
        decrementRemainedMonths.decrementRemainedMonths(contracts);

        //Initializez actualizarile lunare si listele aferente acesteia
        MonthlyUpdates actualUpdate;
        List<NewConsumers> newConsumers;
        List<DistributorChanges> distributorChanges;

        ProducerChanges observable = new ProducerChanges();
        for (Producer producer : producers1) {
            observable.addObserver(producer);
        }

        for (long i = 1; i <= numberOfTurns; i++) {
            //Verific daca toti distribuitorii au dat faliment si opresc simularea in acest caz
            Verify verify = new Verify();
            long stopDistributors = verify.verifyDistributors(distributors1);
            if (stopDistributors == 1) {
                break;
            }

            //Citesc updateuri
            actualUpdate = monthlyUpdates.get((int) i - 1); //update al lunii
            newConsumers = actualUpdate.getNewConsumers(); //noii consumatori
            distributorChanges = actualUpdate.getDistributorChanges(); //schimbarile de cost

            //Adaugare noi consumatori
            AddNewConsumers aux = new AddNewConsumers();
            consumers1 = aux.addNewConsumer(consumers1, newConsumers, newConsumers.size());

            //Actualizare preturi
            ChangeCosts auxCost = new ChangeCosts();
            distributors1 = auxCost.changeCosts(distributors1, distributorChanges);

            //Verificarea starii consumatorilor
            VerifyConsumers auxVerify = new VerifyConsumers();
            auxVerify.verifyConsumers(consumers1);

            //Calculare preturi pentru luna curenta
            auxPrices = new GetPrices();
            auxPrices.getPricesMap(distributors1);

            //Calculare pret minim
            minPrice = auxPrices.getMinPrice();
            //Gasirea celui mai bun distribuitor
            bestDistributor = auxPrices.getTheBestDistributor(minPrice);

            //Consumatorii primesc salariu
            auxSalary = new Salary();
            consumers1 = auxSalary.getSalary(consumers1);

            //sterg contracte
            DeleteContracts deleteContracts = new DeleteContracts();
            deleteContracts.deleteContracts(contracts);

            //Verificare daca exista consumatori fara contracte si creare de noi contracte
            auxContracts.makeContracts(consumers1, bestDistributor, minPrice, contracts);

            //Platesc consumatorii
            ConsumersPay auxConsumersPay = new ConsumersPay();
            auxConsumersPay.consumersPay(contracts);

            //Platesc distribuitorii
            auxDistributorsPay = new DistributorsPay();
            distributors1 = auxDistributorsPay.distributorsPay(distributors1);

            //de aici e cu producatori
            List<ProducerChanges> producerChanges;
            producerChanges = actualUpdate.getProducerChanges(); //schimbarile de energie

            //se actualizează valorile citite din test pentru luna aceasta pentru producători
            if (producerChanges.size() != 0) {
                ObserverNotify observerNotify = new ObserverNotify();
                observerNotify.observerNotify(producers1, producerChanges, observable, distributors1);
                auxProductionCost.getProductionCost(distributors1);
            }

            //MonthlyStats
            MonthlyStats auxMonthlyStats = new MonthlyStats();
            auxMonthlyStats.saveMonthlyStat(i, producers1);

            //decrementez numarul de luni
            decrementRemainedMonths.decrementRemainedMonths(contracts);
            int check =1;
        }

        //Transformare distribuitori in in distribuitori out, analaog pentru consumatori
        TransformIO auxTransform = new TransformIO();
        List<DistributorOut> distributors = auxTransform.transformDistributors(distributors1);
        List<ConsumerOut> consumers = auxTransform.transformConsumers(consumers1);
        List<ProducerOut> producers = auxTransform.transformProducers(producers1);

        Output output = new Output();
        output.setConsumers(consumers);
        output.setDistributors(distributors);
        output.setEnergyProducers(producers);

        ObjectMapper mapOut = new ObjectMapper();
        ObjectWriter writer = mapOut.writer(new DefaultPrettyPrinter());

        writer.writeValue(new File(outputFilename), output);
    }
}
