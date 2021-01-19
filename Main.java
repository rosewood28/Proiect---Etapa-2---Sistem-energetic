import entities.Consumer;
import entities.Distributor;
import entities.Producer;
import entities.Contract;
import methods.AddNewConsumers;
import methods.ChangeCosts;
import methods.ConsumersPay;
import methods.DecrementRemainedMonths;
import methods.DeleteContracts;
import methods.DistributorsPay;
import methods.GetProductionCost;
import methods.GetPrices;
import methods.MakeContracts;
import methods.Salary;
import methods.Verify;
import input.ConsumerIn;
import input.DistributorChanges;
import input.DistributorIn;
import input.ProducerChanges;
import input.ProducerIn;
import input.NewConsumers;
import input.MonthlyUpdates;
import input.Input;
import com.fasterxml.jackson.databind.ObjectMapper;

import transform.TransformIU;

import newmethods.MonthlyStats;
import newmethods.ObserverNotify;
import strategies.ChooseProducer;
import transform.Write;

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
        List<Consumer> consumers1 = auxTransformIU.transformConsumers(consumers0);
        List<Distributor> distributors1;
        distributors1 = auxTransformIU.transformDistributors(distributors0);
        List<Producer> producers1 = auxTransformIU.transformProducers(producers0);

        //Alegere producatori
        ChooseProducer auxChooseProducer = new ChooseProducer();
        auxChooseProducer.chooseProducers(distributors1, producers1);

        //Calculare cost de productie
        GetProductionCost auxProductionCost = new GetProductionCost();
        auxProductionCost.getProductionCost(distributors1);

        //Incarc si calculez preturile
        GetPrices auxPrices = new GetPrices();
        auxPrices.getPricesMap(distributors1);

        //Calculare pret minim
        long minPrice = auxPrices.getMinPrice();
        //Gasirea celui mai bun distribuitor
        entities.Distributor bestDistributor = auxPrices.getTheBestDistributor(minPrice);

        //Consumatorii primesc salariu
        Salary auxSalary = new Salary();
        consumers1 = auxSalary.getSalary(consumers1);

        //Crearea contractelor cu cel mai bun distribuitor
        ArrayList<Contract> contracts = new ArrayList<>(); //lista cu toate contractele
        MakeContracts auxContracts = new MakeContracts();
        auxContracts.makeContracts(consumers1, bestDistributor, minPrice, contracts);

        //Platesc consumatorii
        ConsumersPay auxConsumersPay1 = new ConsumersPay();
        auxConsumersPay1.consumersPay(contracts);

        //Platesc distribuitorii
        DistributorsPay auxDistributorsPay = new DistributorsPay();
        distributors1 = auxDistributorsPay.distributorsPay(distributors1);

        //Decrementez numarul de luni
        DecrementRemainedMonths decrementRemainedMonths = new DecrementRemainedMonths();
        decrementRemainedMonths.decrementRemainedMonths(contracts);

        //Initializez actualizarile lunare
        MonthlyUpdates actualUpdate;
        List<NewConsumers> newConsumers;
        List<DistributorChanges> distributorChanges;

        //Adaugare observatori
        ProducerChanges observable = new ProducerChanges();
        for (Producer producer : producers1) {
            observable.addObserver(producer);
        }

        for (long i = 1; i <= numberOfTurns; i++) {
            //Daca toti distribuitorii au dat faliment, simularea se opreste
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
            verify.verifyConsumers(consumers1);

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

            //Stergere contracte care nu mai sunt valide
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

            //Actualizare valori date de simulare pentru producatori
            List<ProducerChanges> producerChanges;
            producerChanges = actualUpdate.getProducerChanges();

            //Se notifica observatorii
            if (producerChanges.size() != 0) {
                ObserverNotify observerNotify = new ObserverNotify();
                observerNotify.observerNotify(producers1, producerChanges, observable);
                auxProductionCost.getProductionCost(distributors1);
            }

            //Salvare monthlyStat
            MonthlyStats auxMonthlyStats = new MonthlyStats();
            auxMonthlyStats.saveMonthlyStat(i, producers1);

            //Decrementare numar de luni
            decrementRemainedMonths.decrementRemainedMonths(contracts);
        }

        //Scriere in fisier
        Write write = new Write();
        write.writeToFile(args[1], consumers1, distributors1, producers1);
    }
}
