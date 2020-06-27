package playground;


import java.util.logging.Logger;

public class Main {
    public static final Logger LOGGER =Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.entering("First Class", "First method");
        LOGGER.info("Start something");
        LOGGER.exiting("Second Class", "Second method");
        LOGGER.info("Finish something");

        LOGGER.severe("1 - log SEVERE ");
        LOGGER.warning("2 - log WARNING ");
        LOGGER.info("3 - log INFO ");
        LOGGER.config("1 - log CONFIG ");
        LOGGER.fine("1 - log SEVERE ");



    }
}
