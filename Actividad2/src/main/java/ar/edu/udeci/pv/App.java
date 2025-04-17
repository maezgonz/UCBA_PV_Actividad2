package ar.edu.udeci.pv;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("n", "name", true, "Nombre del usuario");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("n")) {
                String name = cmd.getOptionValue("n");
                logger.info("El nombre ingresado es: " + name);
                System.out.println("¡Hola, " + name + "!");
            } else {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("Actividad2", options);
            }

        } catch (ParseException e) {
            logger.error("Error al parsear los argumentos", e);
        }
    }
}
