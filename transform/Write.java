package transform;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import entities.Consumer;
import entities.Distributor;
import entities.Producer;
import output.ConsumerOut;
import output.DistributorOut;
import output.Output;
import output.ProducerOut;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Write {
    /**
     * Transforma distribuitori in in distribuitori out, analaog pentru consumatori si producatori.
     * Scrie in fisierul de output.
     * @param outputFilename args[1]
     * @param consumers1 rezultat in urma simularii
     * @param distributors1 rezultat in urma simularii
     * @param producers1 rezultat in urma simularii
     */
    public void writeToFile(final String outputFilename, final List<Consumer> consumers1,
                           final List<Distributor> distributors1, final List<Producer> producers1) {
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

        try {
            writer.writeValue(new File(outputFilename), output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
